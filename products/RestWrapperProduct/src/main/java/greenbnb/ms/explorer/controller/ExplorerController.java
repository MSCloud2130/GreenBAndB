package greenbnb.ms.explorer.controller;

import java.util.List;
import java.util.Optional;

import com.example.consumingwebservice.wsdl.ServiceSOAP;
import com.fasterxml.jackson.databind.ObjectMapper;

import greenbnb.ms.explorer.model.Review;
import greenbnb.ms.explorer.service.ProductsService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


@RestController
@RequestMapping("service")
public class ExplorerController extends WebServiceGatewaySupport{
    private String weatherURL = "http://api.weatherapi.com/v1/forecast.json";
    @Value("${weather.api}")
    private String weatherapi;

    private String restCountriesURL = "https://restcountries.com/v3.1/name/";
    
    @Autowired
    Environment environment;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    greenbnb.ms.explorer.ServiceClient serviceClient;

    private final ProductsService service;
    ExplorerController(ProductsService service){
        this.service = service;
    }

    @Bean
//    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/{serviceId}")
    public String findServiceById(@PathVariable("serviceId") String serviceId){
        ServiceSOAP response = serviceClient.getServiceById(serviceId).getService();
        ObjectMapper obj = new ObjectMapper();
        String json = "Error";
        try {
            json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
        
    }
    @GetMapping("/suppliers/{supplierId}")
    public String findServiceBySupplierId(@PathVariable("supplierId") String supplierId){
        List<ServiceSOAP> response = serviceClient.getServiceBySupplierId(supplierId).getService();
        ObjectMapper obj = new ObjectMapper();
        String json = "Error";
        try {
            json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
        
    }
    
    @GetMapping
    public String findAllServices(){
        List<ServiceSOAP> response = serviceClient.getAllServices().getService();
        ObjectMapper obj = new ObjectMapper();
        String json = "Error";
        try {
            json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    @GetMapping("/service/name/{serviceName}")
    public String findServiceByName(@PathVariable("serviceName") String serviceName){
        ServiceSOAP response = serviceClient.getServiceByName(serviceName).getService();
        ObjectMapper obj = new ObjectMapper();
        String json = "Error";
        try {
            json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;

    }

    @PostMapping("/{id_service}/reviews")
    public Review createReviewForService(@PathVariable("id_service")String id_service, @RequestBody Review review){
        review.setId_service(id_service);
        return service.createReviewForService(review);
    }

    @GetMapping("/{id_service}/reviews")
    public List<Review> searchReviewsForService(@PathVariable("id_service") String id_service){
        return service.getByIdService(id_service);
    }

    @GetMapping("/{id_service}/reviews/{id_review}")
    public Optional<Review> searchReviewById(@PathVariable("id_service") String id_service, @PathVariable("id_review") String id_review){
        return service.getById(id_review);
    }

    @DeleteMapping("/{id_service}/reviews/{id_review}")
    public void deleteReviewById(@PathVariable("id_service") String id_service, @PathVariable("id_review") String id_review){
        service.deleteReviewById(id_review);
    }

    @GetMapping("/{id_service}/info")
    public JSONObject getServiceInfo(@PathVariable("id_service") String id_service) throws ParseException {
        String rcResponse = restTemplate.getForObject(restCountriesURL + "colombia", String.class);
        String petURL =weatherURL + "?q=Bogota&days=5&aqi=no&alerts=no&key=" + weatherapi;
        String owResponse = restTemplate.getForObject(petURL, String.class);

        JSONParser parser = new JSONParser();
        JSONArray objArr = (JSONArray) parser.parse(rcResponse);
        JSONObject obj = (JSONObject) objArr.get(0);
        JSONObject wObj = (JSONObject) parser.parse(owResponse);
        obj.put("weather", wObj);
        return obj;
    }
}

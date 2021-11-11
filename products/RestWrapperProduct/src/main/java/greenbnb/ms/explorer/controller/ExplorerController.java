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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import greenbnb.ms.explorer.model.Service;
import greenbnb.ms.explorer.service.ServiceClient;
import greenbnb.ms.explorer.services.Serviceservices;

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
    ServiceClient serviceClient;
    @Autowired
    Serviceservices serviceservices;
    @Autowired
    ProductsService productService;


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
    @PostMapping("/")
    public Service createService(@RequestBody Service service ){
        System.out.println("POSTMAPPING");
        Service response = serviceservices.createService(service);
        return response;
    }
    @GetMapping("/location/{id}")
    public String serviceLocation(@PathVariable("id") String id){
        Optional<Service> result = serviceservices.findService(id);
        Service r = result.get();
        System.out.println(r.getLatitud());
        System.out.println(r.getLongitud());
        String api_key = "AIzaSyBAfD2AfFCstxKHCuNsUJFzWDeoGhtaDNg";
        String longitud =String.valueOf(r.getLongitud());
        String lat = String.valueOf(r.getLatitud()) ;
        String html = 
"        <!DOCTYPE html>" +'\n' +

"<html>" +'\n' +

"  <head>" +'\n' +

"    <title>Add Map</title>" +'\n' +


"    <style type=\"text/css\">" + '\n' +

"      /* Set the size of the div element that contains the map */"+ '\n' +

"      #map {"+ '\n' +

"        height: 400px;"+ '\n' +

"        /* The height is 400 pixels */" +'\n' +

"        width: 100%;" +'\n' +

"        /* The width is the width of the web page */"+ '\n' +

"      }"+ '\n' +

"    </style>" +'\n' +

"    <script>"+ '\n' +

"      // Initialize and add the map"+ '\n' +

"      function initMap() {"+ '\n' +

"        // The location of Uluru" +'\n' +

"        const uluru = { lat:"+lat+", lng: "+longitud  +" };"+ '\n' +

"        // The map, centered at Uluru" +'\n' +

"        const map = new google.maps.Map(document.getElementById(\"map\"), {"+ '\n' +

"          zoom: 20,"+ '\n' +

"          center: uluru," +'\n' +

"        });" +'\n' +

"        // The marker, positioned at Uluru" +'\n' +

"        const marker = new google.maps.Marker({"+ '\n' +

"          position: uluru,"+ '\n' +

"          map: map," +'\n' +

"        });"+ '\n' +

"      }"+ '\n' +

"    </script>" +'\n' +

"  </head>"+ '\n' +

"  <body>" +'\n' +

"    <h3>My Google Maps Demo</h3>" +'\n' +

"    <!--The div element for the map -->" +'\n' +

"    <div id=\"map\"></div>" +'\n' +


"    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->"+ '\n' +

"    <script"+ '\n' +

"      src=\"https://maps.googleapis.com/maps/api/js?key="+api_key+"&callback=initMap&libraries=&v=weekly\"" +'\n' +

"      async" +'\n' +

"    ></script>" +'\n' +

"  </body>" +'\n' +

"</html>" +'\n';


        return html;
    }

    @PostMapping("/{id_service}/reviews")
    public Review createReviewForService(@PathVariable("id_service")String id_service, @RequestBody Review review){
        review.setId_service(id_service);
        return productService.createReviewForService(review);
    }

    @GetMapping("/{id_service}/reviews")
    public List<Review> searchReviewsForService(@PathVariable("id_service") String id_service){
        return productService.getByIdService(id_service);
    }

    @GetMapping("/{id_service}/reviews/{id_review}")
    public Optional<Review> searchReviewById(@PathVariable("id_service") String id_service, @PathVariable("id_review") String id_review){
        return productService.getById(id_review);
    }

    @DeleteMapping("/{id_service}/reviews/{id_review}")
    public void deleteReviewById(@PathVariable("id_service") String id_service, @PathVariable("id_review") String id_review){
        productService.deleteReviewById(id_review);
    }

     @GetMapping("/{id_service}/info")
    public JSONObject getServiceInfo(@PathVariable("id_service") String id_service) throws ParseException {
        Optional<Service> result = serviceservices.findService(id_service);
        Service r = result.get();

        long days = daysBetween(r.getStartDate().substring(0, 10), r.getEndDate().substring(0, 10));

        String urlCountries = restCountriesURL + r.getCountry();
        String urlWeather = weatherURL + "?q=" + r.getCity() + "&days=" + String.valueOf(days) + "&aqi=no&alerts=no&key=" + weatherapi;

        System.out.println("countries " + urlCountries);
        System.out.println("weather " + urlWeather);

        String rcResponse = restTemplate.getForObject(urlCountries, String.class);
        String owResponse = restTemplate.getForObject(urlWeather, String.class);

        JSONParser parser = new JSONParser();
        JSONArray objArr = (JSONArray) parser.parse(rcResponse);
        JSONObject obj = (JSONObject) objArr.get(0);
        JSONObject wObj = (JSONObject) parser.parse(owResponse);
        obj.put("weather", wObj);
        return obj;
    }
    
   private long daysBetween(String start, String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1;
        Date date2;
        try{
            date1 = sdf.parse(start);
            date2 = sdf.parse(end);
            long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff;
        }catch(Exception e){

        }
        return 0;
   }

    
}

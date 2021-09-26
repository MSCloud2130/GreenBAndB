package greenbnb.ms.explorer;

import java.util.List;

import com.example.consumingwebservice.wsdl.ServiceSOAP;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@RestController
@RequestMapping("/services")
public class ExplorerController extends WebServiceGatewaySupport{
    
    @Autowired
    Environment environment;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ServiceClient serviceClient;

    @Bean
    @LoadBalanced
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

}

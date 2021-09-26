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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@RestController
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

    @GetMapping("/service/{serviceId}")
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
    @GetMapping("/service/suppliers/{supplierId}")
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
    
    @GetMapping("/service")
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
}

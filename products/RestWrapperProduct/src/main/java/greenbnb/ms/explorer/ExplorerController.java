package greenbnb.ms.explorer;

import java.util.List;
import java.util.Optional;

import com.example.consumingwebservice.wsdl.ServiceSOAP;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import greenbnb.ms.explorer.model.Service;
import greenbnb.ms.explorer.services.Serviceservices;

@RestController
@RequestMapping("service")
public class ExplorerController extends WebServiceGatewaySupport{
    
    @Autowired
    Environment environment;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ServiceClient serviceClient;
    @Autowired
    Serviceservices serviceservices;


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
}

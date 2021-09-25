package greenbnb.ms.explorer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ServiceConfiguration {
    @Autowired
    DiscoveryClient discoveryClient;

    @Bean
    public Jaxb2Marshaller marshaller() {
      Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
      // this package must match the package in the <generatePackage> specified in
      // pom.xml
      marshaller.setContextPath("com.example.consumingwebservice.wsdl");
      return marshaller;
    }
  
    @Bean
    public ServiceClient serviceClient(Jaxb2Marshaller marshaller) {
      ServiceClient client = new ServiceClient();
      String uri = discoveryClient.getInstances("db-connection").get(0).getUri().toString();
      client.setDefaultUri(uri+"/ws");
      client.setMarshaller(marshaller);
      client.setUnmarshaller(marshaller);
      return client;
    }
}

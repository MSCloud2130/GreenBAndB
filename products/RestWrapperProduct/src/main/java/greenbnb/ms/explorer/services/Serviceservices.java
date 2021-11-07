package greenbnb.ms.explorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import greenbnb.ms.explorer.model.Service;
import greenbnb.ms.explorer.repository.ServiceRepository;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@org.springframework.stereotype.Service
public class Serviceservices extends WebServiceGatewaySupport {
   @Autowired
  DiscoveryClient discoveryClient;
  @Autowired
  ServiceRepository repository;
  public Service createService(Service service){
    return repository.save(service);
  }
}

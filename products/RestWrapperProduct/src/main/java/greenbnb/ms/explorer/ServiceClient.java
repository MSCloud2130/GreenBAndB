package greenbnb.ms.explorer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetAllServicesRequest;
import com.example.consumingwebservice.wsdl.GetServiceBySupplierRequest;
import com.example.consumingwebservice.wsdl.GetServicesListResponse;
import com.example.consumingwebservice.wsdl.GetServiceRequest;
import com.example.consumingwebservice.wsdl.GetServiceResponse;

public class ServiceClient extends WebServiceGatewaySupport {

  @Autowired
  DiscoveryClient discoveryClient;
  private static final Logger log = LoggerFactory.getLogger(ServiceClient.class);

  public GetServiceResponse getServiceById(String serviceId) {

    GetServiceRequest request = new GetServiceRequest();
    request.setServiceId(serviceId);

    log.info("Requesting location for " + serviceId);
    String uri = discoveryClient.getInstances("db-connection").get(0).getUri().toString();
    GetServiceResponse response = (GetServiceResponse) getWebServiceTemplate()
        .marshalSendAndReceive(uri+"/ws/services", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetServiceRequest"));

    log.info("response to be returned " + response.getService().getName());
    return response;
  }
  public GetServicesListResponse getAllServices() {
    String uri = discoveryClient.getInstances("db-connection").get(0).getUri().toString();
    GetAllServicesRequest request = new GetAllServicesRequest();
    GetServicesListResponse response = (GetServicesListResponse) getWebServiceTemplate()
        .marshalSendAndReceive(uri+"/ws/services", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetAllServicesRequest"));

    log.info("response to be returned " + response);
    return response;
  }
  public GetServicesListResponse getServiceBySupplierId(String supplierId) {
    
    String uri = discoveryClient.getInstances("db-connection").get(0).getUri().toString();
    GetServiceBySupplierRequest request = new GetServiceBySupplierRequest();
    request.setSupplierId(supplierId);
    GetServicesListResponse response = (GetServicesListResponse) getWebServiceTemplate()
        .marshalSendAndReceive(uri+"/ws/services", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetServiceBySupplierRequest"));

    log.info("response to be returned " + response);
    return response;
  }

}


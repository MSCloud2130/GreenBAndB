package greenbnb.ms.connection;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import greenbnb.ms.connection.Entities.Service;
import greenbnb.ms.connection.Repositories.ServiceRepository;
import io.spring.guides.gs_producing_web_service.GetServiceBySupplierRequest;
import io.spring.guides.gs_producing_web_service.GetServiceRequest;
import io.spring.guides.gs_producing_web_service.GetServiceByNameRequest;
import io.spring.guides.gs_producing_web_service.GetServiceResponse;
import io.spring.guides.gs_producing_web_service.GetServicesListResponse;
import io.spring.guides.gs_producing_web_service.ServiceSOAP;


@Endpoint
public class ServiceEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	

	private ServiceRepository serviceRepository;


	@Autowired
	public ServiceEndpoint(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServiceRequest")
	@ResponsePayload
	public GetServiceResponse getService(@RequestPayload GetServiceRequest request) {
		
		/**
		 * ServiceSOAP: Service class for SOAP Service
		 * GetServiceResponse: Response for this function
		 * GetSericeRequest: Request for this function
		 * 
		 * Properties for all this classes are defined in services.xsd
		 * Auto-generated classes are defined in
		 * Connection/target/generated-sources/jaxb/io/spring/guides/gs_producing_web_service/GetServiceRequest.java
		 * 		 
		 */

		GetServiceResponse response = new GetServiceResponse();
		String id = request.getServiceId();
		List<Service> test = serviceRepository.findAll();
		System.out.println(test);
		Optional<Service> serviceDb = serviceRepository.findByServiceId(id);
		System.out.println(serviceDb.toString());
		ServiceSOAP found = new ServiceSOAP();
		if(serviceDb.isPresent()){
			found.setCategory(serviceDb.get().getCategory());
			found.setName(serviceDb.get().getName());
			found.setServiceId(serviceDb.get().getServiceId());
			found.setSupplierId(serviceDb.get().getSupplierId());
		}
		
		response.setService(found);
		System.out.println(response);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllServicesRequest")
	@ResponsePayload
	public GetServicesListResponse getAllServices() {
		
		GetServicesListResponse response = new GetServicesListResponse();
		List<Service> found = serviceRepository.findAll();
		for (Service service : found) {
			ServiceSOAP temp = new ServiceSOAP();
			temp.setCategory(service.getCategory());
			temp.setName(service.getName());
			temp.setServiceId(service.getServiceId());
			temp.setSupplierId(service.getSupplierId());
			response.getService().add(temp);
		}	
		
		System.out.println(response);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServiceBySupplierRequest")
	@ResponsePayload
	public GetServicesListResponse getServiceBySupplierId(@RequestPayload GetServiceBySupplierRequest request) {

		GetServicesListResponse response = new GetServicesListResponse();
		String id = request.getSupplierId();
		List<Service> found = serviceRepository.findBySupplierId(id);
		for (Service service : found) {
			ServiceSOAP temp = new ServiceSOAP();
			temp.setCategory(service.getCategory());
			temp.setName(service.getName());
			temp.setServiceId(service.getServiceId());
			temp.setSupplierId(service.getSupplierId());
			response.getService().add(temp);
		}	
		
		System.out.println(response);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServiceByNameRequest")
	@ResponsePayload
	public GetServiceResponse getServiceByName(@RequestPayload GetServiceByNameRequest request) {
		GetServiceResponse response = new GetServiceResponse();
		String name = request.getServiceName();

		Optional<Service> serviceDb = serviceRepository.findByName(name);

		ServiceSOAP found = new ServiceSOAP();
		if(serviceDb.isPresent()){
			found.setCategory(serviceDb.get().getCategory());
			found.setName(serviceDb.get().getName());
			found.setServiceId(serviceDb.get().getServiceId());
			found.setSupplierId(serviceDb.get().getSupplierId());
		}

		response.setService(found);
		System.out.println(response);
		return response;
	}
}

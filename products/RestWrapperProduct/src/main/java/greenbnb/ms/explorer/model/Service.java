package greenbnb.ms.explorer.model;
import org.springframework.data.annotation.Id;
public class Service {
  
  @Id
  public String serviceId;
  private String name;
  private String supplierId;
  private String startDate;
  private String endDate;
  private String category;
  private String address;
  private String vehicle;
  private String longitud;
  private String latitud;
  private String country;
  private String city;

  
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSupplierId() {
    return supplierId;
  }
  public void setSupplierId(String supplierId) {
    this.supplierId = supplierId;
  }
  public String getStartDate() {
    return startDate;
  }
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  public String getEndDate() {
    return endDate;
  }
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getVehicle() {
    return vehicle;
  }
  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }
  public String getServiceId() {
    return serviceId;
  }
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }
  public String getLongitud() {
    return longitud;
  }
  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }
  public String getLatitud() {
    return latitud;
  }
  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}

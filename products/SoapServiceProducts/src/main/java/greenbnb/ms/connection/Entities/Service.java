package greenbnb.ms.connection.Entities;
import org.springframework.data.annotation.Id;
public class Service {
    

    /**
     * Represents MongoDB Object. 
     * Class name MUST match Collection/Table name. E.g service != services
     * Attributes MUST match Document's attributes names. E.g serviceId != idService
     */

    @Id 
    public String serviceId;
    public String supplierId;
    public String name;
    public String category;
    public Service() {
    }
    public Service(String serviceId, String supplierId, String name, String category) {
        this.serviceId = serviceId;
        this.supplierId = supplierId;
        this.name = name;
        this.category = category;
    }
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Service [category=" + category + ", name=" + name + ", serviceId=" + serviceId + ", supplierId="
                + supplierId + "]";
    }
    
    
}

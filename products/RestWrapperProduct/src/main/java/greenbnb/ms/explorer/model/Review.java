package greenbnb.ms.explorer.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.annotation.Id;

@Data
public class Review {

    @Id
    private String id;

    private String userId;

    private String serviceId;
    public void setId_service(String id_service){
        this.serviceId = id_service;
    }
    private String comment;

    private Integer rating;
}

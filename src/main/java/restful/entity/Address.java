package restful.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Access(AccessType.FIELD)
public class Address {

    private String country;

    @Column
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

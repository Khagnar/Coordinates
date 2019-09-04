package restful.entity;

import javax.persistence.*;

@Embeddable
@Access(AccessType.FIELD)
public class AddressEntity {

    @Basic
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

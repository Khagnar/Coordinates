package restful.entity;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "country='" + country + '\'' +
                '}';
    }
}

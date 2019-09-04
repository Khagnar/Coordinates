package restful.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "geo_location")
public class GeoLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long geoLocationId;

    @Column(name = "osm_id")
    private long osmId;

    @Column(name = "osm_type")
    private String osmType;

    @Basic
    private String type;

    @Basic
    private double latitude;

    @Basic
    private double longitude;

    @Column(name = "display_name")
    private String displayName;

    @Embedded
    private AddressEntity address;

    public GeoLocationEntity() {
    }

    public long getGeoLocationId() {
        return geoLocationId;
    }

    public void setGeoLocationId(long geoLocationId) {
        this.geoLocationId = geoLocationId;
    }


    public long getOsmId() {
        return osmId;
    }

    public void setOsmId(long osmId) {
        this.osmId = osmId;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocationEntity that = (GeoLocationEntity) o;
        return geoLocationId == that.geoLocationId &&
                osmId == that.osmId &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(osmType, that.osmType) &&
                type.equals(that.type) &&
                displayName.equals(that.displayName) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoLocationId, osmId, osmType, type, latitude, longitude, displayName, address);
    }

    @Override
    public String toString() {
        return "GeoLocationEntity{" +
                "geoLocationId=" + geoLocationId +
                ", osmId=" + osmId +
                ", osmType='" + osmType + '\'' +
                ", type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", displayName='" + displayName + '\'' +
                ", address=" + address +
                '}';
    }
}

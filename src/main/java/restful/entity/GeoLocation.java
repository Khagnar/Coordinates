package restful.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "geo_location")
public class GeoLocation {

    private long geoLocationId;
    private long osmId;
    private String osmType;
    private String type;
    private double latitude;
    private double longitude;
    private String displayName;
    private String country;

    public GeoLocation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getGeoLocationId() {
        return geoLocationId;
    }

    public void setGeoLocationId(long geoLocationId) {
        this.geoLocationId = geoLocationId;
    }

    @Column(name = "osm_id")
    public long getOsmId() {
        return osmId;
    }

    public void setOsmId(long osmId) {
        this.osmId = osmId;
    }

    @Column(name = "osm_type")
    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column
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
        GeoLocation that = (GeoLocation) o;
        return geoLocationId == that.geoLocationId &&
                osmId == that.osmId &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                osmType.equals(that.osmType) &&
                Objects.equals(type, that.type) &&
                displayName.equals(that.displayName) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoLocationId, osmId, osmType, type, latitude, longitude, displayName, country);
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "geoLocationId=" + geoLocationId +
                ", osmId=" + osmId +
                ", osmType='" + osmType + '\'' +
                ", type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", displayName='" + displayName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

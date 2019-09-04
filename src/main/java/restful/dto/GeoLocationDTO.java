package restful.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocationDTO {

    @JsonProperty("osm_id")
    private long osmId;

    @JsonProperty("osm_type")
    private String osmType;
    private String type;

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("display_name")
    private String displayName;

    private AddressDTO address;

    public GeoLocationDTO() {
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocationDTO that = (GeoLocationDTO) o;
        return osmId == that.osmId &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(osmType, that.osmType) &&
                type.equals(that.type) &&
                displayName.equals(that.displayName) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osmId, osmType, type, latitude, longitude, displayName, address);
    }

    @Override
    public String toString() {
        return "GeoLocationDTO{" +
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


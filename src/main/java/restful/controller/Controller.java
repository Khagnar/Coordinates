package restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import restful.entity.GeoLocation;
import restful.json_object.Location;
import restful.service.GeoLocationService;
import restful.util.RequestHandler;


@org.springframework.stereotype.Controller
public class Controller {

    private GeoLocationService geoLocationService;

    @Autowired
    public void setGeoLocationService(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    @GetMapping(path = "coordinates")
    public String coordinatesForm(Model model) {
        model.addAttribute("geoLocation", new GeoLocation());
        return "index";
    }

    @PostMapping(path = "coordinates")
    public String coordinatesSubmit(@ModelAttribute GeoLocation geoLocation, Model model) {
        model.addAttribute("geoLocation", geoLocation);

        double latitude = geoLocation.getLatitude();
        double longitude = geoLocation.getLongitude();

        String result = RequestHandler.getJsonResponce(latitude, longitude);
        Location location = RequestHandler.getGeoLocation(result);

        geoLocation.setOsmId(location.getOsmId());
        geoLocation.setOsmType(location.getOsmType());
        geoLocation.setType(location.getType());
        geoLocation.setLatitude(location.getLatitude());
        geoLocation.setLongitude(location.getLongitude());
        geoLocation.setDisplayName(location.getDisplayName());
        geoLocation.setCountry(location.getAddress().getCountry());

        geoLocationService.addGeoLocation(geoLocation);

        return "result";
    }
}

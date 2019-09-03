package restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restful.entity.GeoLocation;
import restful.service.GeoLocationService;
import restful.util.RequestHandler;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "coordinates")
@org.springframework.stereotype.Controller
public class Controller {

    private GeoLocationService geoLocationService;
    private List<GeoLocation> list = new ArrayList<>();

    @Autowired
    public void setGeoLocationService(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    @GetMapping
    public String coordinatesForm(Model model) {
        model.addAttribute("geoLocation", new GeoLocation());
        return "index";
    }

    @PostMapping
    public String coordinatesSubmit(@ModelAttribute GeoLocation geoLocation, Model model) {
        model.addAttribute("geoLocation", geoLocation);

        double latitude = geoLocation.getLatitude();
        double longitude = geoLocation.getLongitude();

        String result = RequestHandler.getJsonResponce(latitude, longitude);
        geoLocation = RequestHandler.getGeoLocation(result);

        geoLocationService.addGeoLocation(geoLocation);
        list.add(geoLocation);

        return "result";
    }

    @GetMapping(path = "/list")
    public String geoLocationList() {

        return "list";
    }
}

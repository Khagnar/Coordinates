package restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restful.dto.AddressDTO;
import restful.dto.GeoLocationDTO;
import restful.service.GeoLocationService;
import restful.service.NominatimService;
import java.util.List;

@RequestMapping(path = "/")
@Controller
public class GeoLocationController {

    private GeoLocationService geoLocationService;
    private NominatimService nominatimService;

    public GeoLocationController(GeoLocationService geoLocationService, NominatimService nominatimService) {
        this.geoLocationService = geoLocationService;
        this.nominatimService = nominatimService;
    }

    @GetMapping
    public String mainPage() {
        return "main";
    }

    @GetMapping(path = "/coordinate")
    public String coordinatesForm(Model model) {
        model.addAttribute("geoLocation", new GeoLocationDTO());
        return "coordinate";
    }

    @PostMapping(path = "/coordinate")
    public String coordinatesSubmit(@ModelAttribute GeoLocationDTO geoLocationDTO, Model model) {
        model.addAttribute("geoLocation", geoLocationDTO);

        double latitude = geoLocationDTO.getLatitude();
        double longitude = geoLocationDTO.getLongitude();

        String result = nominatimService.getJsonResponse(latitude, longitude);
        geoLocationDTO = nominatimService.getGeoLocation(result);

        geoLocationService.addGeoLocation(geoLocationDTO);
        return "result";
    }

    @GetMapping(path = "/country")
    public String countryForm(Model model) {
        model.addAttribute("address", new AddressDTO());
        return "country";
    }

    @PostMapping(path = "/country")
    public String countrySubmit(@ModelAttribute AddressDTO addressDTO, Model model) {
        String country = addressDTO.getCountry();
        List<GeoLocationDTO> listDTO = geoLocationService.getAllGeoLocationsByCountry(country);
        model.addAttribute("countryList", listDTO);
        return "country_list";
    }

    @GetMapping(path = "/list")
    public String geoLocationList(Model model) {
        model.addAttribute("listDTO", geoLocationService.getAllGeoLocations());
        return "list";
    }
}

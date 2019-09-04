package restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restful.dto.GeoLocationDTO;
import restful.service.GeoLocationService;
import restful.util.RequestHandler;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "coordinates")
@Controller
public class GeoLocationController {

    private GeoLocationService geoLocationService;
//    private List<GeoLocationDTO> listDTO = new ArrayList<>();

    public GeoLocationController(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    @GetMapping
    public String coordinatesForm(Model model) {
        model.addAttribute("geoLocation", new GeoLocationDTO());
        return "index";
    }

    @PostMapping
    public String coordinatesSubmit(@ModelAttribute GeoLocationDTO geoLocationDTO, Model model) {
        model.addAttribute("geoLocation", geoLocationDTO);

        double latitude = geoLocationDTO.getLatitude();
        double longitude = geoLocationDTO.getLongitude();

        String result = RequestHandler.getJsonResponce(latitude, longitude);
        geoLocationDTO = RequestHandler.getGeoLocation(result);

        geoLocationService.addGeoLocation(geoLocationDTO);
//        listDTO.add(geoLocationDTO);

        return "result";
    }

    @GetMapping(path = "/list")
    public String geoLocationList(Model model) {
        model.addAttribute("listDTO", geoLocationService.getAllGeoLocations());
        return "list";
    }
}

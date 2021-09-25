package kg.amancompany.demo.controller;

import kg.amancompany.demo.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Data
@RequestMapping("/place")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public String displayAllPlaces(){
        return "place";
    }

    @GetMapping(value = "/create")
    public String create(){
        return "place";
    }

    @PostMapping(value = "/create")
    public String createPlace(@RequestParam MultipartFile file,@RequestParam String nameOfPlace,@RequestParam String description) {
        placeService.createPlace(file,nameOfPlace,description);
        return "redirect:/main";
    }
}

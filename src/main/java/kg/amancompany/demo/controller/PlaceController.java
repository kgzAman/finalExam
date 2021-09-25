package kg.amancompany.demo.controller;

import kg.amancompany.demo.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @PostMapping
    public String createPlace(@RequestParam MultipartFile file,@RequestParam String nameOfPlace,@RequestParam String description) throws IOException {
        placeService.createPlace(file,nameOfPlace,description);
        return "redirect:/main"
    }
}

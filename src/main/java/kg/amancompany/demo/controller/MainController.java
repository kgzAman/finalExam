package kg.amancompany.demo.controller;

import kg.amancompany.demo.entity.Place;
import kg.amancompany.demo.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Data
@RequestMapping("/main")
@AllArgsConstructor
public class MainController {

    private final PlaceService placeService;

    @GetMapping
    public String getAllPlace(Model model, Principal principal){
        List<Place> places= placeService.getAllPlace();
        model.addAttribute("places",places);
        if(principal!=null){
        model.addAttribute("principal",principal);}
        return "main";
    }

}

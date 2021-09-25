package kg.amancompany.demo.controller;

import kg.amancompany.demo.entity.Comment;
import kg.amancompany.demo.entity.Place;
import kg.amancompany.demo.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.time.LocalDate;


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
    public String create(Principal principal,Model model){
        model.addAttribute("principal",principal);
        return "place";
    }

    @PostMapping(value = "/create")
    public String createPlace(@RequestParam MultipartFile file,@RequestParam String nameOfPlace,@RequestParam String description) {
        placeService.createPlace(file,nameOfPlace,description);
        return "redirect:/main";
    }

    @GetMapping(value = "/{id}")
    public String getPlace(@PathVariable Long id, Model model,Principal principal){
       Place place= placeService.getPlaceById(id);
       model.addAttribute("principal",principal);
       model.addAttribute("place",place);
       return "plcaeId";
    }

    @PostMapping(value = "/addComment")
    public String addComment(@RequestParam Long id,@RequestParam String text,String email){
        placeService.addComment(id,text,email);
        return "redirect:/place/"+id;
    }
    @PostMapping(value = "/addPhoto/{id}")
    public String addPhoto(@PathVariable Long id,@RequestParam MultipartFile file,Principal principal){
        placeService.addPhoto(id,file,principal);
        return "redirect:/place/"+id;
    }

}

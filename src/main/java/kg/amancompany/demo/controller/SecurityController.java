package kg.amancompany.demo.controller;

import kg.amancompany.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Data
@RequestMapping("/")
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/login")
    String signIn() {
        return "login";
    }
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        if(error){
            return "redirect:/register";}
        return "login";
    }
    @PostMapping("/register")
    public String signUp(@RequestParam String password,@RequestParam String name,@RequestParam String surname,@RequestParam String email) {
        userService.createUser(password,name,surname,email);

        return "redirect:/main";
    }
}

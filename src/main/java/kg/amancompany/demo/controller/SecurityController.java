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


    @GetMapping("/error")
    public String errorPage() {

        return "error";
    }

    @GetMapping("/register")
    public String signUp() {
        return "register";
    }

    @PostMapping("/register")
    public String signUp(@RequestParam String email,@RequestParam String password,@RequestParam String name,@RequestParam String surname) {
        userService.createUser(email,password,name,surname);
        return "redirect:/main";
    }
}

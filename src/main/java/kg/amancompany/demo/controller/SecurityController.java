package kg.amancompany.demo.controller;

import kg.amancompany.demo.entity.User;
import kg.amancompany.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Data
@RequestMapping("/")
@AllArgsConstructor
public class SecurityController {

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
    String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                  RedirectAttributes attributes) {

        attributes.addFlashAttribute("user", user);
        if (bindingResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "login/sign-up";
        }

        User savedUsed = UserService.signUpUser(user);


        return "redirect:/employees/management" + savedUsed.getId();
    }
}

}

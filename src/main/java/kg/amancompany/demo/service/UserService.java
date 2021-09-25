package kg.amancompany.demo.service;

import kg.amancompany.demo.entity.User;
import kg.amancompany.demo.exceptions.UserAlreadyRegisteredException;
import kg.amancompany.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void createUser(String email,String password,String name, String surname) {
        if(userRepository.findByEmail(email).isPresent()){
            throw new UserAlreadyRegisteredException(); }
        User user= new User();
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}

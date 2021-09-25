package kg.amancompany.demo.service;

import kg.amancompany.demo.entity.User;
import kg.amancompany.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public User signUpUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyRegisteredException();
        }

        final String password = RandomStringUtils.random(8,true,true);
        final String encryptedPassword = bCryptPasswordEncoder.encode(password);

        user.setPassword(encryptedPassword);
        user.setEmail(user.getEmail().toLowerCase());

        User userWithId = userRepository.save(user);

        Employee employee = new Employee();

        user.setEmployee(employee);

        employee.setUser(user);
        employeeRepository.save(employee);

        sendConfirmationMail(user.getEmail(),password);
        return userWithId;
    }

}

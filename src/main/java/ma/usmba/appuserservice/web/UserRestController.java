package ma.usmba.appuserservice.web;

import ma.usmba.appuserservice.entities.User;
import ma.usmba.appuserservice.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/generate")
    public List<User> userList(){
        return userRepository.findAll();
    }
}

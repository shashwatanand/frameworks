package in.shahswatanand.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public User postMethodName(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("")
    public User putMethodName(@PathVariable String id, @RequestBody User newUser) {
        User oldUser = userRepository.findById(newUser.getId()).orElse(null);
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setEmail(newUser.getEmail());
        return oldUser;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        return id;
    }

}
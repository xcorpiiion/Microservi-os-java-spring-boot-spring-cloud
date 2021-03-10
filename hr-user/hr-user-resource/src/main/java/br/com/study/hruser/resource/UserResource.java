package br.com.study.hruser.resource;

import br.com.study.hruser.model.User;
import br.com.study.hruser.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        Optional<User> worker = this.repository.findById(id);
        return ResponseEntity.ok(worker.get());
    }

    @GetMapping("/search")
    public User findByEmail(@RequestParam String email) {
        User userFind = this.repository.findByEmail(email);
        return userFind;
    }
}

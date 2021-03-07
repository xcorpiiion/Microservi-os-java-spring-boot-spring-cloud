package br.com.study.hruser.resource;

import br.com.study.hruser.model.User;
import br.com.study.hruser.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        Optional<User> worker = this.repository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam() String email) {
        User userFind = this.repository.findByEmail(email);
        return ok(userFind);
    }
}

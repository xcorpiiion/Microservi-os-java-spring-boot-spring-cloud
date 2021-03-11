package br.com.study.hroauth.resource;

import br.com.study.hroauth.model.User;
import br.com.study.hroauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try {
            User userDetails = (User) service.loadUserByUsername(email);
            return ResponseEntity.ok(userDetails);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

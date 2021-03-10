package br.com.study.hroauth.service;

import br.com.hroauth.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByEmail(String email);

}

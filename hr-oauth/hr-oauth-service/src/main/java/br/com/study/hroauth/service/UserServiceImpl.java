package br.com.study.hroauth.service;

import br.com.hroauth.model.User;
import br.com.study.hroauth.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public User findByEmail(String email) {
        User user = this.userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            LOGGER.error("Email not found");
            throw new IllegalArgumentException("Email not found");
        }
        LOGGER.info("Email found");
        return user;
    }
}

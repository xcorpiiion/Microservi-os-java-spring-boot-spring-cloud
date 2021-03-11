package br.com.study.hroauth.service;

import br.com.study.hroauth.feign.UserFeignClient;
import br.com.study.hroauth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userFeignClient.findByEmail(userName);
        if (user == null) {
            LOGGER.error("Email not found");
            throw new UsernameNotFoundException("Email not found");
        }
        LOGGER.info("Email found");
        return user;
    }
}

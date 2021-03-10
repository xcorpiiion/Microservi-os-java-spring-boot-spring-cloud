package br.com.study.hroauth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.springframework.boot.SpringApplication.run;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {

    public static void main(String[] args) {
        run(HrOauthApplication.class, args);
    }

}

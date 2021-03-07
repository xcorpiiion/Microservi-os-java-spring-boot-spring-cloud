package br.com.study.hroauth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {

    public static void main(String[] args) {
        run(HrOauthApplication.class, args);
    }

}

package br.com.study.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"br.com.study.hruser"})
@EntityScan({"br.com.study.hruser"})
@EnableJpaRepositories("br.com.study.hruser")
public class HrUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }
}

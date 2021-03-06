package br.com.study.hrroll;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"br.com.study.hrroll", "br.com.study.hrroll.feignclients"})
@EntityScan({"br.com.study.hrroll", "br.com.study.hrroll.feignclients"})
public class HrPayrollApplication {

    public static void main(String[] args) {
        run(HrPayrollApplication.class, args);
    }

}

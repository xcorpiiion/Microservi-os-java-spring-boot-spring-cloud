package br.com.study.hrworker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"br.com.study.hrworker"})
@EntityScan({"br.com.study.hrworker"})
@EnableJpaRepositories("br.com.study.hrworker")
public class HrWorkerApplication {

	public static void main(String[] args) {
		run(HrWorkerApplication.class, args);
	}

}

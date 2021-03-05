package br.com.study.hrroll;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import static org.springframework.boot.SpringApplication.run;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"br.com.study.hrroll"})
@EntityScan({"br.com.study.hrroll"})
public class HrPayrollApplication {

	public static void main(String[] args) {
		run(HrPayrollApplication.class, args);
	}

}

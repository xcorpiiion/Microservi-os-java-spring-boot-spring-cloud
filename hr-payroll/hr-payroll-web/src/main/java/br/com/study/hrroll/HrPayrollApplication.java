package br.com.study.hrroll;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"br.com.study.hrroll"})
@EntityScan({"br.com.study.hrroll"})
public class HrPayrollApplication {

	public static void main(String[] args) {
		run(HrPayrollApplication.class, args);
	}

}

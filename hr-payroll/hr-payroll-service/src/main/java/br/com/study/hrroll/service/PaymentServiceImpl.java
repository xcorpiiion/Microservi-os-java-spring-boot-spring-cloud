package br.com.study.hrroll.service;

import br.com.study.hrroll.model.Payment;
import br.com.study.hrroll.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Payment findPayment(long workerId, int daysWorked) {
        LOGGER.info("Start find payment...");
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));
        Worker worker = this.restTemplate.getForObject(this.getWorkerHost() + "/workers/{id}", Worker.class,
                uriVariables);
        LOGGER.info("Payment found...");
        return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
    }

    public String getWorkerHost() {
        return workerHost;
    }
}

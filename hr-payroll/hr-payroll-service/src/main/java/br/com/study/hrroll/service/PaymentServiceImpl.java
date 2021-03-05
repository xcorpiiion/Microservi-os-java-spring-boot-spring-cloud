package br.com.study.hrroll.service;

import br.com.study.hrroll.feignclients.WorkerFeignClient;
import br.com.study.hrroll.model.Payment;
import br.com.study.hrroll.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private WorkerFeignClient workerFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Payment findPayment(long workerId, int daysWorked) {
        LOGGER.info("Start find payment...");
        Worker worker = this.workerFeignClient.findById(workerId).getBody();
        LOGGER.info("Payment found...");
        return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
    }

}

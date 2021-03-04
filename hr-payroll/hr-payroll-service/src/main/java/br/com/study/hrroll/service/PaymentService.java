package br.com.study.hrroll.service;

import br.com.study.hrroll.model.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Payment findPayment(long workerId, int daysWorked);

}

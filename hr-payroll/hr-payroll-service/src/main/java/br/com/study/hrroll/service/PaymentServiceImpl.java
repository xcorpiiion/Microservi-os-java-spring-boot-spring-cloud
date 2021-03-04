package br.com.study.hrroll.service;

import br.com.study.hrroll.model.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment findPayment(long workerId, int daysWorked) {
        return new Payment("Bob", BigDecimal.TEN, daysWorked);
    }
}

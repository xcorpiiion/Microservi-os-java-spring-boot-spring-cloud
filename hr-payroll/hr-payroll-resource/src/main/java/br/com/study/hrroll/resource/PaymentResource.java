package br.com.study.hrroll.resource;

import br.com.study.hrroll.model.Payment;
import br.com.study.hrroll.service.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentServiceImpl paymentService;

    @HystrixCommand(fallbackMethod = "findPaymentAlternative")
    @GetMapping("/{workerId}/daysWorked/{daysWorked}")
    public ResponseEntity<Payment> findPayment(@PathVariable("workerId") Long workerId,
                                               @PathVariable("daysWorked") Integer daysWorked) {
        Payment payment = this.paymentService.findPayment(workerId, daysWorked);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> findPaymentAlternative(Long workerId, Integer daysWorked) {
        Payment payment = new Payment("Brawnn", BigDecimal.valueOf(400.00), daysWorked);
        return ResponseEntity.ok(payment);
    }

}

package br.com.study.hrroll.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentDTO {

    private String name;

    private BigDecimal dailyIncome;

    private Integer daysWorked;

}

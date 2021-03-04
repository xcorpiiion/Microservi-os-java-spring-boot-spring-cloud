package br.com.study.hrroll.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Payment implements Serializable {

    private String name;

    private BigDecimal dailyIncome;

    private Integer daysWorked;

}

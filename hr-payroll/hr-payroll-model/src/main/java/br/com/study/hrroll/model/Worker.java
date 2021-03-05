package br.com.study.hrroll.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Worker{

    private Long id;

    private String name;

    private BigDecimal dailyIncome;

}

package br.com.study.hroauth.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleName;

}

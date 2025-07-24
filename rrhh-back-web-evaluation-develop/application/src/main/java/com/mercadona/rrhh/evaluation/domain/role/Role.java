package com.mercadona.rrhh.evaluation.domain.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer roleId;
    private Double ponderation;
}

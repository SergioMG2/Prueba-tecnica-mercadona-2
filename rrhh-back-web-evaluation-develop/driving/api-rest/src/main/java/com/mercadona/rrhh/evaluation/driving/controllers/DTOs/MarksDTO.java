package com.mercadona.rrhh.evaluation.driving.controllers.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarksDTO {
    private Integer mark;
    private String result;
}

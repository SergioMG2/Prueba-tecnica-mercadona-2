package com.mercadona.rrhh.evaluation.application.exceptions.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EmployeeEvaluationErrorCode {
  // 400
  // 401
  // 404
  EMPLOYEE_NOT_FOUND("pedper.cna.error.404000", HttpStatus.NOT_FOUND),

  // 406 NOT ACCEPTABLE
  // 409 CONFLICT
  // 422
  // 5XX
  GENERIC_INTERNAL_SERVER_ERROR("pedper.cna.error.500000", HttpStatus.INTERNAL_SERVER_ERROR);

  private final String code;
  private final HttpStatus status;
}

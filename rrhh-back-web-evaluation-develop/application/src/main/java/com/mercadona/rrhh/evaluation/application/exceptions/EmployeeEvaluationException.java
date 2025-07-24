package com.mercadona.rrhh.evaluation.application.exceptions;

import com.mercadona.rrhh.evaluation.application.exceptions.errorcode.EmployeeEvaluationErrorCode;
import lombok.Getter;

import java.util.List;

@Getter
public class EmployeeEvaluationException extends RuntimeException {

  private final List<String> params;
  private final EmployeeEvaluationErrorCode employeeEvaluationErrorCode;

  public EmployeeEvaluationException(EmployeeEvaluationErrorCode employeeEvaluationErrorCode) {
    super(employeeEvaluationErrorCode.getCode());

    this.employeeEvaluationErrorCode = employeeEvaluationErrorCode;
    this.params = List.of();
  }

  public EmployeeEvaluationException(EmployeeEvaluationErrorCode employeeEvaluationErrorCode, List<String> params) {
    super(employeeEvaluationErrorCode.getCode());

    this.employeeEvaluationErrorCode = employeeEvaluationErrorCode;
    this.params = params;
  }
}

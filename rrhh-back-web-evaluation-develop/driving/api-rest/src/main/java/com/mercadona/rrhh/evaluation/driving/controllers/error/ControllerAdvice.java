package com.mercadona.rrhh.evaluation.driving.controllers.error;

import com.mercadona.framework.cna.api.examples.model.ErrorResource;
import com.mercadona.rrhh.evaluation.application.exceptions.EmployeeEvaluationException;
import com.mercadona.rrhh.evaluation.application.exceptions.errorcode.EmployeeEvaluationErrorCode;
import com.mercadona.rrhh.evaluation.application.messages.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdvice {

  private final MessageService messageService;

  @ExceptionHandler(EmployeeEvaluationException.class)
  public ResponseEntity<ErrorResource> pedPerExceptionHandler(EmployeeEvaluationException pedPerException) {
    log.error("Handled exception processing request", pedPerException);
    return createResponse(pedPerException.getEmployeeEvaluationErrorCode(), pedPerException.getParams());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResource> runtimeExceptionHandler(RuntimeException ex) {
    log.error("Unhandled exception processing request", ex);
    return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, ex.getMessage(), null);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<String> handleConstraintViolation(DataIntegrityViolationException ex) {
    String message = extractConstraintMessage(ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }

  private String extractConstraintMessage(DataIntegrityViolationException ex) {
    Throwable rootCause = ex.getRootCause();
    if (rootCause != null) {
      return rootCause.getMessage();
    }
    return ex.getMessage();
  }


  private ResponseEntity<ErrorResource> createResponse(
    HttpStatus httpStatus,
    String code,
    String description,
    List<String> details
  ) {
    final ErrorResource errorResource = ErrorResource.builder()
      .code(code)
      .description(description)
      .details(details)
      .build();

    return ResponseEntity
      .status(httpStatus)
      .body(errorResource);
  }

  private ResponseEntity<ErrorResource> createResponse(EmployeeEvaluationErrorCode pedPerErrorCode, List<String> params) {
    String description;
    try {
      if (params != null && !params.isEmpty()) {
        description = messageService.generateArgumentMessageByLocale(
                pedPerErrorCode.getCode(),
                params.toArray(new String[0])
        );
      } else {
        description = messageService.generateMessageByLocale(pedPerErrorCode.getCode());
      }
    } catch (RuntimeException runtimeException) {
      description = "Description not added to message.properties";
    }

    return createResponse(pedPerErrorCode.getStatus(), pedPerErrorCode.getCode(), description, params);
  }
}



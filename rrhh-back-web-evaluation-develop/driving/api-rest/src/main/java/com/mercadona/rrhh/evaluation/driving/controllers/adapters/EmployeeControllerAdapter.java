package com.mercadona.rrhh.evaluation.driving.controllers.adapters;

import com.mercadona.rrhh.evaluation.api_server.definition.EmployeesApi;
import com.mercadona.rrhh.evaluation.api_server.model.EmployeePageResponse;
import com.mercadona.rrhh.evaluation.application.ports.driving.EmployeeServicePort;
import com.mercadona.rrhh.evaluation.driving.controllers.mappers.EmployeeDTOMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping
public class EmployeeControllerAdapter implements EmployeesApi {
  private final EmployeeServicePort service;
  private final EmployeeDTOMapper mapper;

  @Override
  public ResponseEntity<EmployeePageResponse> getEmployees(@Min(1L) @Valid Integer page, @Min(1L) @Valid Integer size) {
    var employeesPaginated = service.getAllEmployees(page, size);

    return ResponseEntity.ok(mapper.toEmployeeResourceCollectionResponse(employeesPaginated));
  }
}

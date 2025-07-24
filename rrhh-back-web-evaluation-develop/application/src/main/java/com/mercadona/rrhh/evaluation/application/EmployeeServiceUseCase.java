package com.mercadona.rrhh.evaluation.application;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driving.EmployeeServicePort;
import com.mercadona.rrhh.evaluation.application.services.EmployeeUserIdService;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceUseCase implements EmployeeServicePort {
  private final EmployeeRepositoryPort repository;
  private final EmployeeUserIdService calculateUserService;

  @Override
  public MercadonaPage<Employee> getAllEmployees(Integer pageNumber, Integer pageSize) {
    log.info("Getting all employees");
    var paginatedEmployees = repository.getAllEmployees(pageNumber, pageSize);

    Optional.ofNullable(paginatedEmployees.getContent())
      .orElseGet(List::of)
      .forEach(e -> e.setUserId(calculateUserService.calculate(e)));

    return  paginatedEmployees;
  }
}

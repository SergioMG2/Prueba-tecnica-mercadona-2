package com.mercadona.rrhh.evaluation.application.ports.driving;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;

public interface EmployeeServicePort {
  MercadonaPage<Employee> getAllEmployees(Integer pageNumber, Integer pageSize);
}

package com.mercadona.rrhh.evaluation.application.ports.driven;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;

public interface EmployeeRepositoryPort {
  MercadonaPage<Employee> getAllEmployees(Integer pageNumber, Integer pageSize);
  boolean existsByEmployeeIdAndManagedGroupId(String employeeId, String managedGroupId);
}

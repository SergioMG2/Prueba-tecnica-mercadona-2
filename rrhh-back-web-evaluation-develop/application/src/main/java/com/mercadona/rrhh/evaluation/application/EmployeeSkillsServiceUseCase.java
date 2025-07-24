package com.mercadona.rrhh.evaluation.application;

import com.mercadona.rrhh.evaluation.application.exceptions.EmployeeEvaluationException;
import com.mercadona.rrhh.evaluation.application.exceptions.errorcode.EmployeeEvaluationErrorCode;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeSkillsRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driving.EmployeeSkillsServicePort;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeSkillsServiceUseCase implements EmployeeSkillsServicePort {
  private final EmployeeSkillsRepositoryPort repository;
  private final EmployeeRepositoryPort employeeRepository;

  @Override
  public Employee getEmployeeSkills(String employeeId, String managedGroupId) {
    if (!employeeRepository.existsByEmployeeIdAndManagedGroupId(employeeId, managedGroupId)) {
      throw new EmployeeEvaluationException(EmployeeEvaluationErrorCode.EMPLOYEE_NOT_FOUND);
    }

    return repository.getEmployeeSkills(employeeId, managedGroupId);
  }
}

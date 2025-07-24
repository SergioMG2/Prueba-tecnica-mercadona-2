package com.mercadona.rrhh.evaluation.application.ports.driven;

import com.mercadona.rrhh.evaluation.domain.employee.Employee;
public interface EmployeeSkillsRepositoryPort {
  Employee getEmployeeSkills(String employeeId, String managedGroupId);
}

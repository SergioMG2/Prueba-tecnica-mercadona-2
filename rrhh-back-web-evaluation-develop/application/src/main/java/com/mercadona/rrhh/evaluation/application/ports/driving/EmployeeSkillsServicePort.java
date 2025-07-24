package com.mercadona.rrhh.evaluation.application.ports.driving;

import com.mercadona.rrhh.evaluation.domain.employee.Employee;

public interface EmployeeSkillsServicePort {
  Employee getEmployeeSkills(String employeeId, String managedGroupId);
}

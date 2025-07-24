package com.mercadona.rrhh.evaluation.application;

import com.mercadona.rrhh.evaluation.application.exceptions.EmployeeEvaluationException;
import com.mercadona.rrhh.evaluation.application.exceptions.errorcode.EmployeeEvaluationErrorCode;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeSkillsRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driven.RoleRepositoryPort;
import com.mercadona.rrhh.evaluation.application.ports.driving.EmployeeSkillsServicePort;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.domain.role.Role;
import com.mercadona.rrhh.evaluation.domain.skill.Skill;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeSkillsServiceUseCase implements EmployeeSkillsServicePort {
  private final EmployeeSkillsRepositoryPort repository;
  private final EmployeeRepositoryPort employeeRepository;
  private final RoleRepositoryPort roleRepository;

  @Override
  public Employee getEmployeeSkills(String employeeId, String managedGroupId) {
    if (!employeeRepository.existsByEmployeeIdAndManagedGroupId(employeeId, managedGroupId)) {
      throw new EmployeeEvaluationException(EmployeeEvaluationErrorCode.EMPLOYEE_NOT_FOUND);
    }

    return repository.getEmployeeSkills(employeeId, managedGroupId);
  }

  public String calculateEmployeeSkills(String empployeeId, String managedGroupId){
    Employee employee = getEmployeeSkills(empployeeId, managedGroupId);
    for (Skill skill : employee.getSkills()){
      switch (skill.getType()) {
        case "T":

          break;
        case "L":

          break;
        case "S":
          Role role = roleRepository.getRole(Integer.parseInt(employee.getRole_id()));
          role.getPonderation()

          break;
        case "N":
          break;
    }
  }


}

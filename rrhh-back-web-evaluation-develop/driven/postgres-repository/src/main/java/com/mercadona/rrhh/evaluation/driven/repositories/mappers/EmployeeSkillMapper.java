package com.mercadona.rrhh.evaluation.driven.repositories.mappers;

import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.domain.skill.Skill;
import com.mercadona.rrhh.evaluation.domain.skill.SkillName;
import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.EmployeeSkillMO;
import com.mercadona.rrhh.evaluation.driven.repositories.models.skill.SkillMO;
import com.mercadona.rrhh.evaluation.driven.repositories.models.skill.SkillNameMO;
import org.mapstruct.Mapper;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeSkillMapper {
  Skill toDomain(SkillMO mo);

  SkillName toDomain(SkillNameMO mo);

  default Employee toDomain(String employeeId, String managedGroupId, List<EmployeeSkillMO> mos) {
    if (CollectionUtils.isEmpty(mos)) {
      return null;
    }

    List<Skill> skills = mos.stream()
      .map(EmployeeSkillMO::getSkill)
      .map(this::toDomain)
      .toList();

    return Employee.builder()
      .employeeId(employeeId)
      .managedGroupId(managedGroupId)
      .skills(skills)
      .build();
  }
}

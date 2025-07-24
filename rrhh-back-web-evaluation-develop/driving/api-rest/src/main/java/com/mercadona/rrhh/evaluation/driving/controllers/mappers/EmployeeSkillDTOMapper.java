package com.mercadona.rrhh.evaluation.driving.controllers.mappers;

import com.mercadona.rrhh.evaluation.api_server.model.EmployeeSkillsResponse;
import com.mercadona.rrhh.evaluation.api_server.model.SkillResource;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.domain.skill.Skill;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface EmployeeSkillDTOMapper {
  EmployeeSkillsResponse toDTO(Employee employee);

  default List<SkillResource> toSkillResourceDTO(List<Skill> skills) {
    List<SkillResource> skillResources = new ArrayList<>();

    skills.forEach(skill -> {
      skillResources.add(SkillResource.builder()
        .skillId(skill.getSkillId())
        .name(Objects.requireNonNull(skill.getNames().stream().findFirst().orElse(null)).getName())
        .build());
    });

    return skillResources;
  }
}

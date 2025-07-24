package com.mercadona.rrhh.evaluation.domain.employee;

import com.mercadona.rrhh.evaluation.domain.skill.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Employee {
  private String employeeId;
  private String managedGroupId;
  private String name;
  private String firstSurname;
  private String secondSurname;
  private String userId;
  private List<Skill> skills;
}

package com.mercadona.rrhh.evaluation.driven.repositories.models.employee.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillMOPK implements Serializable {
  private String employeeId;
  private String managedGroupId;
  private Integer skillId;
}

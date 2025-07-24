package com.mercadona.rrhh.evaluation.driven.repositories.models.employee;

import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.pk.EmployeeSkillMOPK;
import com.mercadona.rrhh.evaluation.driven.repositories.models.skill.SkillMO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EmployeeSkillMOPK.class)
@Table(name = "topic_employee_skill")
public class EmployeeSkillMO {

  @Id
  @Column(name = "employee_id", length = 7, nullable = false)
  private String employeeId;

  @Id
  @Column(name = "managed_group_id", length = 2, nullable = false)
  private String managedGroupId;

  @Id
  @Column(name = "skill_id", nullable = false)
  private Integer skillId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "skill_id", insertable = false, updatable = false)
  private SkillMO skill;
}

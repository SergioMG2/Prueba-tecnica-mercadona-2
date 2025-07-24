package com.mercadona.rrhh.evaluation.driven.repositories.models.employee;

import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.pk.EmployeeMOPK;
import com.mercadona.rrhh.evaluation.driven.repositories.models.role.RoleMO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EmployeeMOPK.class)
@Table(name = "topic_employee")
public class EmployeeMO implements Serializable {

  @Id
  @Column(name = "employee_id", length = 7, nullable = false)
  private String employeeId;

  @Id
  @Column(name = "managed_group_id", length = 2, nullable = false)
  private String managedGroupId;

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "first_surname", length = 50)
  private String firstSurname;

  @Column(name = "second_surname", length = 50)
  private String secondSurname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", insertable = false, updatable = false)
  private RoleMO role;
}

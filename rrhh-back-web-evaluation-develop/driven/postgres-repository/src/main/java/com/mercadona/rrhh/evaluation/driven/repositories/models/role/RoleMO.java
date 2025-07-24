package com.mercadona.rrhh.evaluation.driven.repositories.models.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic_role")
public class RoleMO implements Serializable {
  @Id
  @Column(name = "role_id")
  private Integer roleId;

  @Column(name = "ponderation", nullable = false)
  private Double ponderation;
}

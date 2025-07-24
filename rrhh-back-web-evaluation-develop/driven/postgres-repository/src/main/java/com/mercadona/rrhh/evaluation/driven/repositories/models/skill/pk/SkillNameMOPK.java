package com.mercadona.rrhh.evaluation.driven.repositories.models.skill.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillNameMOPK implements Serializable {
  private Integer skillId;
  private String localeLanguageCode;
}

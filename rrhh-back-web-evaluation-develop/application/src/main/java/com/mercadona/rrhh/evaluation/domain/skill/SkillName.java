package com.mercadona.rrhh.evaluation.domain.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillName {
  private Long skillId;
  private String localeLanguageCode;
  private String name;
}

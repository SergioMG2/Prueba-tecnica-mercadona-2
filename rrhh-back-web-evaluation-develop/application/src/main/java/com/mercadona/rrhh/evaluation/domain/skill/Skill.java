package com.mercadona.rrhh.evaluation.domain.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
  private Long skillId;
  private List<SkillName> names;
}

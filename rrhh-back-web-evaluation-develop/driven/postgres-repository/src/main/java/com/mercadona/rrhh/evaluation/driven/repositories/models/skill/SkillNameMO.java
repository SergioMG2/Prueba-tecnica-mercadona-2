package com.mercadona.rrhh.evaluation.driven.repositories.models.skill;

import com.mercadona.rrhh.evaluation.driven.repositories.models.skill.pk.SkillNameMOPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SkillNameMOPK.class)
@FilterDef(
  name = "localeFilter",
  parameters = @ParamDef(name = "localeLanguageCode", type = "string"))
@Table(name = "topic_skill_names")
public class SkillNameMO {
  @Id
  @Column(name = "skill_id", nullable = false)
  private Integer skillId;

  @Id
  @Column(name = "locale_language_code", nullable = false, length = 10)
  private String localeLanguageCode;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "skill_id", insertable = false, updatable = false)
  private SkillMO skill;
}

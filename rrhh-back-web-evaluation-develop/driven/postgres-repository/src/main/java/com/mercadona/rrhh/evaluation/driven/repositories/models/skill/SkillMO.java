package com.mercadona.rrhh.evaluation.driven.repositories.models.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic_skill")
public class SkillMO {

  @Id
  @Column(name = "skill_id")
  private Integer skillId;

  @Column(name = "type", length = 1, nullable = false)
  private String type;

  @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
  @Filter(name = "localeFilter", condition = "locale_language_code = :localeLanguageCode")
  private List<SkillNameMO> names;
}

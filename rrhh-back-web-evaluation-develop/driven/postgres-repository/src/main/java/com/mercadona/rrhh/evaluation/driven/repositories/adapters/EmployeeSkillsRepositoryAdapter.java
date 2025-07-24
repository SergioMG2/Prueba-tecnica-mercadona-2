package com.mercadona.rrhh.evaluation.driven.repositories.adapters;

import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeSkillsRepositoryPort;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.driven.repositories.interfaces.EmployeeSkillsMOJpaRepository;
import com.mercadona.rrhh.evaluation.driven.repositories.mappers.EmployeeSkillMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
@Repository
@AllArgsConstructor
public class EmployeeSkillsRepositoryAdapter implements EmployeeSkillsRepositoryPort {
  private final EmployeeSkillsMOJpaRepository repository;
  private final EmployeeSkillMapper mapper;

  private final EntityManager entityManager;

  @Override
  public Employee getEmployeeSkills(String employeeId, String managedGroupId) {
    entityManager
      .unwrap(org.hibernate.Session.class)
      .enableFilter("localeFilter")
      .setParameter("localeLanguageCode", LocaleContextHolder.getLocale().toLanguageTag());

    var employeeSkills = repository.findByEmployeeIdAndManagedGroupId(employeeId, managedGroupId);

    return mapper.toDomain(employeeId, managedGroupId, employeeSkills);
  }
}

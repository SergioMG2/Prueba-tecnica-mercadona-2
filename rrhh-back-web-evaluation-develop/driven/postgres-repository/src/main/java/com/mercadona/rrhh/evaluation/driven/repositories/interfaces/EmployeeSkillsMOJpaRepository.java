package com.mercadona.rrhh.evaluation.driven.repositories.interfaces;

import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.EmployeeSkillMO;
import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.pk.EmployeeSkillMOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSkillsMOJpaRepository extends JpaRepository<EmployeeSkillMO, EmployeeSkillMOPK> {
  List<EmployeeSkillMO> findByEmployeeIdAndManagedGroupId(String employeeId, String managedGroupId);
}

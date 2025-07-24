package com.mercadona.rrhh.evaluation.driven.repositories;

import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.EmployeeMO;
import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.pk.EmployeeMOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMOJpaRepository extends JpaRepository<EmployeeMO, EmployeeMOPK> {
  boolean existsByEmployeeIdAndManagedGroupId (String employeeId, String managedGroupId);
}

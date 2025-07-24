package com.mercadona.rrhh.evaluation.driven.repositories.adapters;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.lib.repository.builders.MercadonaPageBuilder;
import com.mercadona.rrhh.evaluation.application.ports.driven.EmployeeRepositoryPort;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.driven.repositories.EmployeeMOJpaRepository;
import com.mercadona.rrhh.evaluation.driven.repositories.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements EmployeeRepositoryPort {
  private final EmployeeMOJpaRepository repository;
  private final EmployeeMapper mapper;

  private final MercadonaPageBuilder pageBuilder;

  @Override
  public MercadonaPage<Employee> getAllEmployees(Integer pageNumber, Integer pageSize) {
    var employees = repository.findAll(getPageable(pageNumber, pageSize)).map(mapper::toDomain);

    return MercadonaPage.of(employees);
  }

  @Override
  public boolean existsByEmployeeIdAndManagedGroupId(String employeeId, String managedGroupId) {
    return repository.existsByEmployeeIdAndManagedGroupId(employeeId, managedGroupId);
  }

  private Pageable getPageable(Integer page, Integer size) {
    return pageBuilder.builder()
      .page(page)
      .pageSize(size)
      .build();
  }
}

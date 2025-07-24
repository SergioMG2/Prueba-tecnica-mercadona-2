package com.mercadona.rrhh.evaluation.driven.repositories.mappers;

import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import com.mercadona.rrhh.evaluation.driven.repositories.models.employee.EmployeeMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
  Employee toDomain(EmployeeMO employeeMO);
}

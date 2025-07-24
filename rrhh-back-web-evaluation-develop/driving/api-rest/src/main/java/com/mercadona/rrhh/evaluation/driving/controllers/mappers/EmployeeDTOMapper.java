package com.mercadona.rrhh.evaluation.driving.controllers.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.rrhh.evaluation.api_server.model.EmployeePageResponse;
import com.mercadona.rrhh.evaluation.api_server.model.EmployeeResource;
import com.mercadona.rrhh.evaluation.domain.employee.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { MercadonaPageResponseBuilder.class })
public abstract class EmployeeDTOMapper {

  public EmployeePageResponse toEmployeeResourceCollectionResponse(MercadonaPage<Employee> employeePage) {

    var pagination = Pagination
      .builder()
      .requestedPage(employeePage.getNumber())
      .requestedSize(employeePage.getSize())
      .retrievedResults(employeePage.getNumberOfElements())
      .totalResults(employeePage.getTotalElements())
      .build();

    var employeeData = toEmployeesResource(employeePage.getContent());

    return EmployeePageResponse
      .builder()
      .data(employeeData)
      .pagination(pagination)
      .build();
  }

  public abstract List<EmployeeResource> toEmployeesResource (List<Employee> employees);
  public abstract EmployeeResource toEmployeeResource(Employee employee);
}

package com.mercadona.rrhh.evaluation.driving.controllers.adapters;

import com.mercadona.rrhh.evaluation.api_server.definition.ManagedGroupsApi;
import com.mercadona.rrhh.evaluation.api_server.model.EmployeeSkillsResponse;
import com.mercadona.rrhh.evaluation.application.ports.driving.EmployeeSkillsServicePort;
import com.mercadona.rrhh.evaluation.driving.controllers.mappers.EmployeeSkillDTOMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping
public class EmployeeSkillControllerAdapter implements ManagedGroupsApi {
  private final EmployeeSkillsServicePort service;
  private final EmployeeSkillDTOMapper mapper;

  @Override
  @Transactional(readOnly = true)
  public ResponseEntity<EmployeeSkillsResponse> getEmployeeSkills(@Size(max = 2) String managedGroupId,
                                                                  @Size(max = 7) String employeeId) {
    var employeeSkills = service.getEmployeeSkills(employeeId, managedGroupId);

    return ResponseEntity.ok(mapper.toDTO(employeeSkills));
  }
}

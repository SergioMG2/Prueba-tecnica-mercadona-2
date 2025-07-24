package com.mercadona.rrhh.evaluation.driven.repositories.mappers;

import com.mercadona.rrhh.evaluation.domain.role.Role;
import com.mercadona.rrhh.evaluation.driven.repositories.models.role.RoleMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role fromModel(RoleMO roleMO);
    RoleMO toModel(Role role);
}

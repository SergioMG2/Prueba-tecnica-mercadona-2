package com.mercadona.rrhh.evaluation.driven.repositories.adapters;

import com.mercadona.rrhh.evaluation.application.ports.driven.RoleRepositoryPort;
import com.mercadona.rrhh.evaluation.domain.role.Role;
import com.mercadona.rrhh.evaluation.driven.repositories.interfaces.RoleMOJpaRepository;
import com.mercadona.rrhh.evaluation.driven.repositories.mappers.RoleMapper;
import com.mercadona.rrhh.evaluation.driven.repositories.models.role.RoleMO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class RoleRepositoryAdapter implements RoleRepositoryPort {
    private final RoleMOJpaRepository repository;
    private final RoleMapper mapper;

    @Override
    public Role getRole(Integer roleId){
        RoleMO roleMO = repository.findRoleByRoleId(roleId);
        return mapper.fromModel(roleMO);
    }
}

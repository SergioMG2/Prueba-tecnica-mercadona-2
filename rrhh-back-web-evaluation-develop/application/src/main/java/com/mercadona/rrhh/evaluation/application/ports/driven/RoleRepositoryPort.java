package com.mercadona.rrhh.evaluation.application.ports.driven;

import com.mercadona.rrhh.evaluation.domain.role.Role;

public interface RoleRepositoryPort {
    Role getRole(Integer roleId);
}

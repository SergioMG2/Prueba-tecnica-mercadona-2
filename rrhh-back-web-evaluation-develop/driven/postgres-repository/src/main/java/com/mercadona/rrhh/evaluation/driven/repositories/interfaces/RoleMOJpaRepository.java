package com.mercadona.rrhh.evaluation.driven.repositories.interfaces;

import com.mercadona.rrhh.evaluation.driven.repositories.models.role.RoleMO;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMOJpaRepository {
    RoleMO findRoleByRoleId(Integer roleId);
}

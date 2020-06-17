package com.brycen.hrm.repository.empRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empRole.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}

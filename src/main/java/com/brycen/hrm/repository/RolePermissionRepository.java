package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.RolePermission;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer>{

}

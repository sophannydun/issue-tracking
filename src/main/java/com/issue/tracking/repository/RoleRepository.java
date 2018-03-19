package com.issue.tracking.repository;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.issue.tracking.model.Role;

@Repository
public interface RoleRepository {
	@Insert("insert into tblRole(roleID,roleName,roleCode,createBy,updateBy,createDate,updateDate) value (#{roleID},#{roleName},#{roleCode},#{createBy},#{updateBy},#{createDate},#{updateDate})")
	public boolean save(Role role);
}

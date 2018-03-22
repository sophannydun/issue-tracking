package com.issue.tracking.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.issue.tracking.model.Role;

@Repository
public interface RoleRepository {
	@Select("select * from tb_role")
	public List<Role> findAll();
	
	@Insert("INSERT INTO `tb_role`(`roleName`, `roleCode`, `createBy`, `updateBy`, `createDate`, `updateDate`) "
			+ "VALUES (#{roleName},#{roleCode},#{createBy},#{updateBy},#{createDate},#{updateDate})")
	public boolean save(Role role);
	
	@Select("SELECT `roleID`, `roleName`, `roleCode`, `createBy`, `updateBy`, `createDate`, `updateDate` FROM `tb_role` WHERE roleID=#{id}")
	public Role findRoleById(Integer id);
	
	@Delete("DELETE FROM tb_role WHERE roleID=#{id}")
	public boolean remove(@Param("id") Integer id);
	
	@Update("UPDATE `tb_role` SET `roleName`=#{roleName},`roleCode`=#{roleCode},`createBy`=#{createBy},"
			+ "`updateBy`=#{updateBy},`createDate`=#{createDate},`updateDate`=#{updateDate} WHERE roleID=#{roleID}")
	public boolean update(Role role);
	
}

package com.erich.saleticket.dao.sys;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysUserRole;

@DAO
public interface SysUserRoleDAO {

	@SQL("select  user_role_id, user_id, role_id, create_date, create_user_id, create_user_name from sys_user_role "
			+ " where 1=1 #if(!empty(:1.userId)){ and user_id=:1.userId } #if(!empty(:1.roleId)){ and role_id=:1.roleId } "
			+ " #if(!empty(:2)){ #if(!empty(:2.orderField)){ order by user_role_id desc } } ")
	public List<SysUserRole> selectByCriteria(SysUserRole sysUserRole, Pager pager);

	@SQL(" insert into sys_user_role(user_id,role_id, create_date,create_user_id,create_user_name) "
			+ "values(:1.userId,:1.roleId, :1.createDate,:1.createUserId,:1.createUserName)")
	public int insert(SysUserRole sysUserRole);
	
@SQL("select * from user_id,role_id,create_date,sys_user_role" )
	public String s(SysUserRole sysUserRole ,Pager pager);
	
	@SQL("select user_role_id, user_id, role_id, create_date, create_user_id, create_user_name from sys_user_role "
			+ "where user_role_id =:1 ")
	public SysUserRole selectByPrimaryKey(int id);

	@SQL(" update sys_user_role set user_id=:1.userId,role_id=:1.roleId,create_date=:1.createDate "
			+ " where user_role_id =:1.userRoleId")
	public int updateByPrimaryKey(SysUserRole sysUserRole);

	@SQL("delete from sys_user_role where user_role_id = :1")
	public int deleteBatch(int id);

	@SQL("delete from sys_user_role where 1=1 #if(!empty(:1.userId)){ and user_id=:1.userId } #if(!empty(:1.roleId)){ and role_id=:1.roleId } ")
	public void deleteByCriteria(SysUserRole sysUserRole);
}
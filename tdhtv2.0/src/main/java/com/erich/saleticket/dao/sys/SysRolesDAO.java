package com.erich.saleticket.dao.sys;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysRoles;
@DAO
public interface SysRolesDAO{
	
	@SQL("select role_id, organization_id, parent_id, code, full_name, category, description, allow_edit, " +
			"allow_delete, enabled, sort_code, delete_mark, create_date, create_user_id, create_user_name, " +
			"modify_date, modify_user_id, modify_user_name from sys_roles " +
			"where 1=1 " +
			"#if(!empty(:2.orderField)){ order by role_id desc }" +
			//" limit :2.firstIndex, :2.pageSize ")
			" limit :2.pageOffset, :2.pageSize ")
	public List<SysRoles> selectByCriteria(SysRoles sysRoles,Pager pager);
	
	@SQL(" insert into sys_roles(organization_id, parent_id, code,full_name, category, description, allow_edit,allow_delete,enabled, sort_code,delete_mark,create_date, create_user_id,create_user_name, modify_date, modify_user_id, modify_user_name) " +
			"values(:1.organizationId, :1.parentId, :1.code,:1.fullName, :1.category, :1.description, :1.allowEdit,:1.allowDelete,:1.enabled, :1.sortCode,:1.deleteMark,:1.createDate, :1.createUserId,:1.createUserName, :1.modifyDate, :1.modifyUserId, :1.modifyUserName)")
	public int insert(SysRoles sysRole);
	
	@SQL("delete from sys_roles where role_id=:1")
	public int deleteBatch(int roleid);
	
	@SQL("update sys_roles set organization_id=:1.organizationId,parent_id=:1.parentId,code=:1.code,full_name=:1.fullName,category=:1.category,description=:1.description" +
			",allow_edit=:1.allowEdit,allow_delete=:1.allowDelete,enabled=:1.enabled,sort_code=:1.sortCode,delete_mark=:1.deleteMark,create_date=:1.createDate,modify_date=:1.modifyDate,modify_user_id=:1.modifyUserId,modify_user_name=:1.modifyUserName " +
			"where role_id = :1.roleId")
	public int updateByPrimaryKey(SysRoles sysRoles); 
	
	@SQL(" select role_id, organization_id, parent_id, code, full_name, category, description, allow_edit, " +
			"allow_delete, enabled, sort_code, delete_mark, create_date, create_user_id, create_user_name, " +
			"modify_date, modify_user_id, modify_user_name from sys_roles " +
			"where role_id = :1")
	public SysRoles selectByPrimaryKey(int id);
	
	@SQL("select count(*) from sys_roles where 1=1 ")
	public int countByCriteria(SysRoles sysRoles);
	
	@SQL("select full_name  from  sys_user as su left join sys_user_role sur  on su.user_id=sur.user_id left join sys_roles sr on sur.role_id=sr.role_id where su.account=:1")
	public List<SysRoles> getSysRolesList(String userName);
}
package com.erich.saleticket.dao.sys;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysRoleMenu;

@DAO
public interface SysRoleMenuDAO{
   
	@SQL("delete from sys_role_menu where 1=1 " +
			"#if(!empty(:1.role_id)){ and role_id =:1.roleId } " +
			"#if(!empty(:1.menu_id)){ and menu_id =:1.menuId }" )
	public void deleteByCriteria(SysRoleMenu sysRoleMenu);
	
	@SQL("select role_menu_id, role_id, menu_id, create_date, create_user_id, create_user_name " +
			" from sys_role_menu " +
			" where role_id = :1.roleId " +
			"  #if(!empty(:2)){ #if(!empty(:2.orderField)){ order by role_menu_id desc } } ")
	public List<SysRoleMenu> selectByCriteria(SysRoleMenu sysRoleMenu,Pager pager);
	
	@SQL("insert into sys_role_menu (role_id,menu_id,create_date,create_user_id,create_user_name) " +
			"values(:1.roleId,:1.menuId,:1.createDate,:1.createUserId,:1.createUserName)")
	public int insert(SysRoleMenu sysRoleMenu);
	
	@SQL("select role_menu_id, role_id, menu_id, create_date, create_user_id, create_user_name " +
			" from sys_role_menu " +
			"where role_menu_id = :1")
	public SysRoleMenu selectByPrimaryKey(int id);
	
	 
	@SQL("update sys_role_menu set role_id=:1.roleId,menu_id=:1.menuId,create_date=:1.createDate,create_user_id=:1.createUserId,create_user_name=:1.createUserName " +
			"where role_menu_id =:1.roleMenuId")
	public int updateByPrimaryKey(SysRoleMenu sysRoleMenu);
	
	
	@SQL("delete from sys_role_menu where role_menu_id = :1")
	public int deleteBatch(int id);
	
	@SQL(" delete from sys_role_menu where role_id = :1")
	public int deleteByRoleId(int roleid);
}
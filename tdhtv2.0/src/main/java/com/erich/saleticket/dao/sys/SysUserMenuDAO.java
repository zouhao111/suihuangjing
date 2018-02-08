package com.erich.saleticket.dao.sys;
import java.util.List;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysUserMenu;

@DAO
public interface SysUserMenuDAO{
    
	@SQL(" delete from sys_role_menu " +
			"#if(!empty(:1.role_id)){ and role_id =:1.roleId } " +
			"#if(!empty(:1.menu_id)){ and menu_id =:1.menuId }" )
	public void deleteByCriteria(SysUserMenu sysUserMenu);
	
	@SQL("select user_menu_id, user_id, menu_id, create_date, create_user_id, create_user_name " +
			"from sys_user_menu where 1=1 #if(!empty(:1)){ #if(!empty(:1.userId)){ and user_id = :1.userId } " +
			"#if(!empty(:1.menuId)){ and menu_id = :1.menuId } } " +
			" #if(!empty(:2)){ #if(!empty(:2.orderField)){ order by user_menu_id desc } } ")
	public List<SysUserMenu> selectByCriteria(SysUserMenu sysUserMenu,Pager pager);
	
	@SQL("insert into sys_user_menu(user_id,menu_id,create_date,create_user_id,create_user_name) " +
			"values(:1.userId,:1.menuId,:1.createDate,:1.createUserId,:1.createUserName)")
	public int insert(SysUserMenu sysUserMenu);
	
	@SQL("select user_menu_id, user_id, menu_id, create_date, create_user_id, create_user_name " +
			" from sys_user_menu " +
			"where user_menu_id =:1")
	public SysUserMenu selectByPrimaryKey(int id);
	
	@SQL("update sys_user_menu set user_id=:1.userId,menu_id=:1.menuId,create_date=:1.createDate,create_user_id=:1.createUserId,create_user_name=:1.createUserName " +
			"where user_menu_id =:1.userMenuId")
	public int updateByPrimaryKey(SysUserMenu sysUserMenu);
	
	@SQL("delete from sys_user_menu where user_menu_id = :1")
	public int deleteBatch(int id);
}
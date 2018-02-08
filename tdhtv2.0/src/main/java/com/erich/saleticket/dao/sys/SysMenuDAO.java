package com.erich.saleticket.dao.sys;

import java.util.List;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysMenu;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;

@DAO
public interface SysMenuDAO {//extends BaseMapper<SysMenu>{
	
	@SQL("select t.menu_id, t.parent_id, t.code, t.full_name, t.description, t.img, t.category, t.navigate_url, t.form_name,"+ 
    "t.target, t.is_unfold, t.allow_edit, t.allow_delete, t.enabled, t.sort_code, t.delete_mark, t.create_date, "+
    "t.create_user_id, t.create_user_name, t.modify_date, t.modify_user_id, t.modify_user_name,t2.full_name as parentName  from sys_menu t "+
	"left join sys_menu t2 on t.parent_id = t2.menu_id  where 1=1 #if(!empty(:1.parent_id)){ and t.parent_id =:1.parent_id } "+
    "  #if(!empty(:2)){ #if(!empty(:2.orderField)){ order by t.menu_id desc } } ")
	public List<SysMenu> selectByCriteria(SysMenu sysMenu,Pager pager);
	
	
	@SQL("insert into sys_menu (parent_id, code,full_name,description,img,category, navigate_url, form_name,target, is_unfold, allow_edit,allow_delete,enabled,sort_code,delete_mark, create_date,create_user_id,create_user_name, modify_date,modify_user_id,modify_user_name) " +
			"values(:1.parentId, :1.code,:1.fullName,:1.description,:1.img,:1.category, :1.navigateUrl, :1.formName,:1.target, :1.isUnfold, :1.allowEdit,:1.allowDelete,:1.enabled,:1.sortCode,:1.deleteMark, :1.createDate,:1.createUserId,:1.createUserName, :1.modifyDate,:1.modifyUserId,:1.modifyUserName)")
	public int insert(SysMenu sysMenu);
	
	@SQL(" delete from sys_menu where menu_id = :1")
	public int deleteByPrimaryKey(int id);
	
	@SQL("select t.menu_id, t.parent_id, t.code, t.full_name, t.description, t.img, t.category, t.navigate_url, t.form_name,"+ 
    "t.target, t.is_unfold, t.allow_edit, t.allow_delete, t.enabled, t.sort_code, t.delete_mark, t.create_date, "+
    "t.create_user_id, t.create_user_name, t.modify_date, t.modify_user_id, t.modify_user_name,t2.full_name as parentName  " +
    " from sys_menu t left join sys_menu t2 on t.parent_id = t2.menu_id" +
    " where t.menu_id = :1")
	public SysMenu selectByPrimaryKey(int id);
	
	@SQL("update sys_menu set parent_id =:1.parentId,code=:1.code,full_name=:1.fullName,description=:1.description,img=:1.img,category=:1.category,navigate_url=:1.navigateUrl,form_name=:1.formName,target=:1.target,is_unfold=:1.isUnfold,allow_edit=:1.allowEdit,allow_delete=:1.allowDelete,enabled=:1.enabled,sort_code=:1.sortCode,delete_mark=:1.deleteMark,create_date=:1.createDate,create_user_id=:1.createUserId,create_user_name=:1.createUserName,modify_date=:1.modifyDate,modify_user_id=:1.modifyUserId,modify_user_name=:1.modifyUserName " +
			" where menu_id = :1.menuId")
	public int updateByPrimaryKey(SysMenu sysMenu);

	@SQL("select max(sort_code) + 1 from sys_menu")
	public int selectMaxSortCode();
	
	@SQL("select sys_menu set")
	public int selectMinser();

	/**
	 * 根据用户查询菜单
	 * @return
	 */
	@SQL("select distinct a.menu_id,a.full_name,a.navigate_url,a.sort_code,a.parent_id,a.target,a.code from ("+
		/*"select t.menu_id,t.full_name,t.navigate_url,t.sort_code,t.parent_id,t.target from sys_menu t "+
			"inner join sys_user_menu t2 on t2.menu_id=t.menu_id "+
			"inner join sys_user t5 on t5.user_id = t2.user_id  where 1=1 " +
			"#if(!empty(:1.parentId)){ and t.parent_id =:1.parentId } " +
			"#if(!empty(:2)){ and t5.user_id =:2 } " +
			"Union All" +*/
			" select t.menu_id,t.full_name,t.navigate_url,t.sort_code,t.parent_id,t.target,t.code from sys_menu t " +
			" inner join sys_role_menu t2 on t2.menu_id=t.menu_id inner join sys_roles t3 on t3.role_id = t2.role_id " +
			" inner join sys_user_role t4 on t4.role_id=t3.role_id inner join sys_user t5 on t5.user_id=t4.user_id " +
			" where 1=1" +
			" #if(!empty(:1.parentId)){ and t.parent_id =:1.parentId } #if(!empty(:2)){ and t5.user_id =:2 } " +
			") a order by a.sort_code")
	public List<SysMenu> selectMenuByUserId(SysMenu sysMenu,String userId);
	
	
	/**
	 * 根据UserID查询对应的公司
	 * @param userId
	 * @return
	 */
	@SQL("select * from sys_user_company where " +
		"user_id=:1")
	public List<SysUserCompany> selectCompanyUserId(Integer userId);
	
	
	
	/**
	 * 左侧导航  所有公司
	 * @param userId
	 * @return
	 */
	@SQL("select * from tabcompanyconfig_copy , sys_company  where sys_company.company_id=Rid")
	public List<ViewCompanyconfig> selectCompany();
	
	@SQL("select * from tabcompanyconfig_copy , sys_company where waterType=2 and sys_company.company_id=Rid")
	public List<ViewCompanyconfig> selectCompany2();
	@SQL("select * from tabcompanyconfig_copy , sys_company where 1=1 #if(!empty(:1)){  and waterType =:1 }and sys_company.company_id=Rid ")
	public List<ViewCompanyconfig> selectCompanys(Integer waterType);
	@SQL("select * from tabcompanyconfig_copy , sys_company where 1=1  and waterType >0 and sys_company.company_id=Rid")
	public List<ViewCompanyconfig> selectCompanys2();
	@SQL("select * from syscomtype where 1=1" +
			" #if(!empty(:1)){ and waterType =:1 } group by rid ")
	public List<ViewCompanyconfig> selectCompany3(Integer waterType);
	/**
	 * 左侧导航 一个公司
	 * @param userId
	 * @return
	 */
	@SQL("select * from tabcompanyconfig_copy where rid=:1 ")
	public List<ViewCompanyconfig> selectCompanyOne(long rid);
	
	/**
	 * 根据父ID查询子菜单
	 * @return
	 */
	@SQL("select distinct a.menu_id,a.full_name,a.navigate_url,a.sort_code,a.parent_id,a.target from ("+
				" select t.menu_id,t.full_name,t.navigate_url,t.sort_code,t.parent_id,t.target from sys_menu t " +
				" inner join sys_role_menu t2 on t2.menu_id=t.menu_id inner join sys_roles t3 on t3.role_id = t2.role_id " +
				" inner join sys_user_role t4 on t4.role_id=t3.role_id inner join sys_user t5 on t5.user_id=t4.user_id " +
				" where 1=1" +
				" #if(!empty(:1)){ and t.parent_id =:1 } #if(!empty(:2)){ and t5.user_id =:2 } " +
				") a order by a.sort_code")
	public List<SysMenu> selectMenuByParenId(Integer parentId,int userId); 
	
	
	
	/**
	 * 查询排序中最大值
	 * @return 
	 */
	//int selectMaxSortCode();
	
	
	@	SQL	("select t.menu_id,t.full_name,t.vavigate_url,t.sort_code,t.parent_id,from sys_menu t inner join  from sys_tem where id=:1")
	public List<SysMenu> finAll(String id);

	/**
	 * 用户权限菜单查询
	 * @param sysMenu
	 * @return
	 */
	//List<SysMenu> selectMenuByUserId(SysMenu sysMenu);
}
package com.erich.saleticket.dao.sys;

import java.util.List;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysUser;

@DAO
public interface SysUserDAO {

	@SQL("select  user_id, code, account, password, secret_key, real_name, spell, alias, role_id, gender, "
			+ "mobile, telephone, birthday, email, oicq, duty_id, title_id, company_id, department_id, "
			+ "workgroup_id, description, security_level, change_password_date, open_id, ip_address,"
			+ "mac_address, log_on_count, first_visit, previous_visit, last_visit, enabled, sort_code,"
			+ "delete_mark, create_date, create_user_id, create_user_name, modify_date, modify_user_id,modify_user_name from sys_user "
			+ "where 1=1 "+
			/*+ "#if(!empty(:2)){ "
			+ "#if(!empty(:2.pageOffset) &&:2.pageOffset!=0){" +
			"  and user_id not in  (  select top ##(:2.pageOffset)  user_id from sys_user  " +
				"	#if(!empty(:2.orderField)){ " +
						" order by user_id desc " +
					"	} )  " +
			" } } "+*/
			" #if(!empty(:1.realName)){ and real_name like '%##(:1.realName)%' }"+
			" #if(!empty(:1.account)){ and account like '%##(:1.account)%' }"+
			" #if(!empty(:1.enabled)){ and enabled like '%##(:1.enabled)%' }"+
			 //top :2.pageOffset  user_id from sys_user  #if(!empty(:2.orderField)){  order by :2.orderField desc } )  } " +
			"#if(!empty(:1.account)){ and account =:1.account }  order by user_id asc"+
			//" limit :2.firstIndex, :2.pageSize ")
			" limit :2.pageOffset, :2.pageSize ")
	public List<SysUser> selectByCriteria(SysUser sysUser, Pager pager);
	
	
	@SQL("select * from sys_user where account=:1.account and password=:1.password")
	public List<SysUser>getSysUser(SysUser sysUser, Pager pager);

	@SQL(" insert into sys_user(code,  account, password, secret_key, real_name, spell, alias,role_id, gender,mobile, telephone, birthday, email, oicq,duty_id, title_id, company_id, department_id, workgroup_id, description, security_level, change_password_date, open_id, ip_address,mac_address, log_on_count, first_visit,previous_visit, last_visit, enabled, sort_code,delete_mark, create_date,create_user_id,create_user_name, modify_date, modify_user_id,modify_user_name) "
			+ "values(:1.code,  :1.account, :1.password, :1.secretKey, :1.realName, :1.spell, :1.alias,:1.roleId, :1.gender,:1.mobile, :1.telephone, :1.birthday, :1.email, :1.oicq,:1.dutyId, :1.titleId, :1.companyId, :1.departmentId, :1.workgroupId, :1.description, :1.securityLevel, :1.changePasswordDate, :1.openId, :1.ipAddress,:1.macAddress, :1.logOnCount, :1.firstVisit,:1.previousVisit, :1.lastVisit, :1.enabled, :1.sortCode,:1.deleteMark, :1.createDate,:1.createUserId,:1.createUserName, :1.modifyDate, :1.modifyUserId,:1.modifyUserName)")
	public int insert(SysUser sysUser);

	@SQL("delete from sys_user where user_id = :1")
	public int deleteBatch(int id);

	@SQL("update sys_user set code=:1.code,account=:1.account,password=:1.password,secret_key=:1.secretKey,real_name=:1.realName,spell=:1.spell,alias=:1.alias,role_id=:1.roleId,gender=:1.gender,mobile=:1.mobile,telephone=:1.telephone,birthday=:1.birthday,email=:1.email,oicq=:1.oicq,duty_id=:1.dutyId,title_id=:1.titleId,company_id=:1.companyId,department_id=:1.departmentId,workgroup_id=:1.workgroupId,description=:1.description,security_level=:1.securityLevel,change_password_date=:1.changePasswordDate,open_id=:1.openId,ip_address=:1.ipAddress,mac_address=:1.macAddress,log_on_count=:1.logOnCount,first_visit=:1.firstVisit,previous_visit=:1.previousVisit,last_visit=:1.lastVisit,enabled=:1.enabled,sort_code=:1.sortCode,delete_mark=:1.deleteMark,create_date=:1.createDate,create_user_id=:1.createUserId,create_user_name=:1.createUserName,modify_date=:1.modifyDate,modify_user_id=:1.modifyUserId,modify_user_name=:1.modifyUserName "
			+ " where user_id =:1.userId")
	public int updateByPrimaryKey(SysUser sysUser);

	@SQL("update sys_user set log_on_count=:1.logOnCount,last_visit=:1.lastVisit " + " where user_id =:1.userId")
	public int updateByPrimaryKey1(SysUser sysUser);
	

	@SQL("select user_id, code, account, password, secret_key, real_name, spell, alias, role_id, gender, "
			+ "mobile, telephone, birthday, email, oicq, duty_id, title_id, company_id, department_id, "
			+ "workgroup_id, description, security_level, change_password_date, open_id, ip_address,"
			+ "mac_address, log_on_count, first_visit, previous_visit, last_visit, enabled, sort_code,"
			+ "delete_mark, create_date, create_user_id, create_user_name, modify_date, modify_user_id,modify_user_name from sys_user "
			+ " where user_id =:1")
	public SysUser selectByPrimaryKey(int id);

	@SQL("select count(*) from sys_user where 1=1 #if(!empty(:1.account)){ and account =:1.account } "
			+ "#if(!empty(:1.password)){ and password =:1.password } #if(!empty(:1.enabled)){ and enabled =:1.enabled }")
	public int countByCriteria(SysUser sysUser);
}
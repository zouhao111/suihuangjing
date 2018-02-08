package com.erich.saleticket.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.ui.ModelMap;

import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.biz.sys.SysMenuBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysMenu;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;

/**
 * 主页控制器
 */
@Path("index")
public class IndexController extends BaseController {

	@Resource
	private SysMenuBiz sysMenuBiz;
	@Resource
	private DataBiz dataBiz;
	/**
	 * 登录成功后进入主界面
	 * @param model
	 * @return
	 */
	@Get("")
		public String main(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			SysUser sysUser = getUser(request);
			
			
			List<SysUserCompany>   sysUserCompany=sysMenuBiz.selectCompanyUserId(sysUser.getUserId());//根据用户ID查询公司
			Long Rid=sysUser.getRid();
			SysUserCompany sysUserCompanys=sysUserCompany.get(0);//获取对应公司的第一条
			Long rid=null;
	         if(Rid!=null){
	        	rid=Rid;
	        	sysUser.setRid(null);
			}else{
				 rid=sysUserCompanys.getRid();
			}
			
			
			SysMenu sysMenu = new SysMenu();
			sysMenu.setParentId(0);
			sysMenu.getCondition().put("userId", sysUser.getUserId());
			List<SysMenu> menus = sysMenuBiz.selectMenuByUserId(sysMenu);
			request.getSession().setAttribute(WebConstants.CURRENT_USER_MENUS, menus);
			request.getSession().setAttribute(WebConstants.USER_COMPANY,sysUserCompanys);
			request.setAttribute("userCompanyList",sysUserCompany);
			//request.setAttribute("userCompany",sysUserCompanys);
			//return "main";
			
			//mainMenu方法中提取出的
			sysMenu.getCondition().put("userId", sysUser.getUserId());
			request.setAttribute("currentFirstMenu", sysMenu.getParentId());
			List<SysMenu> menuss = sysMenuBiz.selectMenuByUserId2(sysMenu);
		
			request.setAttribute(WebConstants.CURRENT_USER_SECOND_MENUS, menuss);
			
			Integer companyId=sysUserCompanys.getCompanyId();
			Integer userid=sysUserCompanys.getUserId();
			 List<ViewCompanyconfig> list=new ArrayList<ViewCompanyconfig>();
			if(companyId>500&&companyId<=1000){
				
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompanys2();
			//	List<ViewCompanyconfig>company= sysMenuBiz.selectCompany();
				List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
					request.setAttribute("comName",comName);
				request.setAttribute("rid",rid);
				request.setAttribute("Rid",Rid);
				request.setAttribute("company",company);
				return "new2mainmenu";
			}else if(companyId>=1600&&companyId<1700){
				int watertype=20;
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompanys(watertype);
				//List<ViewCompanyconfig>company= sysMenuBiz.selectCompany();
				List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
					request.setAttribute("comName",comName);
				request.setAttribute("rid",rid);
				request.setAttribute("Rid",Rid);
				request.setAttribute("company",company);
				return "new2mainmenu";
			}else if(companyId>=1500&&companyId<1600){
				int watertype=10;
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompanys(watertype);
				//List<ViewCompanyconfig>company= sysMenuBiz.selectCompany();
				List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
					request.setAttribute("comName",comName);
				request.setAttribute("rid",rid);
				request.setAttribute("Rid",Rid);
				request.setAttribute("company",company);
				return "new2mainmenu";
				
			}else if(companyId==0){
				
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompany();
				//List<ViewCompanyconfig>company= sysMenuBiz.selectCompany();
				List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
					request.setAttribute("comName",comName);
				request.setAttribute("rid",rid);
				request.setAttribute("Rid",Rid);
				request.setAttribute("company",company);
				return "new2mainmenu";
				
			}
			
			else if(companyId==2000){
			
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompany2();
				 List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
				request.setAttribute("comName",comName);
				request.setAttribute("rid",rid);
				request.setAttribute("Rid",Rid);
				request.setAttribute("company",company);
				return "new2mainmenu2";
			}else{
				
				List<ViewCompanyconfig>company= sysMenuBiz.selectCompanyOne(rid);
				
				List<Long> rids=new ArrayList<Long>();
				 List<String> comName=new ArrayList<String>();
				 for(int j=0;j<company.size();j++){
					 rids.add(j, company.get(j).getRid());
					 String s="'"+company.get(j).getCompanyName()+"'";
					 comName.add(j,s);
				 }
				 request.setAttribute("rids",rids);
				request.setAttribute("comName",comName);
				request.setAttribute("company",company);
				request.setAttribute("rid",rid);
				if(companyId>=200){
					return "new2mainmenu2";
				}else {
					return "new2mainmenu";	
				}
				
			
			}
		
			
			
			
		}
	
	
	public String doAjax(ViewCompanyconfig companyconfigs,HttpServletRequest request, HttpServletResponse response) {
        Long rid=companyconfigs.getRid();
        
        request.setAttribute("rids", rid);
		return "mainmenu";
	}
        
	@Get("")
	@Post("")
	public String pop(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		SysUser sysUser = getUser(request);
		
		List<SysUserCompany>   sysUserCompany=sysMenuBiz.selectCompanyUserId(sysUser.getUserId());//根据用户ID查询公司
		Long Rid=sysUser.getRid();
		SysUserCompany sysUserCompanys=sysUserCompany.get(0);//获取对应公司的第一条
		Long rid=null;
         if(Rid!=null){
        	rid=Rid;
        	sysUser.setRid(null);
		}else{
			 rid=sysUserCompanys.getRid();
		}
         Integer companyId=sysUserCompanys.getCompanyId();//公司权限编码
		
		if(companyId==0 || companyId==1000){
			
		}
		
		return "";
	}
        
        
        
}

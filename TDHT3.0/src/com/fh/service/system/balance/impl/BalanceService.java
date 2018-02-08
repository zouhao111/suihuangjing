package com.fh.service.system.balance.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.balance.BalanceManager;
import com.fh.util.PageData;

/** 
 * 说明： 水平衡
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("BalanceService")
public class BalanceService implements BalanceManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	@Override
	public List<PageData> balance(PageData pd) throws Exception {
		
		
		List<PageData>dayfollow=(List<PageData>) pd.get("dayfollow");
		List<PageData> balance_config=(List<PageData>) dao.findForList("BalanceManager.balance_config", pd);
		List<PageData>balances=new ArrayList<PageData>();
		boolean idHave=false;
		boolean isHave=false;
		boolean lsHave=false;
		boolean ldHave=false;
		boolean  balance_per=false;     
		
		
		if(dayfollow.size()>0){
		if(balance_config.size()>0){
			Integer R_N=balance_config.get(0).getInteger("r_n");
			Double R_Q=balance_config.get(0).getDouble("r_q");
			Double R_K=Double.valueOf(balance_config.get(0).getDouble("r_k"));
			if(balance_config.get(0).getInteger("r_balance_per_calc")==1){
				balance_per=true;
			}
			
			PageData ba=new PageData();
			for(int i=0;i<balance_config.size();i++){
				
				if(balance_config.get(i).getInteger("device_type")==1){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						idHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==2){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						isHave=true;
					}
				}
				
				if(balance_config.get(i).getInteger("device_type")==3){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						ldHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==4){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						lsHave=true;
					}
				}
			
			}
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			ba.put("str_time", sdf.format(dayfollow.get(0).get("STR_TIME")));
			ba.put("Idztraffic", idHave?dayfollow.get(0).getDouble("I_DRAINAGE_F"):0);
			ba.put("Isztraffic", isHave?dayfollow.get(0).getDouble("I_SUPPLY_F"):0);
			ba.put("Ldztraffic", ldHave?dayfollow.get(0).getDouble("L_DRAINAGE_F"):0);
			ba.put("Lsztraffic", lsHave?dayfollow.get(0).getDouble("L_SUPPLY_F"):0);
			
			ba.put("Idztraffic_sum", idHave?dayfollow.get(0).getDouble("I_DRAINAGE_F"):0);
			ba.put("Isztraffic_sum", isHave?dayfollow.get(0).getDouble("I_SUPPLY_F"):0);
			ba.put("Ldztraffic_sum", ldHave?dayfollow.get(0).getDouble("L_DRAINAGE_F"):0);
			ba.put("Lsztraffic_sum", lsHave?dayfollow.get(0).getDouble("L_SUPPLY_F"):0);
			
			
			Double totalwastage=0.0;
			Double wastage=0.0;
			Double Loss=0.0;
			
			if(R_N*R_K<=(dayfollow.get(0).getDouble("I_SUPPLY_F")+dayfollow.get(0).getDouble("L_SUPPLY_F") )){
				 Loss=((dayfollow.get(0).getDouble("I_SUPPLY_F")+dayfollow.get(0).getDouble("L_SUPPLY_F") )*R_K )+(R_N*R_Q);
			}else{
				 Loss=((dayfollow.get(0).getDouble("I_SUPPLY_F")+dayfollow.get(0).getDouble("L_SUPPLY_F") )* R_K)+(dayfollow.get(0).getDouble("I_SUPPLY_F")+dayfollow.get(0).getDouble("L_SUPPLY_F") );
			}
			ba.put("Losslimit", balance_per?Loss:((dayfollow.get(0).getDouble("I_SUPPLY_F")+dayfollow.get(0).getDouble("L_SUPPLY_F"))*R_K));
			
			
			ba.put("Losslimit_sum", ba.getDouble("Losslimit"));
			
			
			totalwastage=(ba.getDouble("Isztraffic_sum")+ba.getDouble("Lsztraffic_sum"))-(ba.getDouble("Idztraffic_sum")+ba.getDouble("Ldztraffic_sum"));
			
			if(totalwastage>=ba.getDouble("Losslimit_sum")){
				
				ba.put("Wastage", ba.getDouble("Losslimit"));
				ba.put("Wastage_sum", ba.getDouble("Losslimit_sum"));
			}else{
			ba.put("Wastage", totalwastage);
			ba.put("Wastage_sum", totalwastage);
			}
			
			Double totalunknow=0.0;
			
			
			
			ba.put("Unknow",(ba.getDouble("Isztraffic_sum")+ba.getDouble("Lsztraffic_sum"))-(ba.getDouble("Idztraffic_sum")+ba.getDouble("Ldztraffic_sum"))-ba.getDouble("Wastage_sum"));
			ba.put("Unknow_sum",(ba.getDouble("Isztraffic_sum")+ba.getDouble("Lsztraffic_sum"))-(ba.getDouble("Idztraffic_sum")+ba.getDouble("Ldztraffic_sum"))-ba.getDouble("Wastage_sum"));
			
			ba.put("idHave",idHave);
			ba.put("isHave",isHave);
			ba.put("lsHave",lsHave);
			ba.put("ldHave",ldHave);
			balances.add(ba);
			
			for(int a=1;a<dayfollow.size();a++){
				PageData bas=new PageData();
				bas.put("str_time", sdf.format(dayfollow.get(a).get("STR_TIME")));
				bas.put("Idztraffic", idHave?dayfollow.get(a).getDouble("I_DRAINAGE_F"):0);
				bas.put("Isztraffic", isHave?dayfollow.get(a).getDouble("I_SUPPLY_F"):0);
				bas.put("Ldztraffic", ldHave?dayfollow.get(a).getDouble("L_DRAINAGE_F"):0);
				bas.put("Lsztraffic", lsHave?dayfollow.get(a).getDouble("L_SUPPLY_F"):0);
				
				bas.put("Idztraffic_sum", idHave?dayfollow.get(a).getDouble("I_DRAINAGE_F")+balances.get(a-1).getDouble("Idztraffic_sum"):0);
				bas.put("Isztraffic_sum", isHave?dayfollow.get(a).getDouble("I_SUPPLY_F")+balances.get(a-1).getDouble("Isztraffic_sum"):0);
				bas.put("Ldztraffic_sum", ldHave?dayfollow.get(a).getDouble("L_DRAINAGE_F")+balances.get(a-1).getDouble("Ldztraffic_sum"):0);
				bas.put("Lsztraffic_sum", lsHave?dayfollow.get(a).getDouble("L_SUPPLY_F")+balances.get(a-1).getDouble("Lsztraffic_sum"):0);
				
				
				if(R_N*R_K<=(dayfollow.get(a).getDouble("I_SUPPLY_F")+dayfollow.get(a).getDouble("L_SUPPLY_F") )){
					 Loss=((dayfollow.get(a).getDouble("I_SUPPLY_F")+dayfollow.get(a).getDouble("L_SUPPLY_F") )* R_K)+(R_N*R_Q);
				}else{
					 Loss=((dayfollow.get(a).getDouble("I_SUPPLY_F")+dayfollow.get(a).getDouble("L_SUPPLY_F") )* R_K)+(dayfollow.get(a).getDouble("I_SUPPLY_F")+dayfollow.get(a).getDouble("L_SUPPLY_F") );
				}
				bas.put("Losslimit", balance_per?Loss:((dayfollow.get(a).getDouble("I_SUPPLY_F")+dayfollow.get(a).getDouble("L_SUPPLY_F"))*R_K));
				bas.put("Losslimit_sum", bas.getDouble("Losslimit")+balances.get(a-1).getDouble("Losslimit_sum"));
				
				totalwastage=(bas.getDouble("Isztraffic_sum")+bas.getDouble("Lsztraffic_sum"))-(bas.getDouble("Idztraffic_sum")+bas.getDouble("Ldztraffic_sum"));
				if(totalwastage>=bas.getDouble("Losslimit_sum")){
					
					
					bas.put("Wastage_sum", bas.getDouble("Losslimit_sum"));
				}else{
					
					bas.put("Wastage_sum", totalwastage);
				}
				bas.put("Wastage", bas.getDouble("Wastage_sum")- balances.get(a-1).getDouble("Wastage_sum"));
				bas.put("Unknow_sum",(bas.getDouble("Isztraffic_sum")+bas.getDouble("Lsztraffic_sum"))-(bas.getDouble("Idztraffic_sum")+bas.getDouble("Ldztraffic_sum"))-bas.getDouble("Wastage_sum"));
				
				bas.put("Unknow", bas.getDouble("Unknow_sum")- balances.get(a-1).getDouble("Unknow_sum"));
				
				bas.put("idHave",idHave);
				bas.put("isHave",isHave);
				bas.put("lsHave",lsHave);
				bas.put("ldHave",ldHave);
				balances.add(bas);
			}
			
			
		}
		}
		
		
		
		return balances;
	}
	@Override
	public List<PageData> list_day_follow(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BalanceManager.list_day_follow", pd);
	}
	@Override
	public List<PageData> list_day_follow2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BalanceManager.list_day_follow2", pd);
	}
	@Override
	public List<PageData> list_day_follow3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BalanceManager.list_day_follow3", pd);
	}
	@Override
	public List<PageData> balance_config(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BalanceManager.balance_config", pd);
	}
	@Override
	public List<PageData> select_cyc(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BalanceManager.select_cyc", pd);
	}


	
	
}

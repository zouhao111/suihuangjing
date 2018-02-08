package com.erich.saleticket.biz.tdht;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.BalanceWaterDAO;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;

@Service
public class BalanceWaterBiz {

	@Resource
	private BalanceWaterDAO balanceDAO;
	
	
	public List<BalanceWater> selectMidtodaytotalflow(BalanceWater balance){
		
		return balanceDAO.selectMidtodaytotalflow(balance);
	}
	public List<BalanceWater> selectMidtodaytotalflow2(BalanceWater balance){
		
		return balanceDAO.selectMidtodaytotalflow2(balance);
	}
	
public ViewCompanyconfig selectBycompanyconfig(BalanceWater balance){
		
		return balanceDAO.selectBycompanyconfig(balance);
	}
public int insertBalance(BalanceWater balance){
	
	return balanceDAO.insertBalance(balance);
}

public Object deleteBalance(){
	return balanceDAO.deleteBalance();
}



public List<BalanceWater> BalanceList(BalanceWater balance) throws ParseException {
	
	/*String sTime=balance.getStartingTime();
	String eTime=balance.getEndTime();
	Integer type=balance.getType();//查询日期类型
	String dateTypes=balance.getDateTypes();
	 long lSysTime1=0;
	 long lSysTime2=0;
	 long lSysTime3=0;
	try  
	{  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    
	    if(type==5){
	    	 Date startTime = sdf.parse(sTime);  	
	    	  lSysTime1 = startTime.getTime() / 1000/60;   //得到秒数，Date类型的getTime()返回毫秒数
	    	  Date endTime = sdf.parse(eTime);  
		    	 lSysTime2 = endTime.getTime() / 1000/60;   //得到秒数，Date类型的getTime()返回毫秒数
	    }else{
	    	 Date dateTypess = sdf.parse(dateTypes);  	
	    	 lSysTime3 = dateTypess.getTime() / 1000/60;   //得到秒数，Date类型的getTime()返回毫秒数
	    }
	    
	}  
	catch (ParseException e)  
	{  
	    System.out.println(e.getMessage());  
	}  
	*/
	
	
	
	Long rid=balance.getRid();
	List<BalanceWater>	balances;
	if(rid==75501330004l){
		balances=selectMidtodaytotalflow2(balance);
	}else{
		
	
balances=selectMidtodaytotalflow(balance);
	}
if(balances.size()>0){
	


ViewCompanyconfig companyconfig=selectBycompanyconfig(balance);//查询公司名称


balances.get(0).setIdztraffic(balances.get(0).getMidviewid());
balances.get(0).setIsztraffic(balances.get(0).getMidviewis());
balances.get(0).setLsztraffic(balances.get(0).getMidviewls());
balances.get(0).setIndustrialdrainage(balances.get(0).getMidviewid());
balances.get(0).setIndustrialsupply(balances.get(0).getMidviewis());
balances.get(0).setLivingsupply(balances.get(0).getMidviewls());

Double totalwastage=0.0;
Double wastage=0.0;
if(balances.size()!=0){
	


if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
	balances.get(0).setLosslimit(balances.get(0).getIndustrialsupply()*	0.15);
}else if(rid==75506330001l){
	if((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())<=balances.get(0).getIndustrialsupply()){
		balances.get(0).setLosslimit((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())+(0.15*balances.get(0).getIndustrialsupply()));

	}else{
	balances.get(0).setLosslimit(balances.get(0).getIndustrialsupply()+(0.15*balances.get(0).getIndustrialsupply()));
	}
}else{
	
	if((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())<=(balances.get(0).getIndustrialsupply()+balances.get(0).getLivingsupply())){
		balances.get(0).setLosslimit((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())+(0.15*(balances.get(0).getIndustrialsupply()+balances.get(0).getLivingsupply())));

	}else{
	balances.get(0).setLosslimit((balances.get(0).getIndustrialsupply()+balances.get(0).getLivingsupply())+(0.15*(balances.get(0).getIndustrialsupply()+balances.get(0).getLivingsupply())));
	}

}balances.get(0).setTotalLossLimit(balances.get(0).getLosslimit());

if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
	totalwastage=(balances.get(0).getIsztraffic()-balances.get(0).getIdztraffic());
	if(totalwastage>=balances.get(0).getTotalLossLimit()){
		balances.get(0).setTotalwastage(balances.get(0).getTotalLossLimit());
		balances.get(0).setWastage(balances.get(0).getTotalLossLimit());
	}else{
		balances.get(0).setTotalwastage(totalwastage);	
		balances.get(0).setWastage(totalwastage);
	}
	
}else if(rid==75506330001l){
	totalwastage=(balances.get(0).getIsztraffic()-balances.get(0).getIdztraffic());
	if(totalwastage>=balances.get(0).getTotalLossLimit()){
		balances.get(0).setTotalwastage(balances.get(0).getTotalLossLimit());
		balances.get(0).setWastage(balances.get(0).getTotalLossLimit());
	}else{
		balances.get(0).setTotalwastage(totalwastage);	
		balances.get(0).setWastage(totalwastage);
	}
}else{
	totalwastage=((balances.get(0).getIsztraffic()+balances.get(0).getLsztraffic())-balances.get(0).getIdztraffic());
	if(totalwastage>=balances.get(0).getTotalLossLimit()){
		balances.get(0).setTotalwastage(balances.get(0).getTotalLossLimit());
		balances.get(0).setWastage(balances.get(0).getTotalLossLimit());
	}else{
		balances.get(0).setTotalwastage(totalwastage);	
		balances.get(0).setWastage(totalwastage);
	}
}
	

Double totalunknow=0.0;
if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
	totalunknow=(balances.get(0).getIsztraffic()-balances.get(0).getIdztraffic()-balances.get(0).getTotalwastage());
	
}else if(rid==75506330001l){
	totalunknow=(balances.get(0).getIsztraffic()-balances.get(0).getIdztraffic()-balances.get(0).getTotalwastage());
	
}else{
	totalunknow=((balances.get(0).getIsztraffic()+balances.get(0).getLsztraffic())-balances.get(0).getIdztraffic()-balances.get(0).getTotalwastage());
	
}
balances.get(0).setTotalunknow(totalunknow);
balances.get(0).setUnknown(totalunknow);

	for(int i=1;i<balances.size();i++){

		
		balances.get(i).setIndustrialdrainage(balances.get(i).getMidviewid());
		balances.get(i).setIndustrialsupply(balances.get(i).getMidviewis());
		balances.get(i).setLivingsupply(balances.get(i).getMidviewls());
		balances.get(i).setIdztraffic(balances.get(i-1).getIdztraffic()+balances.get(i).getIndustrialdrainage());
		balances.get(i).setIsztraffic(balances.get(i-1).getIsztraffic()+balances.get(i).getIndustrialsupply());
		balances.get(i).setLsztraffic(balances.get(i-1).getLsztraffic()+balances.get(i).getLivingsupply());
	
		if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
			balances.get(i).setLosslimit(balances.get(i).getIndustrialsupply()*	0.15);
		}else if(rid==75506330001l){
			if((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())<=balances.get(i).getIndustrialsupply()){
				balances.get(i).setLosslimit((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())+(0.15*balances.get(i).getIndustrialsupply()));
				
			}else{
				balances.get(i).setLosslimit(balances.get(i).getIndustrialsupply()+(0.15*balances.get(i).getIndustrialsupply()));
				
			}
		}else{
			if((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())<=(balances.get(i).getIndustrialsupply()+balances.get(i).getLivingsupply())){
				balances.get(i).setLosslimit((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())+(0.15*(balances.get(i).getIndustrialsupply()+balances.get(i).getLivingsupply())));
				
			}else{
				balances.get(i).setLosslimit((balances.get(i).getIndustrialsupply()+balances.get(i).getLivingsupply())+(0.15*(balances.get(i).getIndustrialsupply()+balances.get(i).getLivingsupply())));
				
			}
			//balances.get(i).setLosslimit((companyconfig.getTravelNum()*companyconfig.getPerCaoitaWater())+(0.15*(balances.get(i).getIndustrialsupply()+balances.get(i).getLivingsupply())));
		
		}
		balances.get(i).setTotalLossLimit(balances.get(i-1).getTotalLossLimit()+balances.get(i).getLosslimit());
	
		
		if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
			totalwastage=(balances.get(i).getIsztraffic()-balances.get(i).getIdztraffic());
			if(totalwastage>=balances.get(i).getTotalLossLimit()){
				balances.get(i).setTotalwastage(balances.get(i).getTotalLossLimit());
				
			}else{
				balances.get(i).setTotalwastage(totalwastage);	
			}
			balances.get(i).setWastage(balances.get(i).getTotalwastage()-balances.get(i-1).getTotalwastage());	
			
		}else if(rid==75506330001l){
			totalwastage=(balances.get(i).getIsztraffic()-balances.get(i).getIdztraffic());
			if(totalwastage>=balances.get(i).getTotalLossLimit()){
				balances.get(i).setTotalwastage(balances.get(i).getTotalLossLimit());
			}else{
				balances.get(i).setTotalwastage(totalwastage);	
			}
			balances.get(i).setWastage(balances.get(i).getTotalwastage()-balances.get(i-1).getTotalwastage());	
			
		}else{
			totalwastage=((balances.get(i).getIsztraffic()+balances.get(i).getLsztraffic())-balances.get(i).getIdztraffic());
			if(totalwastage>=balances.get(i).getTotalLossLimit()){
				balances.get(i).setTotalwastage(balances.get(i).getTotalLossLimit());
			}else{
				balances.get(i).setTotalwastage(totalwastage);	
			}
			balances.get(i).setWastage(balances.get(i).getTotalwastage()-balances.get(i-1).getTotalwastage());	
			
		}
		
		
		
		if(rid==75501330004l||rid==75501330008l||rid==75501330009l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330026l){
			totalunknow=(balances.get(i).getIsztraffic()-balances.get(i).getIdztraffic()-balances.get(i).getTotalwastage());
			balances.get(i).setTotalunknow(totalunknow);
		}else if(rid==75506330001l){
			totalunknow=(balances.get(i).getIsztraffic()-balances.get(i).getIdztraffic()-balances.get(i).getTotalwastage());
			balances.get(i).setTotalunknow(totalunknow);
		}else{
			totalunknow=((balances.get(i).getIsztraffic()+balances.get(i).getLsztraffic())-balances.get(i).getIdztraffic()-balances.get(i).getTotalwastage());
			balances.get(i).setTotalunknow(totalunknow);
		}
		
		balances.get(i).setUnknown(balances.get(i).getTotalunknow()-balances.get(i-1).getTotalunknow());	
	}
}else{
	return null;
}
/*	List<BalanceWater>	balances2=new ArrayList<BalanceWater>();
	for(int i=0;i<balances.size();i++){
		long sytime=balances.get(i).getSyTime();
		  if(type==5){
		if(sytime>=lSysTime1 && sytime<=lSysTime2){
			balances2.add(balances.get(i));
		}
		  }else{
			  if(sytime>=lSysTime3 ){
					balances2.add(balances.get(i));
				}  
		  }
	}
	*/
	/*deleteBalance();
for(int i=1;i<balances.size();i++){
	int a=insertBalance(balances.get(i));
}*/
}
return balances;
	
	

}


}

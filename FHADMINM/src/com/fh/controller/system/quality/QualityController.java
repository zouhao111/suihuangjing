package com.fh.controller.system.quality;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.service.system.loginimg.LogInImgManager;
import com.fh.service.system.quality.QualityManager;
import com.fh.util.PageData;

@Controller
@RequestMapping(value="/quality")
public class QualityController extends BaseController {

	
	String menuUrl = "quality/list.do"; //菜单地址(权限用)
	@Resource(name="qualityService")
	private QualityManager qualityService;
	
	/**
	 * 查询水量列表
	 * @return
	 */
	@RequestMapping(value="/listQuality")
	public ModelAndView listQuality(){
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String strTime = pd.getString("STR_TIME");
		
		Date data=new Date();
		SimpleDateFormat simdata=new SimpleDateFormat("yyyy-MM");
		String datas=simdata.format(data);
		
		String tablename="src_industrial_supply_";
	
	
		return mv;
	}
	
	
	
}

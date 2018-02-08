package com.erich.easyframe.common.utils.excel.fieldtype;


/**
 * 字段类型转换
 * @author ZhengJinLing
 * @version 2013-5-29
 */
public class RoleListType {

	//private static ReportBiz reportBiz = SpringContextHolder.getBean(ReportBiz.class);
	
	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		/*List<Report> roleList = Lists.newArrayList();
		List<Report> allRoleList = reportBiz.ticketTypesReport("","","");
		for (String s : StringUtils.split(val, ",")){
			for (Report e : allRoleList){
				if (e.getProName().equals(s)){
					roleList.add(e);
				}
			}
		}*/
		return  null;//roleList.size()>0?roleList:null;
	}
}

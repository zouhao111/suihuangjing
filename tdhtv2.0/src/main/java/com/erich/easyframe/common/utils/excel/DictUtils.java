package com.erich.easyframe.common.utils.excel;


/**
 * 字典工具类
 * @author ZhengJinLing
 * @version 2013-5-29
 */
public class DictUtils {

	//	private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

	public static final String CACHE_DICT_MAP = "dictMap";

	public static String getDictLabel(String value, String type, String defaultValue) {
		/*if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}*/
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel) {
		/*	if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
				for (Dict dict : getDictList(type)){
					if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
						return dict.getValue();
					}
				}
			}*/
		return defaultLabel;
	}

	//public static List<Report> getDictList(String type){
	//	List<Report> li=null;
	/*@SuppressWarnings("unchecked")
	Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
	if (dictMap==null){
		dictMap = Maps.newHashMap();
		for (Dict dict : dictDao.findAllList()){
			List<Dict> dictList = dictMap.get(dict.getType());
			if (dictList != null){
				dictList.add(dict);
			}else{
				dictMap.put(dict.getType(), Lists.newArrayList(dict));
			}
		}
		CacheUtils.put(CACHE_DICT_MAP, dictMap);
	}
	List<Dict> dictList = dictMap.get(type);
	if (dictList == null){
		dictList = Lists.newArrayList();
	}*/
	/*return li;
	}*/

}

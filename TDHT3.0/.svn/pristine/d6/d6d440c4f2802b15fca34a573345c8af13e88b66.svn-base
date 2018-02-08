package com.fh.entity.system;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
/**
 * JSON操作工具类
 * @author ZhengJinLing
 * @date 2014-01-01
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		//mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);/字符串中存在但Java对象实际没有的属性
	   // ((MapperConfig<SerializationConfig>) mapper).setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); //设置日期格式
		//1.9版本写法
		// 忽略 为NULL的属性
		//objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL));
		//objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_EMPTY));
		//objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_EMPTY));

		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		//objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		//mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		//2.0以后版本写法
		//通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
		//Include.Include.ALWAYS 默认
		//Include.NON_DEFAULT 属性为默认值不序列化
		//Include.NON_EMPTY 属性为 空（“”）  或者为 NULL 都不序列化
		//Include.NON_NULL 属性为NULL 不序列化
		//mapper.setSerializationInclusion(Include.NON_NULL);
		//mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 将object转换成json
	 * @param object 
	 * @return
	 */
	public static String toJson(Object object) {
		String result = null;
		try {
			result = mapper.writeValueAsString(object);
			//sw = new StringWriter();
			//jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(sw);
			//jsonGenerator.writeObject(object);
			//result = sw.toString();
		} catch (IOException e) {
			log.error(e.getMessage(), e.fillInStackTrace());
		}
		return result;
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串,返回Null. 如果JSON字符串为"[]",返回空集合.
	 */
	public static <T> T fromJson(String jsonString, Class<T> className) {
		T result = null;
		if (StringUtils.hasText(jsonString)) {
			try {
				result = mapper.readValue(jsonString, className);
			} catch (Exception e) {
				log.error("parse json string error:" + jsonString, e);
			}
		}
		return result;
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串,返回Null. 如果JSON字符串为"[]",返回空集合.
	 * 
	 * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句: 
	 * List<MyBean> beanList = JsonUtil.fromJson(listString, new TypeReference<List<MyBean>>() {});
	 */
	public static <T> T fromJson(String value, TypeReference<T> type) {
		T result = null;
		if (StringUtils.hasText(value)) {
			try {
				result = mapper.readValue(value, type);
			} catch (Exception e) {
				log.error(e.getMessage(), e.fillInStackTrace());
			}
		}
		return result;
	}

	// 将LinkedHashMap映射成pojo属性
	@SuppressWarnings({ "unused" })
	public static Object readMapToObject(String className, Map<String, ?> map) {
		Class<?> demo = null;
		Object obj = null;
		try {
			demo = Class.forName(className);
			Field[] fld = demo.getFields();
			obj = demo.newInstance();
			Set<String> set = map.keySet();
			for (Iterator<String> it = set.iterator(); it.hasNext();) {
				String keyOld = it.next();
				checkSameClass(demo, obj, keyOld, map.get(keyOld));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	// 判断属性是否与传入的类属性相同
	public static void checkSameClass(Class<?> demo, Object instance, String keyOld, Object keyValue) {
		if (keyValue == null || !StringUtils.hasText(keyValue.toString()))
			return;
		boolean result1 = true;
		boolean result2 = true;
		try {
			demo.getDeclaredField(keyOld).getClass().toString();
		} catch (Exception e) {
			result1 = false;
		}
		try {
			demo.getField(keyOld).getClass().toString();
		} catch (Exception e) {
			result2 = false;
		}
		String keyNew = keyOld.substring(0, 1).toUpperCase() + keyOld.substring(1, keyOld.length());
		try {
			if (result1) {
				if (demo.getDeclaredField(keyOld).getType().getName().equals(java.util.Date.class.getName())) {
					setter(instance, keyNew, DateUtil.getDateFromString(keyValue.toString()), java.util.Date.class);
				} else if (demo.getDeclaredField(keyOld).getType().getName().equals(java.lang.Long.class.getName())) {
					setter(instance, keyNew, Long.parseLong(keyValue.toString()), java.lang.Long.class);
				} else if (demo.getDeclaredField(keyOld).getType().getName().equals(java.lang.Double.class.getName())) {
					setter(instance, keyNew, Double.parseDouble(keyValue.toString()), java.lang.Double.class);
				} else if (demo.getDeclaredField(keyOld).getType().getName().equals(java.lang.Integer.class.getName())) {
					setter(instance, keyNew, Integer.parseInt(keyValue.toString()), java.lang.Integer.class);
				} else if (demo.getDeclaredField(keyOld).getType().getName().equals(java.lang.Boolean.class.getName())) {
					setter(instance, keyNew, Boolean.parseBoolean(keyValue.toString()), java.lang.Boolean.class);
				} else if (demo.getDeclaredField(keyOld).getType().getName().equals(java.lang.Float.class.getName())) {
					setter(instance, keyNew, Float.parseFloat(keyValue.toString()), java.lang.Float.class);
				} else {
					setter(instance, keyNew, keyValue.toString(), java.lang.String.class);
				}
			} else if (result2) {
				if (demo.getField(keyOld).getType().getName().equals(java.util.Date.class.getName())) {
					setter(instance, keyNew, DateUtil.getDateFromString(keyValue.toString()), java.util.Date.class);
				} else if (demo.getField(keyOld).getType().getName().equals(java.lang.Long.class.getName())) {
					setter(instance, keyNew, Long.parseLong(keyValue.toString()), java.lang.Long.class);
				} else if (demo.getField(keyOld).getType().getName().equals(java.lang.Double.class.getName())) {
					setter(instance, keyNew, Double.parseDouble(keyValue.toString()), java.lang.Double.class);
				} else if (demo.getField(keyOld).getType().getName().toString().equals(java.lang.Integer.class.getName())) {
					setter(instance, keyNew, Integer.parseInt(keyValue.toString()), java.lang.Integer.class);
				} else if (demo.getField(keyOld).getType().getName().equals(java.lang.Boolean.class.getName())) {
					setter(instance, keyNew, Boolean.parseBoolean(keyValue.toString()), java.lang.Boolean.class);
				} else if (demo.getField(keyOld).getType().getName().equals(java.lang.Float.class.getName())) {
					setter(instance, keyNew, Float.parseFloat(keyValue.toString()), java.lang.Float.class);
				} else {
					setter(instance, keyNew, keyValue.toString(), java.lang.String.class);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param obj
	 *            操作的对象
	 * @param att
	 *            操作的属性
	 * @param value
	 *            设置的值
	 * @param type
	 *            参数的属性
	 * */
	public static void setter(Object obj, String att, Object value, Class<?> type) {
		try {
			Method method = obj.getClass().getMethod("set" + att, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeJsonGenerator(JsonGenerator jsonGenerator) {
		if (jsonGenerator != null) {
			try {
				jsonGenerator.flush();
				jsonGenerator.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

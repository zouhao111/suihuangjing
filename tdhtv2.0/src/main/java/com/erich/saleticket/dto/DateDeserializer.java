package com.erich.saleticket.dto;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 *  短日期反序列化
 * @author ZhengJinLing
 *
 */
public class DateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException,
			JsonProcessingException {
		String date = jsonparser.getText();
		if (StringUtils.isNotBlank(date)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return formatter.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}

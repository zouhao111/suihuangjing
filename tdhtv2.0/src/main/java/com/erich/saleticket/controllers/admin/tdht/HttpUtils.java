package com.erich.saleticket.controllers.admin.tdht;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 用来连接服务器
 *
 */

public class HttpUtils {

	private static final Gson gson;  
	
	static {  
        GsonBuilder gsonBuilder = new GsonBuilder();  
        gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();  
//        objectMapper = new ObjectMapper();  
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
    }  
	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}

	public static String getJsonContent(String url_path) {
		try {
			URL url = new URL(url_path);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(20000);  
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			int code = connection.getResponseCode();
			if (code == 200) {
				return changeInputStream(connection.getInputStream());
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	private static String changeInputStream(InputStream inputStream) {
		// TODO Auto-generated method stub
		String jsonString = "";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int len = 0;
		byte[] data = new byte[1024];
		try {
			while ((len = inputStream.read(data)) != -1) {
				outputStream.write(data, 0, len);
			}
			jsonString = new String(outputStream.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
	
	 public static <T> T fromJson(String json, Class<T> classOfT) {  
	        return gson.fromJson(json, classOfT);  
	    }  
	
	
	public static void main(String[] args) {
		String str=getJsonContent("http://120.76.233.59:8089/api/apitwo/data/wateDataList?rid=75501330006");
		System.out.println(str);
	}
	
	public static String httpURLConectionGET(String urls) {  
        try {  
            URL url = new URL(urls);    // 把字符串转换为URL请求地址  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接  
            //设置请求连接超时时间  
            connection.setConnectTimeout(1000);  
            //设置访问时的超时时间  
            connection.setReadTimeout(1500); 
            connection.connect();// 连接会话  
            // 获取输入流  
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
            String line;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {// 循环读取流  
                sb.append(line);  
            }  
            br.close();// 关闭流  
            connection.disconnect();// 断开连接  
           return sb.toString();
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("失败!");  
            return null;
        }  
      
    }  
	
}


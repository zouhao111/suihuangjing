package com.erich.saleticket.controllers.admin.tdht; 
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.*;
import org.apache.commons.httpclient.methods.*; 

/** 
 * 用来演示登录表单的示例 
 * @author Liudong 
 */
 
 

public class FormLoginDemo {
   static final String LOGON_SITE = "localhost" ;
   static final int     LOGON_PORT = 8089;

   public static void main(String[] args) throws Exception{
      HttpClient client = new HttpClient();
      client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);

      // 模拟登录页面 login.jsp->main.jsp
      PostMethod post = new PostMethod( "/index.jsp" );
      NameValuePair name = new NameValuePair( "name" , "ld" );
      NameValuePair pass = new NameValuePair( "password" , "ld" );
      post.setRequestBody( new NameValuePair[]{name,pass});
      int status = client.executeMethod(post);
      System.out.println(post.getResponseBodyAsString()+"00000000000000000000000000000000000000000000000");
      post.releaseConnection();

      // 查看 cookie 信息
      CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
      Cookie[] cookies = cookiespec.match(LOGON_SITE, LOGON_PORT, "/" , false , client.getState().getCookies());
      if (cookies.length == 0) {
         System.out.println( "None" +"111111111111111111111111111111111111111111111");
      } else {
         for ( int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].toString()+"2222222222222222222222222222222222222222222222222");
         }
      }

      // 访问所需的页面 main2.jsp 
     /* GetMethodget=newGetMethod("/main2.jsp");
      client.executeMethod(get);
      System.out.println(get.getResponseBodyAsString());
      get.releaseConnection();*/
   }


}
package com.erich.saleticket.controllers.admin.tdht;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.Param;

import com.erich.saleticket.controllers.BaseController;

/**
 *公司信息控制器
 * @author Lv
 */
public class CompanyController extends BaseController {
		public String video() {
			return "demo/cn/demo.html";
		}

		/**
		 * 公司信息页面
		 */
		public String com_video(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?nameId=1";
			request.setAttribute("webUrls", url);
			request.setAttribute("rid", rid);
			
			List<String> videoUrl=new ArrayList<String>();
			String videoUrls=new String();
			if(rid.equals("75506330001")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75506330002")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75506330003")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75501330022")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75501330023")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75501330024")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75501330025")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else if(rid.equals("75501330026")){
				videoUrls="hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8";
				videoUrl.add("'"+videoUrls+"'");
				request.setAttribute("videoUrl", videoUrl);
				return "demo1/com_video";
			}else{
				return "demo1/com_video";
			}
			
			
			
			
		}

	
			/**
			 * 公司信息页面
			 */
			public String info(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
				String imgSrc=null;
				String imgSrc1=null;
				String imgSrc2=null;
				if(rid.equals("75501330001")){
					imgSrc="yyf.jpg";//永艺发信息图片
				}else if(rid.equals("75501330002")) {
					 imgSrc="odk.jpg";//欧达可信息图片
				}else if(rid.equals("75501330004")) {
					 imgSrc="zckj.jpg";//欧达可信息图片
					 imgSrc2="zckj2.jpg";//欧达可信息图片
				}
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("imgSrc", imgSrc);
				request.setAttribute("imgSrc2", imgSrc2);
				request.setAttribute("rid", rid);
				return "company/info";
			}
	
			
		/**
		 * 许可证
		 */
			public String permit(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
				String imgSrc=null;
				String imgSrc1=null;
				String imgSrc2=null;
				String imgSrc3=null;
				if(rid.equals("75501330004")) {
					 imgSrc="2-zckj.jpg";//欧达可信息图片
					 imgSrc1="2-zckj2.jpg";//欧达可信息图片
					 imgSrc2="2-zckj3.jpg";//欧达可信息图片
					 imgSrc3="2-zckj4.jpg";//欧达可信息图片
				}
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("imgSrc", imgSrc);
				request.setAttribute("imgSrc1", imgSrc1);
				request.setAttribute("imgSrc3", imgSrc3);
				request.setAttribute("imgSrc2", imgSrc2);
				request.setAttribute("rid", rid);
				return "company/permit";
			}
	
		/**
		 * 厂区平面图
		 */
			public String plan(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
				String imgSrc=null;
				if(rid.equals("75501330004")) {
					 imgSrc="3-zckj.jpg";//欧达可信息图片
				}
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("imgSrc", imgSrc);
				request.setAttribute("rid", rid);
				return "company/plan";
			}
	
			/**
			 * 环评批复
			 */
			
			public String reply(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
				String imgSrc=null;
				if(rid.equals("75501330004")) {
					 imgSrc="4-zckj.jpg";//欧达可信息图片
				}
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("imgSrc", imgSrc);
				request.setAttribute("rid", rid);
				return "company/reply";
			}
			
			/**
			 * 环保验收
			 */
			public String acceptance(@Param("rid") String rid, HttpServletRequest request, HttpServletResponse response) {
				String imgSrc=null;
				String imgSrc1=null;
				if(rid.equals("75501330004")) {
					 imgSrc="5-zckj.jpg";//欧达可信息图片
					 imgSrc1="5-zckj2.jpg";//欧达可信息图片
				}
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("imgSrc", imgSrc);
				request.setAttribute("imgSrc1", imgSrc1);
				request.setAttribute("rid", rid);
				return "company/acceptance";
			}
}

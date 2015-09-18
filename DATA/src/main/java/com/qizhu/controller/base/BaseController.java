package com.qizhu.controller.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qizhu.util.FastjsonFilter;

public class BaseController {
	protected Logger log = Logger.getLogger(this.getClass());
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @param includesProperties
	 *            需要转换的属性
	 * @param excludesProperties
	 *            不需要转换的属性
	 */
	public void writeJsonByFilter(Object object, String[] includesProperties, String[] excludesProperties,HttpServletRequest request, HttpServletResponse response) {
		try {
			FastjsonFilter filter = new FastjsonFilter();// excludes优先于includes
			if (excludesProperties != null && excludesProperties.length > 0) {
				filter.getExcludes().addAll(Arrays.<String> asList(excludesProperties));
			}
			if (includesProperties != null && includesProperties.length > 0) {
				filter.getIncludes().addAll(Arrays.<String> asList(includesProperties));
			}
			System.out.println("对象转JSON：要排除的属性[" + excludesProperties + "]要包含的属性[" + includesProperties + "]");
			String json;
			String User_Agent = request.getHeader("User-Agent");
			if (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 6") > -1) {
				// 使用SerializerFeature.BrowserCompatible特性会把所有的中文都会序列化为\\uXXXX这种格式，字节数会多一些，但是能兼容IE6
				json = JSON.toJSONString(object, filter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.BrowserCompatible);
			} else {
				// 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd hh24:mi:ss
				// 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
				json = JSON.toJSONString(object, filter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
			}
			System.out.println("转换后的JSON字符串：" + json);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object,HttpServletRequest request, HttpServletResponse response) {
		 writeJsonByFilter(object, null, null,request,response);
	}

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @param includesProperties
	 *            需要转换的属性
	 */
	public void  writeJsonByIncludesProperties(Object object, String[] includesProperties,HttpServletRequest request, HttpServletResponse response) {
		 writeJsonByFilter(object, includesProperties, null,request,response);
	}

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @param excludesProperties
	 *            不需要转换的属性
	 */
	public  void writeJsonByExcludesProperties(Object object, String[] excludesProperties,HttpServletRequest request, HttpServletResponse response) {
		 writeJsonByFilter(object, null, excludesProperties,request,response);
	}
	
	/**
	 * 
	 * 保存上传的文件到服务器，并返回文件在服务器端的真实存储路径
	 * @param upload 上传的文件
	 * @param attachmentsFileName 原始文件名
	 * @return 保存的地址
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	protected  String saveUploadFile(MultipartFile upload,String attachmentsFileName,HttpServletRequest request) throws IllegalStateException, IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		//获取要保存的根路径
		String bathPath=request.getSession().getServletContext().getRealPath("/");
		System.out.println("bathPath====="+bathPath);
		String subPath=sdf.format(new Date());
		//如果文件不存在就创建
		File dir=new File(bathPath+subPath);
		if(!dir.exists()){
			dir.mkdirs();//递归创建不存在的文件夹
		}
		//截取原始文件名，获取后缀名
		String fileType=StringUtils.substringAfterLast(attachmentsFileName, ".");
		//拼接路径
		String relationPath =subPath+UUID.randomUUID().toString()+"."+fileType;
		String path=bathPath+relationPath;
		upload.transferTo(new File(path));
		Thumbnails.of(upload.getInputStream()).scale(1f).outputQuality(0.25f).toFile(path);
		//saveAttachment(upload[i],attachmentsFileName[i],path,userId,orderId,moduleIndex,fileSizeStr);
		return relationPath;
	}

}

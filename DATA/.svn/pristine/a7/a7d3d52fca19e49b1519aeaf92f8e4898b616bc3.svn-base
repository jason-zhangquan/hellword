package com.qizhu.controller.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	//主页面
	@RequestMapping("/mainPage")
	public String mainPage(){
		return "statistic/mainPage";
	}
	
	//页面分析
	@RequestMapping("/pageAnalysis")
	public String pageAnalysis(){
		return "statistic/pageAnalysis";
	}
	
	//按钮
	@RequestMapping("/button")
	public String button(){
		return "statistic/button";
	}
	
	//分享
	@RequestMapping("/sharePage")
	public String sharePage(){
		return "statistic/sharePage";
	}
	
	//页面分析,返回访问数
	@ResponseBody
	@RequestMapping("/pageShareNumeber")
	public String pageShareNumeber(
		@RequestParam(value="registrationTime") String registrationTime,//访问时间
		@RequestParam(value="identity") String identity,//身份
		@RequestParam(value="sex") String sex,//性别
		@RequestParam(value="age") String ages[],//年龄
		@RequestParam(value="section") String section//注册时间
	){
		System.out.println("访问时间"+registrationTime);
		System.out.println("身份"+identity);
		System.out.println("性别"+sex);
		
		for(String age:ages){
			System.out.println(age);
		}
		
		System.out.println("注册时间"+section);
		return "hello";
	}
	

	//用户自定义提交数据
	//处理pageAnalysis.jsp页面分析
	@ResponseBody
	@RequestMapping("/customCommitData/pageAnalysis")
	public String pageAnalysisData(
			@RequestParam(value="PageName") String PageName//页面名称
	){
		System.out.println(PageName);
		return "hello1";
	}
	
	//处理button.jsp表单
	@ResponseBody
	@RequestMapping("/customCommitData/button")
	public String buttonData(
			@RequestParam(value="PageName") String PageName//页面名称
	){
		System.out.println(PageName);
		return "hello2";
	}
	
	//处理sharePage.jsp表单
	@ResponseBody
	@RequestMapping("/customCommitData/sharePage")
	public String sharePageData(
			@RequestParam(value="PageName") String PageName//页面名称
	){
		System.out.println(PageName);
		return "hello3";
	}
	
}

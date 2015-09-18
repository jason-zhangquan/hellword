package com.qizhu.controller.statistics;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qizhu.core.Constant;
import com.qizhu.model.statistics.Statistics;
import com.qizhu.service.statistics.IStatisticsService;

/**
 * 统计分析app接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/app/statistics")
public class AppStatisticController {
	
	@Autowired
	private IStatisticsService statisticsService;

	//客户端访客统计接口
	//http://192.168.0.101:8080/DATA/app/statistic/visitorStatistics?telephoneType=123&versionVal=456&version=789&userId=101&accessTime=102&identity=103&sex=111&age=114&registrationTime=123456
	@ResponseBody
	@RequestMapping("/addStatistics")
	public Map<String, Object> pageShaerInterface(
			Statistics statistics 
	){
		Map<String, Object> map = new HashMap<String, Object>();
		statistics.setAccessTime(new Date());
		statisticsService.save(statistics);
		map.put("Result", Constant.SUCEESS);
		map.put("MessageInfo", "操作成功！");
		return map;
		
	}
}

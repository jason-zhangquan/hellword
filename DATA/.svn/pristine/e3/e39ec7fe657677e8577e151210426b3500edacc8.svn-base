package com.qizhu.controller.user;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.data.TreeData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Tree;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.qizhu.custom.JsonView;
import com.qizhu.model.user.User;
import com.qizhu.service.user.IUserService;
import com.qizhu.util.GsonUtil;

/**
 * 用户
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/toLogin")
	public ModelAndView addUserUI() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		mv.addObject("title", "登录界面");
		return mv;
	}
	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestParam(value="loginName",required=false)String loginName,
			@RequestParam(value="password",required=false)String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(loginName);
		System.out.println(password);
		
		map.put("result", "success");
		
		return map;
	}
	
	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping("/toMain")
	public String login() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		return "user/index";
	}
	

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, Object> addUser() {
		Map<String, Object> map = new HashMap<String, Object>();

		User user = new User();
//		user.setUserName("高俊峰");
		user.setEmail("aaa@qq.com");
		userService.save(user);
		map.put("user", user);
		return map;
	}

	/**
	 * 到修改用户页面
	 * 
	 * @return
	 */
	@RequestMapping("/updateUserUI")
	public String updateUserUI(Map<String, Object> map) {
		map.put("userName", "张三");
		return "updateUserUI";
	}

	/**
	 * 如何让 Spring MVC Controller 的同一个 URL 请求，根据逻辑判断返回 JSON 或者 HTML 视图？
	 * 同一个请求可以判断是返回一个页面还是返回一个json数据到客户端
	 * http://localhost:8080/DATA/user/register?browser=true
	 * 
	 * @param response
	 * @param browser
	 * @return
	 */
	/*
	@RequestMapping("/register")
	public ModelAndView doRegister(HttpServletResponse response,
			@RequestParam(value = "browser", required = false) String browser) {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setEmail("609617824@qq.com");
//		user.setUserName("张权");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("page", 1);
		map.put("rows", 10);
		if (browser != null && browser.equals("true")) {// 有值且为 true，是浏览器终端发起的请求
														// ，返回页面

			ModelAndView mv = new ModelAndView();

			mv.setViewName("addUserUI");
			mv.addObject("map", map);

			return mv;
		} else {// 无值或不为 true，是浏览器之外的终端发起的请求
			return JsonView.render(map, response);// 其他终端，返回注册失败的 JSON 串
		}
	}*/

	/**
	 * 展示报表
	 * 
	 * @return
	 */
	@RequestMapping("/showEcharts")
	public ModelAndView showEcharts() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("echarts/bar");
		return mv;
	}

	@RequestMapping("/getEchartsData")
	@ResponseBody
	public Map<String, Object> getEchartsData() {
		Map<String, Object> map = new HashMap<String, Object>();

		Option option = new Option();
		option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
		option.tooltip().trigger(Trigger.axis);
		option.legend("蒸发量", "降水量");
		option.toolbox()
				.show(true)
				.feature(Tool.mark, Tool.dataView,
						new MagicType(Magic.line, Magic.bar).show(true),
						Tool.restore, Tool.saveAsImage);
		option.calculable(true);
		option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月",
				"6月", "7月", "8月", "9月", "10月", "11月", "12月"));
		option.yAxis(new ValueAxis());

		Bar bar = new Bar("蒸发量");
		bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0,
				6.4, 3.3);
		bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"),
				new PointData().type(MarkType.min).name("最小值"));
		bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));

		Bar bar2 = new Bar("降水量");
		bar2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8,
				6.0, 2.3);
		bar2.markPoint().data(
				new PointData("年最高", 182.2).xAxis(7).yAxis(183).symbolSize(18),
				new PointData("年最低", 2.3).xAxis(11).yAxis(3));
		bar2.markLine()
				.data(new PointData().type(MarkType.average).name("平均值"));

		option.series(bar, bar2);
		System.out.println(GsonUtil.format(option));
		map.put("option", GsonUtil.format(option));
		return map;
	}

	@RequestMapping("/getEchartsDataPie")
	@ResponseBody
	public Map<String, Object> getEchartsDataPie() {
		Map<String, Object> mapData = new HashMap<String, Object>();
		Option option = new Option();
		option.title().text("树图").subtext("虚构数据");
        option.tooltip().trigger(Trigger.item).formatter("{b}: {c}");
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                Tool.restore,
                Tool.dataZoom,
                Tool.values(),
                Tool.saveAsImage);
        option.calculable(false);

        Tree tree = new Tree("树图");
        tree.orient(Orient.horizontal).nodePadding(20).symbol("circle").symbolSize(40).rootLocation().x(100).y("60%");
        tree.itemStyle().normal().label(new Label().show(true).position("inside")
        		.textStyle(new TextStyle().color("#cc9999").fontSize(15).fontWeight("bolder")))
                .lineStyle().color("#000")
//                .shadowColor("#000")
//                .shadowBlur(3)
//                .shadowOffsetX(3)
//                .shadowOffsetY(5)
                .width(1)
                .type(LineType.dashed);
        tree.itemStyle().emphasis().label().show(true);

        TreeData root = new TreeData("手机",6);
        root.setSymbol("image://http://www.iconpng.com/png/ecommerce-business/iphone.png");
        ItemStyle rootItemStyle = new ItemStyle();
        rootItemStyle.normal().label(new Label().show(false));
        root.itemStyle(rootItemStyle);
        
        List<TreeData> children = new LinkedList<TreeData>();
        children.add(new TreeData("子节点1",41));
        children.add(new TreeData("子节点2",42));
        children.add(new TreeData("子节点3",333));
        children.add(new TreeData("子节点4",244));
        
//        TreeData subRoot = new TreeData("子根节点",4);
        List<TreeData> subChildren = new LinkedList<TreeData>();
        subChildren.add(new TreeData("小米1",41));
        subChildren.add(new TreeData("小米2",100));
        subChildren.add(new TreeData("小米3",100));
        
        TreeData data = new TreeData("小米",155); 
        int dataSymbolSize[] = {60, 60}; 
        data.setChildren(subChildren);
        data.setSymbol("image://http://pic.58pic.com/58pic/12/36/51/66d58PICMUV.jpg");
        data.setSymbolSize(dataSymbolSize);
        children.add(data);
        
        root.setChildren(children);
        int symbolSize[] = {90, 70}; 
        root.setSymbolSize(symbolSize);
        tree.data(root);

        option.series(tree);
		mapData.put("option", GsonUtil.format(option));
		System.out.println(GsonUtil.format(option));
		return mapData;
	}
//	@RequestMapping("/getEchartsDataPie")
//	@ResponseBody
//	public Map<String, Object> getEchartsDataPie() {
//		Map<String, Object> mapData = new HashMap<String, Object>();
//		Option option = new Option();
//		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("Map");
//		map.mapLocation(new MapLocation(X.left, Y.top, 500));
//		map.selectedMode(SelectedMode.multiple);
//		map.itemStyle().normal().borderWidth(2)
//		.borderColor("lightgreen").color("orange")
//		.label().show(true);
//		
//		map.itemStyle().emphasis()
//		.borderWidth(2).borderColor("#fff").color("#32cd32")
//		.label().show(true)
//		.textStyle().color("#fff");
//		Data data = new Data("广东");
//		data.value(Math.round(Math.random() * 1000));
//		data.itemStyle().normal().color("#32cd32")
//		.label().show(true).textStyle().color("#fff").fontSize(15);
//		data.itemStyle().emphasis().borderColor("yellow").color("#cd5c5c")
//		.label().show(false).textStyle().color("blue");
//		
//		map.data(data);
//		map.markPoint().itemStyle().normal().color("skyblue");
//		map.markPoint().data(new Data("天津", 350), new Data("上海", 103));
//		
//		map.geoCoord("上海", "121.4648", "31.2891").geoCoord("天津", "117.4219", "39.4189");
//		
//		option.series(map);
//		mapData.put("option", GsonUtil.format(option));
//		return mapData;
//	}
	
	public static void main(String[] args) {
		Option option = new Option();
		option.title().text("树图").subtext("虚构数据");
        option.tooltip().trigger(Trigger.item).formatter("{b}: {c}");
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                Tool.restore,
                Tool.dataZoom,
                Tool.values(),
                Tool.saveAsImage);
        option.calculable(false);

        Tree tree = new Tree("树图");
        tree.orient(Orient.horizontal).nodePadding(20).symbol("circle").symbolSize(40).rootLocation().x(100).y("60%");
        tree.itemStyle().normal().label(new Label().show(true).position("inside")
        		.textStyle(new TextStyle().color("#cc9999").fontSize(15).fontWeight("bolder")))
                .lineStyle().color("#000")
//                .shadowColor("#000")
//                .shadowBlur(3)
//                .shadowOffsetX(3)
//                .shadowOffsetY(5)
                .width(1)
                .type(LineType.booken);
        tree.itemStyle().emphasis().label().show(true);

        TreeData root = new TreeData("手机",6);
        root.setSymbol("image://http://www.iconpng.com/png/ecommerce-business/iphone.png");
        ItemStyle rootItemStyle = new ItemStyle();
        rootItemStyle.normal().label(new Label().show(false));
        root.itemStyle(rootItemStyle);
        
        List<TreeData> children = new LinkedList<TreeData>();
        children.add(new TreeData("子节点1",41));
        children.add(new TreeData("子节点2",42));
        children.add(new TreeData("子节点3",333));
        children.add(new TreeData("子节点4",244));
        
//        TreeData subRoot = new TreeData("子根节点",4);
        List<TreeData> subChildren = new LinkedList<TreeData>();
        subChildren.add(new TreeData("小米1",41));
        subChildren.add(new TreeData("小米2",100));
        subChildren.add(new TreeData("小米3",100));
        
        TreeData data = new TreeData("小米",155); 
        int dataSymbolSize[] = {60, 60}; 
        data.setChildren(subChildren);
        data.setSymbol("image://http://pic.58pic.com/58pic/12/36/51/66d58PICMUV.jpg");
        data.setSymbolSize(dataSymbolSize);
        children.add(data);
        
        root.setChildren(children);
        int symbolSize[] = {90, 70}; 
        root.setSymbolSize(symbolSize);
        tree.data(root);

        option.series(tree);
		System.out.println(GsonUtil.prettyFormat(option));
	}
	
	
	

}

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" content="IE=edge,chrome=1">
    <meta content="telephone=no" name="format-detection">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <meta name="apple-touch-fullscreen" content="YES" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <!-- jsp文件头和头部 -->
	<%@ include file="../user/top.jsp"%>
	<!-- 主样式 -->
	<link rel="stylesheet" href="${contextPath}/static/statistics/pageAnalysis/css/pageAnalysis.css" />
	<!-- 联动日历插件 
	<script type="text/javascript" src="${contextPath}/plugins/pickerDateRange/jquery.min.js"></script>
	-->
	<script type="text/javascript" src="${contextPath}/plugins/pickerDateRange/dateRange.js"></script>
	<link rel="stylesheet" href="${contextPath}/plugins/pickerDateRange/dateRange.css" />
	<!-- 日历格式化插件 
	<script type="text/javascript" src="${contextPath}/plugins/moment/moment.js"></script>
	-->
</head>
<body style="background-color: #ffffff;">
<div class="breadcrumbs showNumberBox">
	访客总数:123456
</div>
<form class="form-horizontal" role="form">
	<!-- #section:elements.form -->
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 时间: </label>
		<div class="col-sm-4">
			<div class="radio">
				<label>
					<input name="time" type="radio" checked="true" class="ace">
					<span class="lbl"> 昨天</span>
				</label>
				<label>
					<input name="time" type="radio" class="ace">
					<span class="lbl"> 周一</span>
				</label>
				<label>
					<input name="time" type="radio" class="ace">
					<span class="lbl"> 一个月</span>
				</label>
				<label>
					<span class="lbl"> 自定义时间</span>
					<input name="time" type="radio" class="ace">
					<input class="input-sm" name="time" type="text" id="date_demo3" placeholder="请选择时间">
					<div id="datePicker"></div>
				</label>
				<!--id="date_demo3"<div id="datePicker"></div>-->
				<script type="text/javascript">
	                var dateRange = new pickerDateRange('date_demo3', {
	                    isTodayValid : true,
	                    //startDate : '2015-08-1',//使用默认当前月份
	                    //endDate : '2015-8-31',
	                    defaultText : ' 至 ',
	                    inputTrigger : 'input_trigger_demo3',
	                    theme : 'ta',
	                    success : function(obj) {
	                        //自定义的回调函数 callback();
	                    }
	                });
				</script>
			</div>
		</div>
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 身份: </label>
		<div class="col-sm-6">
			<div class="radio">
				<label>
					<input name="identity" type="radio" checked="true" class="ace">
					<span class="lbl"> ALL</span>
				</label>
				<label>
					<input name="identity" type="radio" class="ace">
					<span class="lbl"> 游客</span>
				</label>
				<label>
					<input name="identity" type="radio" class="ace">
					<span class="lbl"> 会员</span>
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 性别: </label>
		<div class="col-sm-4">
			<div class="radio">
				<label>
					<input name="gender" type="radio" checked="true" class="ace">
					<span class="lbl"> ALL</span>
				</label>
				<label>
					<input name="gender" type="radio" class="ace">
					<span class="lbl"> 男</span>
				</label>
				<label>
					<input name="gender" type="radio" class="ace">
					<span class="lbl"> 女</span>
				</label>
			</div>
		</div>
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 年龄: </label>
		<div class="col-sm-6">
			<div class="checkbox">
				<label>
					<input name="age" type="checkbox" checked="true" class="ace">
					<span class="lbl"> ALL</span>
				</label>
				<label>
					<input name="age15" type="checkbox" class="ace">
					<span class="lbl"> 15岁以下</span>
				</label>
				<label>
					<input name="age1618" type="checkbox" class="ace">
					<span class="lbl"> 16~18岁</span>
				</label>
				<label>
					<input name="age1922" type="checkbox" class="ace">
					<span class="lbl"> 19~22岁</span>
				</label>
				<label>
					<input name="age2325" type="checkbox" class="ace">
					<span class="lbl"> 23~25</span>
				</label>
				<label>
					<input name="age2630" type="checkbox" class="ace">
					<span class="lbl"> 26~30</span>
				</label>
				<label>
					<input name="age3135" type="checkbox" class="ace">
					<span class="lbl"> 31~35岁</span>
				</label>
				<label>
					<input name="age35" type="checkbox" class="ace">
					<span class="lbl"> 35岁以上</span>
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 注册区间: </label>
		<div class="col-sm-4">
			<div class="radio">
				<label>
					<input name="registeredTime" type="radio" checked="true" class="ace">
					<span class="lbl"> ALL</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 1日</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 3日</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 7日</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 半年</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 一年</span>
				</label>
				<label>
					<input name="registeredTime" type="radio" class="ace">
					<span class="lbl"> 一年以上</span>
				</label>
			</div>
		</div>
	</div>	
</form>

<form class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="form-field-1">自定义页面: </label>
		<div class="col-sm-10">
			<input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-11">&nbsp
			<button type="button" class="btn btn-white btn-success">&nbsp提&nbsp交&nbsp</button>
		</div>
	</div>
</form>
<%--表格--%>
<div class="col-xs-12">
	<table id="sample-table-1" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="center">页面名称</th>
				<th>微信</th>
				<th>朋友圈</th>
				<th>QQ</th>
				<th>QQ空间</th>
				<th>腾讯微博</th>
				<th>新浪微博</th>
			</tr>
		</thead>

		<tbody>
			<tr class="">
				<td class="center">今日运势</td>
				<td>22</td>
				<td>33</td>
				<td>44</td>
				<td>55</td>
				<td>44</td>
				<td>55</td>
			</tr>
			<tr class="">
				<td class="center">测试题</td>
				<td>22</td>
				<td>33</td>
				<td>44</td>
				<td>55</td>
				<td>44</td>
				<td>55</td>
			</tr>
			<tr class="">
				<td class="center">吉日结果</td>
				<td>22</td>
				<td>33</td>
				<td>44</td>
				<td>55</td>
				<td>44</td>
				<td>55</td>
			</tr>
		</tbody>
	</table>	
</div><!-- /.span -->
		
</body>
</html>
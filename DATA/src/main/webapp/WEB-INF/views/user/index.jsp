﻿<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>首页</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<!-- jsp文件头和头部 -->
<%@ include file="top.jsp"%>
<style type="text/css">
iframe,.tabpanel_content{
	overflow-y: hidden!important;
}
.main-content{
	height: 0px!important;
}
</style>
</head>

<body class="no-skin">
	<!-- 页面顶部¨ -->
	<%@ include file="head.jsp"%>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- #左侧 -->
		<!-- 左侧菜单 -->
		<%@ include file="left.jsp"%>
		<!-- /左侧 -->

		<!-- 中间 -->
		<div class="main-content">
			<!-- 换肤 -->
			<%@ include file="skin.jsp"%>
			<!-- /换肤-->
			<!-- 主体内容 -->
			<div id="mian-contentBox" style="width:100%;">
				<div id="tab"></div>
			</div>
			<!-- 主体内容 -->
		</div>
		<!-- /.main-content -->
		<!-- 底部 -->
		<%@ include file="footer.jsp"%>
		<!-- 底部-->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

		<!-- 插件 -->
		<%@ include file="plugins.jsp"%>
		<!-- 插件 -->
</body>
</html>
<!-- 使用脚本动态给主体内容设置高度 -->
<script type="text/javascript">
	function setContentBox(){
		//获取主内容区域
		var mianContentBox=document.getElementById("mian-contentBox");
		//var height=(window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight)-45-75; 
		mianContentBox.style.height=(document.body.scrollHeight-45-75)+"px";
	}
	setContentBox();
	var i=0;
	window.onresize=function(){
			setContentBox();
	}
</script>

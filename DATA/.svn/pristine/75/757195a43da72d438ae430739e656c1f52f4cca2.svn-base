<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://lib.h-ui.net/html5.js"></script>
    <script type="text/javascript" src="http://lib.h-ui.net/respond.min.js"></script>
    <script type="text/javascript" src="http://lib.h-ui.net/PIE_IE678.js"></script>
    <![endif]-->
    <link href="http://static.h-ui.net/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="http://static.h-ui.net/h-ui/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="http://static.h-ui.net/h-ui/css/H-ui.doc.css" rel="stylesheet" type="text/css" />
    <link href="http://lib.h-ui.net/Hui-iconfont/1.0.2/iconfont.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('.pngfix,.iconpic,.list-icon');</script>
    <![endif]-->
    <title></title>

    <link href="http://lib.h-ui.net/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <%--
    <link href="http://lib.h-ui.net/bootstrap-Switch/bootstrapSwitch.css" rel="stylesheet" type="text/css" />
	--%>

	<%--导入自定义时间插件
	<script src="js/jquery-1.11.2.min.js"></script>
	--%>
	<link rel="stylesheet" href="plugins/multipleDate/css/daterangepicker.css" />
	<script type="text/javascript" src="plugins/multipleDate/js/moment.min.js"></script>
	<script type="text/javascript" src="plugins/multipleDate/js/jquery.daterangepicker.js"></script>
	<!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
    
    <%--主样式--%>	
    <script type="text/javascript" src="static/statistics/pageAnalysis/js/pageAnalysis.js"></script>
    <%--加载进度条插件--%>
    <script type="text/javascript" src="plugins/spin/spin.min.js"></script>	
    
</head>
<body>
<div class="text-c">访问:<span id="showNumber">123</span></div>
<form action="" method="post" class="form form-horizontal responsive" id="statisticsForm1">
	<div class="row cl">
		<label class="form-label col-1">时间：</label>
		<div class="formControls col-11">
			<div class="radio-box">
	            <input type="radio" name="registrationTime" value="昨天" checked="checked" id="registrationTime1">
	            <label for="registrationTime1">昨天</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="registrationTime" value="一周" id="registrationTime2">
	            <label for="registrationTime2">一周</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="registrationTime" value="一个月" id="registrationTime3">
	            <label for="registrationTime3">一个月</label>
	        </div>
	        <div class="radio-box">
	        	<!-- 这个表单后台不解析 -->
	       	 	<input type="radio" name="registrationTime" value="123" id="registrationTime4">
	        	<label for="registrationTime4">自定义时间</label>
	        </div>
	        <input type="hidden" name="CustomTime" class="input-text" style="width:30%;font-size: 12px;" id="registrationTimeChecked" placeholder="请选择时间">  
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-1">身份：</label>
		<div class="formControls col-11">
			<div class="radio-box">
	            <input type="radio" name="identity" value="all" checked="checked" id="identity1">
	            <label for="identity1">ALL</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="identity" value="游客" id="identity2">
	            <label for="identity2">游客</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio"  name="identity" value="会员" id="identity3">
	            <label for="identity3">会员</label>
	        </div>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-1">性别：</label>
		<div class="formControls col-11">
			<div class="radio-box">
	            <input type="radio" name="sex" value="all" checked="checked" id="sex1">
	            <label for="sex1">ALL</label>
	        </div>
			<div class="radio-box">
	            <input type="radio" name="sex" value="男" id="sex2">
	            <label for="sex2">男&nbsp;&nbsp;&nbsp;&nbsp;</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="sex" value="女" id="sex3">
	            <label for="sex3">女&nbsp;&nbsp;</label>
	        </div>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-1">年龄：</label>
		<div class="formControls col-11">
			<div class="check-box">
	            <input type="checkbox" name="age" value="all" checked="checked" id="age1"> 
	            <label for="age1">ALL</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age15" value="15" class="ageNumber" checked="checked" id="age2">
	            <label for="age2">15岁以下</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age1618" value="1618" class="ageNumber" checked="checked" id="age3">
	            <label for="age3">16-18岁</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age1922" value="1922" class="ageNumber" checked="checked" id="age4">
	            <label for="age4">19-22岁</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age2325" value="2325" class="ageNumber" checked="checked" id="age5">
	            <label for="age5">23-25岁</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age2630" value="2630" class="ageNumber" checked="checked" id="age6">
	            <label for="age6">26-30岁</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age3135" value="3135" class="ageNumber" checked="checked" id="age7">
	            <label for="age7">31-35岁</label>
	        </div>
	        <div class="check-box">
	            <input type="checkbox" name="age35" value="35" class="ageNumber" checked="checked" id="age8">
	            <label for="age8">35岁以上</label>
	        </div>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-1">注册区间：</label>
		<div class="formControls col-11">
			<div class="radio-box">
	            <input type="radio" name="section" value="all" checked="checked" id="section1">
	            <label for="section1">ALL</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="section" value="3" id="section2">
	            <label for="section2">3日</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="section" value="7" id="section3">
	            <label for="section3">7日</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="section" value="半年" id="section4">
	            <label for="section4">半年</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="section" value="一年" id="section5">
	            <label for="section5">一年</label>
	        </div>
	        <div class="radio-box">
	            <input type="radio" name="section" value="一年以上 " id="section6">
	            <label for="section6">一年以上</label>
	        </div>
		</div>
	</div>
</form>
<form action="" method="post" class="form form-horizontal responsive" id="statisticsForm2">
	<div class="row cl">
      <label class="form-label col-1">自定义页面：</label>
      <div class="formControls col-10">
        <input type="text" name="PageName" class="input-text" id="PageNameInput" autocomplete="off" placeholder="请输入页面名称">
      </div>
      <input class="btn btn-primary radius" name="sharePage" id="CustomButton" type="button" value="提交">
    </div>
</form>
<div class="row cl" style="margin-top: 20px;">
  <label class="form-label col-1"></label>
  <div class="formControls col-10">
	<table class="table table-border table-bordered table-hover">
	  <thead>
	    <tr>
	      <th>页面名称</th>
	      <th>浏览量</th>
	      <th>访客数</th>
	      <th>平均访问时间</th>
	      <th>跳出数</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr><!-- class="text-c"居中 --><!-- class="text-r"居右 -->
	      <th>主页</th>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	    </tr>
	    <tr>
	      <th>吉日</th>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	    </tr>
	    <tr>
	      <th>个人信息</th>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	      <td>表格内容</td>
	    </tr>
	  </tbody>
	</table>
  </div>
</div>
<%--进度条开始--%>
<div id="foo" style="width:100px; height:100px;position: absolute; left: 50%;top:30%;display: none;"></div>
<%--进度条接收--%>
	<%--
	<script type="text/javascript" src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script>
	
	<script type="text/javascript" src="http://lib.h-ui.net/bootstrap-Switch/bootstrapSwitch.js"></script>
	<script type="text/javascript" src="http://lib.h-ui.net/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript" src="http://lib.h-ui.net/Validform/5.3.2/passwordStrength-min.js"></script>
	
	<script type="text/javascript">
	//初始化表单美化样式
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
		/*
        $("#menu_3 dt").addClass("selected");$("#menu_3 dd").show();;
        $("#demoform-2").Validform({
            tiptype:2,
            usePlugin:{
                datepicker:{},//日期控件校验;
                passwordstrength:{
                    minLen:6,//设置密码长度最小值，默认为0;
                    maxLen:18,//设置密码长度最大值，默认为30;
                    trigger:function(obj,error){
                        //该表单元素的keyup和blur事件会触发该函数的执行;
                        //obj:当前表单元素jquery对象;
                        //error:所设密码是否符合验证要求，验证不能通过error为true，验证通过则为false;
                        //console.log(error);
                        if(error){
                            obj.parent().find(".Validform_checktip").show();
                            obj.parent().find(".passwordStrength").hide();
                        }else{
                            obj.parent().find(".passwordStrength").show();
                        }
                    }
                }
            }
        });*/
    });
	</script>
	--%>
</body>
</html>
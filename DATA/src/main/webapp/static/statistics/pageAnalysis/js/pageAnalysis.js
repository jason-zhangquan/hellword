$(function(){
//初始化日历2132
	$('#registrationTimeChecked').dateRangePicker().bind('datepicker-change',function(event,obj){
		//alert(obj+"1");
	    // obj will be something like this:
	    // {
	    //      date1: (Date object of the earlier date),
	    //      date2: (Date object of the later date),
	    //      value: "2013-06-05 to 2013-06-07"
	    // }
	}).bind('datepicker-apply',function(event,obj){//选定玩日期调用
	    console.log(obj.value);
		//把最后通过表单获取的时间，赋值到单选框上。后台只需要解析单选框的name即可
	    $("#registrationTime4").val(obj.value);
	    NumberVisitorsObj.gteAjax();//选定完日期，在提交一下数据
	}).bind('datepicker-close',function(){
		//alert('close'+"3");
	});

//加载进度条
	var targetObj=(function(){
		var opts = {
	        lines: 9, // The number of lines to draw
	        length: 0, // The length of each line
	        width: 10, // The line thickness
	        radius: 15, // The radius of the inner circle
	        corners: 1, // Corner roundness (0..1)
	        rotate: 0, // The rotation offset
	        color: '#000', // #rgb or #rrggbb
	        speed: 1, // Rounds per second
	        trail: 60, // Afterglow percentage
	        shadow: false, // Whether to render a shadow
	        hwaccel: false, // Whether to use hardware acceleration
	        className: 'spinner', // The CSS class to assign to the spinner
	        zIndex: 2e9, // The z-index (defaults to 2000000000)
	        top: 'auto', // Top position relative to parent in px
	        left: 'auto' // Left position relative to parent in px
	    };
	    var target = document.getElementById('foo');
	    var spinner = new Spinner(opts).spin(target);

	    //进度条显示
	    function targetShow(){
	    	$(target).show();
	    }
	    //进度条隐藏
	    function targetHied(){
	    	var timeout=setTimeout(function(){
	    		$(target).hide();	  //进度隐藏
	            clearTimeout(timeout);//取消延迟执行
	        },500);	
	    }
	    return {
	    	'targetShow':targetShow,
	    	'targetHied':targetHied
	    }
	})();
		
	//访客总数
	function getNumberVisitors(){
		//初始化
		this.init();
		this.submitForm();
		this.gteAjax();
	}
	//初始化提价
	getNumberVisitors.prototype.init=function(){
		//点击自定义时间。表单显示
		$("#registrationTime4").on("click",function(){
			$("#registrationTimeChecked").attr("type","text");
		});
		//点击其他表单消失
		$("#registrationTime1 , #registrationTime2 ,#registrationTime3").on("click",function(){
			$("#registrationTimeChecked").attr("type","hidden");
		});
		
		//点击年龄ALL全选或反选
		var ageNumber=$(".ageNumber");
		var age1=$("#age1");
		age1.on("change",function(){
			if(this.checked){
				for(var i=0 ; i<ageNumber.length ;i++){
					ageNumber.eq(i).get(0).checked=true;
				}
			}else{
				for(var i=0 ; i<ageNumber.length ;i++){
					ageNumber.eq(i).get(0).checked=false;
				}
			}
		});
		//点击其中任意年龄
		ageNumber.on("change",function(){
			var boo=true;
			for(var i=0 ;i<ageNumber.length;i++){
				if(!ageNumber.eq(i).get(0).checked){
					boo=false;
				}
			}
			boo ? age1.get(0).checked=true : age1.get(0).checked=false;
		});
	}
	//statisticsForm1
	getNumberVisitors.prototype.gteAjax=function(){
		var foo=$("#foo");
		$.ajax({
		     type: 'POST',
		     url: 'statistic/pageShareNumeber',        
		     data:$( '#statisticsForm1').serialize(),
		     success:function(response,status,xhr){
		         $("#showNumber").html(response);
		     },
		     complete: function(){
		         //alert('请求完成后，不管是请求成功，还是请求失败都执行'); 
		    	 targetObj.targetHied();
		     },
		     beforeSend: function(){
		         //alert('发送请求之前执行');
		    	 targetObj.targetShow();
		     },
		     error: function(){
		         //alert ('请求失败后执行');  
		    	 targetObj.targetHied();
		     }
		});
	}

	//提交表单
	getNumberVisitors.prototype.submitForm=function(){
		var This=this;
		//点击表单1内的任意表单。除了#registrationTime4意外，头提交表单
		$("#statisticsForm1 input").not("#registrationTime4").on("change",function(){
			This.gteAjax();
		});
	}
	var NumberVisitorsObj=new getNumberVisitors();
	
	
	//自定义提交
	function getCustomPage(){
		this.clickEvent();
	}
	getCustomPage.prototype.clickEvent=function(){
		var This=this;
		$("#CustomButton").on("click",function(){
			var name=$(this).attr("name");//获取当前点击按钮所在页面的名称
			var customPageNmar=$("#PageNameInput");
			if(customPageNmar.val() !== ""){
				customPageNmar.css("border","1px solid #d5d5d5");
				This.gteAjax(name);
			}else{//提示错误，添加红色边框
				customPageNmar.css("border","1px solid red");
			}
		});
	}
	getCustomPage.prototype.gteAjax=function(name){
		var url='';
		if(name == 'pageAnalysis'){
			url='statistic/customCommitData/pageAnalysis';
		}else if(name == 'button'){
			url='statistic/customCommitData/button';
		}else if(name == 'sharePage'){
			url='statistic/customCommitData/sharePage';
		}
		
		alert($( '#statisticsForm2').serialize());
		$.ajax({
		     type: 'POST',
		     url: url,        
		     data:$( '#statisticsForm2').serialize(),
		     success:function(response,status,xhr){
		    	if(name == 'pageAnalysis'){
		 			alert(response);
		 		}else if(name == 'button'){
		 			alert(response);
		 		}else if(name == 'sharePage'){
		 			alert(response);
		 		}
		     },
		     complete: function(){
		         //alert('请求完成后，不管是请求成功，还是请求失败都执行'); 
		    	 targetObj.targetHied();
		     },
		     beforeSend: function(){
		         //alert('发送请求之前执行');
		    	 targetObj.targetShow();
		     },
		     error: function(){
		         //alert ('请求失败后执行');  
		    	 targetObj.targetHied();
		     }
		});
	}
	new getCustomPage();
	
});
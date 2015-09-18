<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
</head>

<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height:400px"></div>
	<div id = "echarts"></div>
</body>
<!-- ECharts单文件引入 -->
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('main'));
	/*
	 $.ajax({
	 type: "post",
	 url: "user/getEchartsData",
	 data: {browser:"true"},
	 dataType: "json",
	 success: function(data){
	 console.log(eval(data.option));
	 myChart.setOption(JSON.parse(data.option));
	 // 为echarts对象加载数据
	 }
	 })
	 */
	$.getJSON('user/getEchartsData?date='+new Date(), function(data) {
		if (data) {
			console.log(data.option); 
			myChart.setOption(JSON.parse(data.option));
		} else {
			alert('提示,出錯！'); 
		}
	});
	 /*
	var option =  {
		    title : {
		        text: '手机品牌',
		        subtext: '线、节点样式'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{b}: {c}"
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : false,

		    series : [
		        {
		            name:'树图',
		            type:'tree',
		            orient: 'horizontal',  // vertical horizontal
		            rootLocation: {x: 100, y: '60%'}, // 根节点位置  {x: 'center',y: 10}
		            nodePadding: 20,
		            symbol: 'circle',
		            symbolSize: 40,
		            itemStyle: {
		                normal: {
		                    label: {
		                        show: true,
		                        position: 'inside',
		                        textStyle: {
		                            color: '#cc9999',
		                            fontSize: 15,
		                            fontWeight:  'bolder'
		                        }
		                    },
		                    lineStyle: {
		                        color: '#000',
		                        width: 1,
		                        type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
		                    }
		                },
		                emphasis: {
		                    label: {
		                        show: true
		                    }
		                }
		            },
		            data: [
		                {
		                    name: '手机',
		                    value: 6,
		                    symbolSize: [90, 70],
		                    symbol: 'image://http://www.iconpng.com/png/ecommerce-business/iphone.png',
		                    itemStyle: {
		                        normal: {
		                            label: {
		                                show: false
		                            }
		                        }
		                    },
		                    children: [
		                        {
		                            name: '小米',
		                            value: 4,
		                            symbol: 'image://http://pic.58pic.com/58pic/12/36/51/66d58PICMUV.jpg',
		                            itemStyle: {
		                                normal: {
		                                    label: {
		                                        show: false
		                                    }
		                                }
		                            },
		                            symbolSize: [60, 60],
		                            children: [
		                                {
		                                    name: '小米1',
		                                    symbol: 'circle',
		                                    symbolSize: 20,
		                                    value: 4,
		                                    itemStyle: {
		                                        normal: {
		                                            color: '#fa6900',
		                                            label: {
		                                                show: true,
		                                                position: 'right'
		                                            },
		                                            
		                                        },
		                                        emphasis: {
		                                            label: {
		                                                show: false
		                                            },
		                                            borderWidth: 0
		                                        }
		                                    }
		                                },
		                                {
		                                    name: '小米2',
		                                    value: 4,
		                                    symbol: 'circle',
		                                    symbolSize: 20,
		                                    itemStyle: {
		                                        normal: {
		                                            label: {
		                                                show: true,
		                                                position: 'right',
		                                                formatter: "{b}"
		                                            },
		                                            color: '#fa6900',
		                                            borderWidth: 2,
		                                            borderColor: '#cc66ff'

		                                        },
		                                        emphasis: {
		                                            borderWidth: 0
		                                        }
		                                    }
		                                },
		                                {
		                                    name: '小米3',
		                                    value: 2,
		                                    symbol: 'circle',
		                                    symbolSize: 20,
		                                    itemStyle: {
		                                        normal: {
		                                            label: {
		                                                position: 'right'
		                                            },
		                                            color: '#fa6900',
		                                            brushType: 'stroke',
		                                            borderWidth: 1,
		                                            borderColor: '#999966',
		                                        },
		                                        emphasis: {
		                                            borderWidth: 0
		                                        }
		                                    }
		                                }
		                            ]
		                        },
		                        {
		                            name: '苹果',
		                            symbol: 'image://http://www.viastreaming.com/images/apple_logo2.png',
		                            symbolSize: [60, 60],
		                            itemStyle: {
		                                normal: {
		                                    label: {
		                                        show: false
		                                    }
		                                    
		                                }
		                            },
		                            value: 4
		                        },
		                        {
		                            name: '华为',
		                            symbol: 'image://http://market.huawei.com/hwgg/logo_cn/download/logo.jpg',
		                            symbolSize: [60, 60],
		                            itemStyle: {
		                                normal: {
		                                    label: {
		                                        show: false
		                                    }
		                                    
		                                }
		                            },
		                            value: 2
		                        },
		                        {
		                            name: '联想',
		                            symbol: 'image://http://www.lenovo.com.cn/HomeUpload/Home001/6d94ee9a20140714.jpg',
		                            symbolSize: [100, 40],
		                            itemStyle: {
		                                normal: {
		                                    label: {
		                                        show: false
		                                    }
		                                    
		                                }
		                            },
		                            value: 2
		                        }
		                    ]
		                }
		            ]
		        }
		    ]
		};
	 myChart.setOption(option);*/
</script>
</html>

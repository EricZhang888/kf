<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/style.min.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-3">
                <div class="widget style1">
                    <div class="row">
                        <div class="col-xs-4 text-center">
                            <i class="fa fa-trophy fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> 今日收入 </span>
                            <h2 class="font-bold">&yen; 4,232</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="widget style1 navy-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-cloud fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> 今日温度 </span>
                            <h2 class="font-bold">26'C</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="widget style1 lazur-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-envelope-o fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> 新消息 </span>
                            <h2 class="font-bold">260</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="widget style1 yellow-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-music fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> 新专辑 </span>
                            <h2 class="font-bold">12</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="widget navy-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">&yen; 1,540</h1>

                        <h3 class="font-bold no-margins">
                            年收入
                        </h3>
                        <small>项目年收入</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart1"></div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="widget lazur-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">&yen; 210,660</h1>

                        <h3 class="font-bold no-margins">
                            月收入
                        </h3>
                        <small>项目年收入</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart2"></div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="widget yellw-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">&yen; 50,992</h1>

                        <h3 class="font-bold no-margins">
                            半年收入
                        </h3>
                        <small>市场销售额</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart3"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <div class="widget style1 navy-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">217</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="widget style1 navy-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-thumbs-up fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">400</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="widget style1 navy-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-rss fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">10</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="widget style1 lazur-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-phone fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">120</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="widget style1 lazur-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-euro fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">462</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="widget style1 yellow-bg">
                    <div class="row vertical-align">
                        <div class="col-xs-3">
                            <i class="fa fa-shield fa-3x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h2 class="font-bold">610</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>收益曲线</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="flot-chart">
                            <div class="flot-chart-content" id="flot-line-chart-multi" style="padding: 0px; position: relative;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/resource/javascript/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/jquery-ui-1.10.4.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/content.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/flot/jquery.flot.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/flot/jquery.flot.resize.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/flot/jquery.flot.pie.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/demo/flot-demo.min.js"></script>
    <script>
        $(document).ready(function(){var d1=[[1262304000000,6],[1264982400000,3057],[1267401600000,20434],[1270080000000,31982],[1272672000000,26602],[1275350400000,27826],[1277942400000,24302],[1280620800000,24237],[1283299200000,21004],[1285891200000,12144],[1288569600000,10577],[1291161600000,10295]];var d2=[[1262304000000,5],[1264982400000,200],[1267401600000,1605],[1270080000000,6129],[1272672000000,11643],[1275350400000,19055],[1277942400000,30062],[1280620800000,39197],[1283299200000,37000],[1285891200000,27000],[1288569600000,21000],[1291161600000,17000]];var data1=[{label:"Data 1",data:d1,color:"#17a084"},{label:"Data 2",data:d2,color:"#127e68"}];$.plot($("#flot-chart1"),data1,{xaxis:{tickDecimals:0},series:{lines:{show:true,fill:true,fillColor:{colors:[{opacity:1},{opacity:1}]},},points:{width:0.1,show:false},},grid:{show:false,borderWidth:0},legend:{show:false,}});var data2=[{label:"Data 1",data:d1,color:"#19a0a1"}];$.plot($("#flot-chart2"),data2,{xaxis:{tickDecimals:0},series:{lines:{show:true,fill:true,fillColor:{colors:[{opacity:1},{opacity:1}]},},points:{width:0.1,show:false},},grid:{show:false,borderWidth:0},legend:{show:false,}});var data3=[{label:"Data 1",data:d1,color:"#fbbe7b"},{label:"Data 2",data:d2,color:"#f8ac59"}];$.plot($("#flot-chart3"),data3,{xaxis:{tickDecimals:0},series:{lines:{show:true,fill:true,fillColor:{colors:[{opacity:1},{opacity:1}]},},points:{width:0.1,show:false},},grid:{show:false,borderWidth:0},legend:{show:false,}});$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",});$(".todo-list").sortable({placeholder:"sort-highlight",handle:".handle",forcePlaceholderSize:true,zIndex:999999}).disableSelection();var mapData={"US":498,"SA":200,"CA":1300,"DE":220,"FR":540,"CN":120,"AU":760,"BR":550,"IN":200,"GB":120,"RU":2000};$("#world-map").vectorMap({map:"world_mill_en",backgroundColor:"transparent",regionStyle:{initial:{fill:"#e4e4e4","fill-opacity":1,stroke:"none","stroke-width":0,"stroke-opacity":0}},series:{regions:[{values:mapData,scale:["#1ab394","#22d6b1"],normalizeFunction:"polynomial"}]},})});
    </script>
</body>
</html>

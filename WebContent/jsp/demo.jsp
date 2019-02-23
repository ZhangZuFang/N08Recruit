
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!doctype html>


<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/amcharts.js"></script>
<style>
body {
	background:white;
}
div { margin: -.8em auto; text-align:center; width: 90%; height: 390px }
</style>
<script type="text/javascript">
var chart;
var legend;
var chartData = [
 {··
num: "0",
value: 0},              
{
    num: "0",
    value: 0},
{
    num: "0",
    value: 0},{
    num: "未完成计划数",
    value: 58},
{
    num: "实际招收人数",
    value: 49},
    
    
    
];
	
	
	////根据json数据生成饼状图，并将饼状图显示到div中  
AmCharts.ready(function() {
    // 饼图
    chart = new AmCharts.AmPieChart();
    chart.dataProvider = chartData;
	//标题数据  
    chart.titleField = "num";
	 //值数据  
    chart.valueField = "value";
	 //边框线颜色  
    chart.outlineColor = "";
	 //边框线的透明度  
    chart.outlineAlpha = 0.8;
	 //边框线的框宽度  
    chart.outlineThickness = 2;
    // 3D
    chart.depth3D = 20;
    chart.angle = 30;
    // 图形写入
    chart.write("chartdiv");
});
</script>
</head>
<body>
<div id="chartdiv"></div>
</body>
</html>
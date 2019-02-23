<%--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>巢湖学院招生管理系统</title>

<!-- 布局引入的脚本和样式 -->
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/modernizr.min.js"></script>


<!-- jqGrid引入的脚本和样式 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.layout.js"></script>
<script type="text/javascript" src="js/grid.locale-en.js"></script>
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.8.2.custom.css" />
<!--  
<script type="text/javascript" src="./js/jquery.contextmenu.js"></script>-->

<!-- 个人或参考的脚本 -->
<script type="text/javascript" src="js/import.js"></script>
<script type="text/javascript" src="js/recruit.js"></script>

</head>
<body>
	<jsp:include page="layout01.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="layout02.jsp"></jsp:include>

		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎您进入巢湖学院招生管理系统！</span>
				</div>
			</div>
			<div class="result-wrap">
				<table id="list"></table>
				<div id="plist"></div>
			</div>
		</div>
</body>
</html>
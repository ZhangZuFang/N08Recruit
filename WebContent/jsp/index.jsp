<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>巢湖学院招生管理系统</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/modernizr.min.js"></script>
</head>
<body>
	<jsp:include page="layout01.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="layout02.jsp"></jsp:include>
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎您进入巢湖学院招生管理系统！</span>
				</div>
			</div>

			<div class="result-wrap">
				<div class="result-title">
					<h1>系统基本信息</h1>
				</div>
				<div class="result-content">
					<ul class="sys-info-list">
						<li><label class="res-lab">操作系统</label><span class="res-info">windows系列</span>
						</li>
						<li><label class="res-lab">运行环境</label><span class="res-info">数据库
								MySql Server 5.6</span></li>
						<li><label class="res-lab"></label><span class="res-info">应用服务器
								Tomcat 6.0</span></li>
						<li><label class="res-lab"></label><span class="res-info">IE浏览器为6.0以上</span></li>
						<li><label class="res-lab">上传附件限制</label><span
							class="res-info">Excel文件类型</span></li>

						<li><label class="res-lab">服务器域名/IP</label><span
							class="res-info">localhost [ 127.0.0.1 ]</span></li>
						<li><label class="res-lab">功能介绍</label><span class="res-info">导入数据模块：导入excel类型学生信息</span>
						<li><label class="res-lab"></label><span class="res-info">学员查询模块：可以查询到院系及专业学生信息</span>
						<li><label class="res-lab"></label><span class="res-info">所有学员模块：对所有导入数据的统计分析</span>
						<li><label class="res-lab"></label><span class="res-info">数据统计模块：查看当前招生结果</span>
						<li><label class="res-lab"></label><span class="res-info">数据备份模块：备份处理的数据</span>
						<li><label class="res-lab"></label><span class="res-info">数据还原模块：如果数据库中有数据丢失，对数据进行还原</span>
					</ul>

				</div>
			</div>

			</div>
			<!--/main-->
		</div>
</body>
</html>
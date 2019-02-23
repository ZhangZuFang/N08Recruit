<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<%--<%@ import java.lang.String %>  --%>
<html>
<head>
<meta charset="UTF-8">
<title>巢湖学院招生管理系统</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/import.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jQuery Easing.js	"></script>
<script type="text/javascript" src="js/dataAnalyse.js"></script>
</head>
<body>
	<jsp:include page="layout01.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="layout02.jsp"></jsp:include>
		<div>
			<ul id="sdt_menu" class="sdt_menu">
				<li><a href="" target="_blank"> <img src="css/images/3.jpg"
						alt="" /> <span class="sdt_active"></span> <span class="sdt_wrap">
							<span class="sdt_link">各省招生进度</span>
					</span>
				</a>
<div class="sdt_box">
					
<c:forEach items="${inforFromPlanProvincNo}" var="provinceInfor">
<a href="dataAnalyse.do?planNo=" + ${provinceInfor}  target="_blank">
								${provinceInfor.province}</a> 
</c:forEach>
				
	</div></li> 				
			</ul>
			<ul id="sdt_menu" class="sdt_menu">
				<li><a href="" target="_blank"> <img src="css/images/4.jpg"
						alt="" /> <span class="sdt_active"></span> <span class="sdt_wrap">
							<span class="sdt_link">各省占百分比</span>
					</span>
				</a></li>
			</ul>

		</div>
	</div>

</body>
</html>
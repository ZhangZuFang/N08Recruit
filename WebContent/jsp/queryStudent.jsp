
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巢湖学院招生管理系统</title>
<!-- 布局引入的脚本和样式 -->
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/modernizr.min.js"></script>

<!-- jqGrid引入的脚本和样式 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/jquery.layout.js" type="text/javascript"></script>
<script type="text/javascript" src="js/grid.locale-en.js"></script>
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.8.2.custom.css" />
	
<!--  <script type="text/javascript" src="./js/jquery.contextmenu.js"></script>-->

<!-- 个人或参考的脚本 -->
<script type="text/javascript" src="js/import.js"></script>
<script type="text/javascript" src="js/recruit.js"></script>
</head>

<body>
	<jsp:include page="layout01.jsp" ></jsp:include>
	<div class="container clearfix">
		<jsp:include page="layout02.jsp"></jsp:include>
		<div class="main-wrap">
			<table style="width: 100%">
				<tr>
					<td>
						<table style="width: 60%">
							<tr onclick="hideTR('trb')">
								<td>
									<table>
										<tr>
											<td><img src="css/images/close.png" /></td>
											<td>请输入查询条件</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="trb">
								<td>
									<table>
										<tr>
											<td width="5%">院系：</td>
											<td width="20%"><select id="yuanxi"
												onchange="searchzhuanye()">
													<c:forEach items="${departList}" var="depart">
														<option value=${depart.departId} >${depart.departName}</option>
													</c:forEach>
											</select></td>
											<td width="5%">专业：</td>
											<td width="20%"><select id="zhuanye" onchange="reload()"></select></td>
											
											
										</tr>
										
									</table>
								</td>
							</tr>
							<tr onclick="hideTR('divList')">
								<td>
									<table>
										<tr>
											<td><img src="css/images/close.png" /></td>
											<td>学员列表</td>
										</tr>
									</table>
 
								</td>
							</tr>
						</table>
			<div id="divList">
				<table id="list"></table>
				<div id="plist"></div>
			</div>
			<div class="main-wrap" id="printDiv">
				<button id="print" onclick="print()">生成通知书</button>
				<button id="a" onclick="generateXmls()">生成xmls</button>
			</div>
			</td>
			</tr>
			</table>
			</div>
			</div>
</body>
</html>
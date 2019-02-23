<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<%--<%@ import java.lang.String %>  --%>
<html>
<head>
<meta charset="UTF-8">
<title>巢湖学院招生管理系统</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/import.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="layout01.jsp"></jsp:include>
	<div class="container clearfix">

		<jsp:include page="layout02.jsp"></jsp:include>
		<div class="crumb-wrap">
			<div class="crumb-list">
				<i class="icon-font">&#xe06b;</i><span>欢迎您进入巢湖学院招生管理系统！</span>
			</div>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br>

		<p style="margin-left: 500px;">导入学员信息表，本校院系表，本校专业表</p>
		<div>
			<form style="margin-left: 500px;" id="studentInfor"
				name="excelImportForm" action="excelSave.do" method="post"
				onsubmit="return check();" id="excelImportForm"
				enctype="multipart/form-data">
				<div class="modal-body">
					<div class="row gap">
						<label class="col-sm-7 control-label"> <!-- input的type="file"定义文件选择字段和 "浏览..." 按钮，供文件上传： -->
							<input class="btn btn-default" id="excel_SInfor" type="file"
							name="filename" accept="xls" />
						</label> <input class="btn btn-primary" id="excel_button" type="submit"
							value="导入Excel" />

					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
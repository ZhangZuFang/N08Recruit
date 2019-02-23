<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link href="css/admin_login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/md5.js"></script>
<!--  <script type="text/javascript" src="js/encryption.js"></script>-->
<script language="javascript">
    function SubmitForm() {
	/* alert("WWW");
	 alert(document.getElementById("pwd").value); */
    // document.getElementById("username").value = hex_md5(document.getElementById("username").value);
  //  document.getElementById("pwd").value = hex_md5(document.getElementById("pwd").value);
    //alert(hex_md5(document.getElementById("pwd").value))
    //document.form1.submit
    }
</script>
</head>
<body>
	<div class="admin_login_wrap">
		<h1>巢湖学院招生管理</h1>
		<div class="adming_login_border">
			<div class="admin_input">
				<form action="loginSubmit.do" method="post">
					<ul class="admin_items">
						<li><label for="user">用户名：</label> <input type="text"
							name="username" id="user" size="40" class="admin_input_style" />
						</li>

						<li><label for="pwd">密码：</label> <input type="password"
							name="pwd" id="pwd" size="40" class="admin_input_style" /></li>

						<li><input type="submit" value="提交" class="btn btn-primary"
							onclick="SubmitForm();" /></li>
					</ul>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
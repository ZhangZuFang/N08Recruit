<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/MajorPNum.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		as.initSearch();
	});
</script>
</head>
<body>
	<table>
		<form>
			<input id="m_button" type="button" /> <input id="result" type="text" />
		</form>
	</table>
	<select id="selectdd">

	</select>

</body>
</html>


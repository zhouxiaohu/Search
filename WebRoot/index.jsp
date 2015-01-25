<%@ page language="java" pageEncoding="UTF-8"%>
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

		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/index.css">
	</head>

	<body>

		<div class="content">

			<div class="img">
				<img src="image/bg.jpg" />
			</div>

			<div class="search">
				<form method="post" action="SearchAction_search.action">
					<input type="text" class="text" name="param.keyword"/>
					<input type="submit" class="btn" value="搜  索" />
				</form>
			</div>
		</div>

	</body>
</html>

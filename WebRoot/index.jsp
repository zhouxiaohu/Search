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

		<title> Movie search</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	</head>

	<body>

		<div class="content">

			<div class="img">
				<img src="image/bg.jpg" />
			</div>

			<div class="search">
				<form method="post" action="SearchAction_search.action">
					<input type="text" class="text" name="param.keyword" id="keyword"/>
					<input type="submit" class="btn" value="搜  索" />
				</form>
			</div>
		</div>

	</body>
	
	<script charset="gbk" src="js/searchSug.js"></script>
	<script type="text/javascript">
		//回调函数，用于获取用户当前选择的文字
		var params = {
		"XOffset":2, //提示框位置横向偏移量,单位px
		"YOffset":0, //提示框位置纵向偏移量,单位px
		"width":204, //提示框宽度，单位px
		"fontColor":"#f70", //提示框文字颜色
		"fontColorHI":"#FFF",	//提示框高亮选择时文字颜色
		"fontSize":"12px",		//文字大小
		"fontFamily":"宋体",	//文字字体
		"borderColor":"gray", 	//提示框的边框颜色
		"bgcolorHI":"#03c",		//提示框高亮选择的颜色
		"sugSubmit":true		//在选择提示词条是是否提交表单
		};
	
	 	BaiduSuggestion.bind("keyword");
	</script>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

		<title>结果</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/data.css">

	</head>

	<body>
		<div class="head">

		</div>
		<div class="content">

			<div class="search">
				<form method="post" action="SearchAction_search.action">
					<input type="text" class="text" name="param.keyword" />
					<input type="submit" class="btn" value="搜  索" />
				</form>
			</div>

			<div class="data">

				<s:iterator value="datas">
					<table>
						<tr>
							<td class="title">
								<s:property value='title' />
							</td>
						</tr>
						<tr>
							<td class="text">
								<s:property value='text' />
							</td>
						</tr>
						<tr>
							<td class="other">
								<span>时间:<s:property value='time' /> |</span>
								<span>作者:<s:property value='author' /> |</span>
								<span>来源:<s:property value='host' />
								</span>
							</td>
						</tr>
					</table>
				</s:iterator>

			</div>
		</div>
	</body>
</html>

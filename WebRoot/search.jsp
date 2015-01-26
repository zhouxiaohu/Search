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

<title><s:property value='param.keyword'/></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/search.css">
<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />

</head>

<body>
	<div class="head"></div>
	<div class="content">

		<div class="search">
			<form method="post" action="SearchAction_search.action">
				<input type="text" class="text" name="param.keyword" id="keyword"
					value="<s:property value='param.keyword'/>" /> <input
					type="submit" class="btn" value="搜  索" />
			</form>
		</div>
		<!-- 相关结果与检索时间 -->
		<div class="result">
			<span>共为您找到相关结果: <font><s:property value="pageBean.totalRecords"/></font> 条, </span>
			
			<span>共消耗: <font><s:property value="pageBean.timeConsume"/> s</font></span>
		</div>

		<div class="data">

			<s:iterator value="datas">
				<table>
					<tr>
						<td class="title"><s:property value='title' escape="false" />
						</td>
					</tr>
					<tr>
						<td class="text"><s:property value='text' escape="false" /></td>
					</tr>
					<tr>
						<td class="other"><span>索引时间:<s:property value='time' />
								|
						</span> <span>作者:<s:property value='author' /> |
						</span> <span>来源:<s:property value='host' />
						</span></td>
					</tr>
				</table>
			</s:iterator>

		</div>

		<!--分页-->
		<div class="page">
			<table width="100%">
				<tr>
					<td class="pageLeft"><font>共 ${pageBean.totalRecords}
							条记录&nbsp;每页&nbsp;${pageBean.pageSize }&nbsp;条，第&nbsp;${pageBean.pageNo
								}&nbsp;页,共&nbsp;${pageBean.totalPage }&nbsp;页</font>
					</td>
					<td class="pageRight"><a
						href="SearchAction_search.action?pageBean.pageNo=1&param.keyword=<s:property value='param.keyword'/>">首页&nbsp;</a> <a
						href="SearchAction_search.action?pageBean.pageNo=<s:property value='pageBean.pageNo-1'/>&param.keyword=<s:property value='param.keyword'/>">上一页&nbsp;</a>
						<s:if test="pageBean.pageNo < pageBean.totalPage">
							<a
								href="SearchAction_search.action?pageBean.pageNo=<s:property value='pageBean.pageNo+1'/>&param.keyword=<s:property value='param.keyword'/>">下一页&nbsp;</a>
						</s:if> <a
						href="SearchAction_search.action?pageBean.pageNo=${pageBean.totalPage }&param.keyword=<s:property value='param.keyword'/>">末页&nbsp;</a>

					</td>
				</tr>
			</table>
		</div>
		
		
		<!-- 版权申明 -->
		<div class="foot">
			<span>© 版权所有 周小虎</span>
		</div>
	</div>
</body>

<script charset="gbk" src="js/searchSug.js"></script>
<script type="text/javascript">
	//回调函数，用于获取用户当前选择的文字
	var params = {
		"XOffset" : 0, //提示框位置横向偏移量,单位px
		"YOffset" : 0, //提示框位置纵向偏移量,单位px
		"width" : 204, //提示框宽度，单位px
		"fontColor" : "#f70", //提示框文字颜色
		"fontColorHI" : "#FFF", //提示框高亮选择时文字颜色
		"fontSize" : "12px", //文字大小
		"fontFamily" : "宋体", //文字字体
		"borderColor" : "gray", //提示框的边框颜色
		"bgcolorHI" : "#03c", //提示框高亮选择的颜色
		"sugSubmit" : true
	//在选择提示词条是是否提交表单
	};

	BaiduSuggestion.bind("keyword");
</script>
</html>

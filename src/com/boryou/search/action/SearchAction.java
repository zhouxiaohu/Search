/**
  * 项目名：Search
  * 文件名：SearchAction.java
  * 作者：zxh
  * 时间：2015-1-23 下午03:35:02
  * 描述：
  */
package com.boryou.search.action;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.boryou.search.entity.Param;
import com.boryou.search.entity.SolrBean;
import com.boryou.search.solr.SolrServerBiz;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 类名： SearchAction
 * 包名： com.boryou.search.action
 * 作者： zxh
 * 时间： 2015-1-23 下午03:35:02
 * 描述： 
 */
public class SearchAction extends ActionSupport {

	/**
	 * long:serialVersionUID  
	 * 描述：
	 */
	private static final long serialVersionUID = 1L;

	private Param param;
	private ArrayList<SolrBean> datas;

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public ArrayList<SolrBean> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<SolrBean> datas) {
		this.datas = datas;
	}

	/**
	 * 
	 * 方法名：search
	 * 作者：zxh
	 * 创建时间：2015-1-23 下午04:37:38
	 * 描述：根据关键词查询索引数据
	 * @return 
	 * @return String
	 */
	public String search() {

		// 创建查询组件
		SolrQuery query = new SolrQuery();
		// 填充查询关键词
//		param = new Param();
//		param.setKeyword("寒暑假做饭");
		if (param.getKeyword().equals("")) {
			query.setQuery("*:*");
		} else {
			query.add("q", "text:" + param.getKeyword());
			// 开启高亮功能
			query.setHighlight(true);
			// 高亮字段
			query.addHighlightField("text");
			// 渲染标签
			query.setHighlightSimplePre("<font color=\"red\">");
			// 渲染标签
			query.setHighlightSimplePost("</font>");

		}

		// 设置返回字段

		query.addField("id");
		query.addField("title");
		query.addField("text");
		query.addField("time");
		query.addField("author");
		query.addField("host");
		query.addField("url");

		HttpSolrServer server = SolrServerBiz.getSolrServer();
		if (server != null) {

			try {
				// 开始查询
				QueryResponse response = server.query(query);
				datas = (ArrayList<SolrBean>) response.getBeans(SolrBean.class);

				return "success";
			} catch (SolrServerException e) {
				e.printStackTrace();
			}
		}

		return "fail";
	}

	public static void main(String[] args) {

		new SearchAction().search();
	}
}

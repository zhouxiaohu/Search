/**
  * 项目名：Search
  * 文件名：SearchAction.java
  * 作者：zxh
  * 时间：2015-1-23 下午03:35:02
  * 描述：
  */
package com.boryou.search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.boryou.search.constant.Constant;
import com.boryou.search.entity.PageBean;
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

	private HttpSolrServer server = SolrServerBiz.getSolrServer();

	private Param param = new Param();
	private PageBean pageBean = new PageBean();
	private ArrayList<SolrBean> datas = new ArrayList<SolrBean>();

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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
	 * @return String
	 */
	public String search() {

		double start = System.currentTimeMillis();
		// 封装查询组件
		SolrQuery query = sealQuery();
		// 开始查询
		QueryResponse response = query(query, pageBean.getPageNo());
		// 封装查询结果
		sealDatas(response);
		pageBean.setTimeConsume(((System.currentTimeMillis()) - start) / 1000);
		return "success";
	}

	/**
	 * 
	 * 方法名：sealQuery
	 * 作者：zxh
	 * 创建时间：2015年1月26日 下午12:08:15
	 * 描述：封装查询组件
	 * @return SolrQuery
	 */
	public SolrQuery sealQuery() {

		// 创建查询组件
		SolrQuery query = new SolrQuery();
		// 填充查询关键词
		if (param.getKeyword().equals("")) {
			query.setQuery("*:*");
		} else {
			query.add("q", "title_text:" + param.getKeyword());

			// 开启高亮功能
			query.setHighlight(true);
			// 高亮字段
			query.addHighlightField("text");
			query.addHighlightField("title");
			// 渲染标签
			query.setHighlightSimplePre("<font color=\"red\">");
			query.setHighlightSimplePost("</font>");

		}

		return query;
	}

	/**
	 * 
	 * 方法名：query
	 * 作者：zxh
	 * 创建时间：2015年1月26日 上午11:52:37
	 * 描述：开始查询
	 * @param query 封装了查询条件的query组件
	 * @param PageNo 页号
	 * @return QueryResponse
	 */

	public QueryResponse query(SolrQuery query, int pageNo) {

		QueryResponse response = null;

		if (server != null) {
			// 数据分页
			query.setStart((pageNo - 1) * Constant.PAGE_SIZE);
			query.setRows(Constant.PAGE_SIZE);

			// 查询
			try {
				response = server.query(query);
			} catch (SolrServerException e) {
				e.printStackTrace();
				return response;
			}
		}

		return response;
	}

	/**
	 * 
	 * 方法名：sealDatas
	 * 作者：zxh
	 * 创建时间：2015年1月26日 下午12:02:54
	 * 描述：封装查询结果集
	 * @param response 
	 * @return void
	 */
	public void sealDatas(QueryResponse response) {

		if (response == null)
			return;
		// 获得高亮结果集
		// 最外围的map的key是document的id，里面的map的key是高亮字段名
		Map<String, Map<String, List<String>>> map = response.getHighlighting();

		// 查询结果集
		SolrDocumentList list = response.getResults();

		pageBean.setTotalRecords((int) response.getResults().getNumFound());
		Object title = null;
		Object text = null;
		for (SolrDocument doc : list) {
			// 获得每一篇document
			SolrBean bean = new SolrBean();
			bean.setId((String) doc.get("id"));
			bean.setAuthor((String) doc.get("author"));
			bean.setHost((String) doc.get("host"));
			bean.setTime((String) doc.get("time"));
			bean.setUrl((String) doc.get("url"));

			if (map != null) {
				// 下面对标题和正文进行高亮处理
				title = map.get(doc.get("id")).get("title");
				if (title == null) {
					bean.setTitle((String) doc.get("title"));
				} else {
					bean.setTitle(title.toString());
				}

				text = map.get(doc.get("id")).get("text");
				if (text == null) {
					bean.setText((String) doc.get("text"));
				} else {
					bean.setText(text.toString());
				}
			} else {
				bean.setTitle((String) doc.get("title"));
				bean.setText((String) doc.get("text"));
			}

			datas.add(bean);
		}
	}

	public static void main(String[] args) {
		SearchAction search = new SearchAction();
		search.param.setKeyword("我");
		search.search();
	}
}

/**
  * 项目名：Search
  * 文件名：SolrServerBiz.java
  * 作者：zxh
  * 时间：2015-1-23 下午04:50:07
  * 描述：
  */
package com.boryou.search.solr;

import org.apache.solr.client.solrj.impl.HttpSolrServer;

import com.boryou.search.constant.Constant;

/**
 * 类名： SolrServerBiz
 * 包名： com.boryou.search.solr
 * 作者： zxh
 * 时间： 2015-1-23 下午04:50:07
 * 描述： 
 */
public class SolrServerBiz {

	public final static HttpSolrServer server = new HttpSolrServer(
			Constant.SOLR_SERVER_URL);

	private SolrServerBiz() {
	}

	public static HttpSolrServer getSolrServer() {

		return server;
	}
}

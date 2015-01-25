/**
  * 项目名：BBSCrawlerSingleV1.0
  * 文件名：SolrBean.java
  * 作者：zxh
  * 时间：2015年1月23日 上午10:27:56
  * 描述：
  */
package com.boryou.search.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 类名： SolrBean
 * 包名： com.boryou.crawler.module.solr
 * 作者： zxh
 * 时间： 2015年1月23日 上午10:27:56
 * 描述： 
 */
public class SolrBean {

	@Field
	private String id;
	@Field
	private String title;
	@Field
	private String author;
	@Field
	private String text;
	@Field
	private String time;
	@Field
	private String host;
	@Field
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SolrBean id=" + id + ", title=" + title + ", author=" + author
				+ ", text=" + text + ", time=" + time + ", host=" + host
				+ ", url=" + url + "\r\n";
	}
	
}

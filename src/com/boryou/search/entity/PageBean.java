package com.boryou.search.entity;

import java.io.Serializable;

/**
 * 
 * 类名： PageBean
 * 包名： com.boryou.search.entity
 * 作者： zxh
 * 时间： 2015年1月26日 上午11:34:10
 * 描述：
 */
@SuppressWarnings("serial")
public class PageBean implements Serializable {
	// 页号
	private int pageNo = 1;
	// 每页记录数
	private int pageSize = 10;
	// 总记录数
	private int totalRecords = 0;
	// 总页数
	private int totalPage = 0;
	// 排序字段
	private String orderBy = "";
	// 升序还是降序
	private String sort = "asc";
	// 查询结果耗时
	private double timeConsume;

	public PageBean() {

	}

	public PageBean(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	// 计算得到总页数
	public int getTotalPage() {
		totalPage = (getTotalRecords() - 1) / getPageSize() + 1;
		totalPage = (totalPage < 1) ? 1 : totalPage;
		return totalPage;
	}

	// 计算得到开始的记录位置
	public int getFirstRecord() {
		int ret = (getPageNo() - 1) * getPageSize();// + 1;
		ret = (ret < 0) ? 0 : ret;
		return ret;
	}

	public int getPageNo() {
		return (pageNo <= 0) ? 1 : pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return (pageSize <= 0) ? 10 : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public double getTimeConsume() {
		return timeConsume;
	}

	public void setTimeConsume(double timeConsume) {
		this.timeConsume = timeConsume;
	}

}

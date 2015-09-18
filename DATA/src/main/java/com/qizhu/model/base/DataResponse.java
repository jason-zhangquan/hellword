package com.qizhu.model.base;

import java.util.List;

/**
 * 
 * 给前台发送数据也定义了响应的DataResponse类 
 * @author Administrator
 *
 * @param <T>
 */
public class DataResponse <T> {

	//须要显示的数据集
	private List<T> datas;

	//每页显示数量
	private int page;
	
	//数据总数
	private int records;
	
	//可显示的页数
	private int total;

	
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}

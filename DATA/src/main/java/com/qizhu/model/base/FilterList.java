package com.qizhu.model.base;

import java.util.List;
/**
 * 封装jqgrid多条件查询时页面传来的参数
 * @author Administrator
 *
 */
public class FilterList {
	private String groupOp;
	private List<Rule> rules;
	private List<FilterList> groups;
	
	public List<FilterList> getGroups() {
		return groups;
	}
	public void setGroups(List<FilterList> groups) {
		this.groups = groups;
	}
	public String getGroupOp() {
		return groupOp;
	}
	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	

}

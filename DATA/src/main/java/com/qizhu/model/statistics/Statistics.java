package com.qizhu.model.statistics;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 对客户端点击次数的统计
 * @author Administrator
 *
 */
@Entity
@Table(name = "DATA_STATISTICS")
public class Statistics {//统计点击
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "statisticsId", length = 36)
	private String statisticsId;//id	
	
	@Column(name = "telephoneType")
	private short telephoneType;//客户端类型
	
	
	@Column(name = "version", length=20)
	private String version;//版本号
	
	@Column(name = "userId", length=20)
	private String userId;//用户id
	
	@Column(name = "accessTime", length=30)
	private Date accessTime;//用户访问时间
	@Column(name = "type")
	private short type;//页面类型，1为跳转页面，2为按钮，3为分享
	@Column(name = "subType", length=50)
	private String subType;//子页面类型
	@Column(name = "source")
	private short source;//来源
	

	
	

	public short getSource() {
		return source;
	}

	public void setSource(short source) {
		this.source = source;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	

	public short getType() {
		return type;
	}

	//get  set
	public String getStatisticsId() {
		return statisticsId;
	}

	public void setStatisticsId(String statisticsId) {
		this.statisticsId = statisticsId;
	}

	

	public short getTelephoneType() {
		return telephoneType;
	}

	public void setTelephoneType(short telephoneType) {
		this.telephoneType = telephoneType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}


}

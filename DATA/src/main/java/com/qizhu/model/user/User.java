package com.qizhu.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户信息
 */
@Entity
@Table(name = "Calandar_USER")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -1837122526285858427L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "userId", length = 36)
	private String userId;// 主键Id

	@Column(name = "password", length = 50)
	private String password;// 密码

	@Column(name = "trueName", length = 20)
	private String trueName;// 真实姓名

	@Column(name = "email", length = 30, unique = true)
	private String email;// 邮箱

	@Column(name = "telephoneNumber", length = 20)
	private String telephoneNumber;// 手机号码

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime")
	private Date createTime;// 创建时间

	@Column(name = "description", length = 200)
	private String description;// 备注、说明

	@Column(name = "nickName", length = 100)
	private String nickName;// 昵称

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthTime")
	private Date birthTime;// 生日

	@Column(name = "userSex")
	private Short userSex = 1;// 1.默认为男,2.女

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "codeTime")
	private Date codeTime;// 验证码生成的时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endLoginTime")
	private Date endLoginTime;// 最后 一次登录时间

	@Column(name = "loginTimes")
	private int loginTimes;// 登录次数统计

	@Column(name = "imageUrl", length = 200)
	private String imageUrl;// 头像地址

	@Column(name = "codeVal", length = 20)
	private String codeVal;// 生成的验证码

	@Column(name = "wxId", length = 60)
	private String wxId;// 微信ID

	@Column(name = "isRegiste")
	private Short isRegiste = 1;// 是否注册成功，默认为0没有注册，1为注册失败，但已经在数据库生成了一条记录，2为注册成功，已经可以登录了

	@Column(name = "registeWay", length = 200)
	private String registeWay; // 通过哪个平台注册的

	@Column(name = "salt", length = 50)
	private String salt; // 通过哪个平台注册的

//	@Column(name = "locked")
//	private boolean locked; // 是否锁定

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public Short getUserSex() {
		return userSex;
	}

	public void setUserSex(Short userSex) {
		this.userSex = userSex;
	}

	public Date getCodeTime() {
		return codeTime;
	}

	public void setCodeTime(Date codeTime) {
		this.codeTime = codeTime;
	}

	public Date getEndLoginTime() {
		return endLoginTime;
	}

	public void setEndLoginTime(Date endLoginTime) {
		this.endLoginTime = endLoginTime;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCodeVal() {
		return codeVal;
	}

	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public Short getIsRegiste() {
		return isRegiste;
	}

	public void setIsRegiste(Short isRegiste) {
		this.isRegiste = isRegiste;
	}

	public String getRegisteWay() {
		return registeWay;
	}

	public void setRegisteWay(String registeWay) {
		this.registeWay = registeWay;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

//	public boolean getLocked() {
//		return locked;
//	}
//
//	public void setLocked(boolean locked) {
//		this.locked = locked;
//	}

}
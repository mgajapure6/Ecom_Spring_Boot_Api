package com.ecommerce.ecom_api.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column(nullable=false, length=30,unique=true)
	private String userName;
	
	@Column(nullable=false, length=30)
	private String userPassword;
	
	@Column(length=30)
	private String userEmail;
	
	@Column(length=10)
	private String userPhone;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Lob
	private byte[] userImage;
	
	@Column(length=1,nullable=false)
	private String deleteFlag;
	
	@Column(length=1,nullable=false)
	private String activeFlag;
	
	public UserData() {
		super();
	}
	
	public UserData(Integer userId, String userName, String userPassword, String userEmail, String userPhone,
			byte[] userImage) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userImage = userImage;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userImage=" + Arrays.toString(userImage)
				+ "]";
	}
	
}

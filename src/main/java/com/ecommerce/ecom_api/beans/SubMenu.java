package com.ecommerce.ecom_api.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SubMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer submenuId;
	
	@Column
	private String submenuName;
	
	@Column
	private String submenuCreateDate;
	
	@Column
	private Integer menuId;
	
	@Column
	private Integer position;

	public SubMenu() {
		super();
	}

	public SubMenu(Integer submenuId, String submenuName, String submenuCreateDate, Integer menuId, Integer position) {
		super();
		this.submenuId = submenuId;
		this.submenuName = submenuName;
		this.submenuCreateDate = submenuCreateDate;
		this.menuId = menuId;
		this.position = position;
	}

	public Integer getSubmenuId() {
		return submenuId;
	}

	public void setSubmenuId(Integer submenuId) {
		this.submenuId = submenuId;
	}

	public String getSubmenuName() {
		return submenuName;
	}

	public void setSubmenuName(String submenuName) {
		this.submenuName = submenuName;
	}

	public String getSubmenuCreateDate() {
		return submenuCreateDate;
	}

	public void setSubmenuCreateDate(String submenuCreateDate) {
		this.submenuCreateDate = submenuCreateDate;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "SubMenu [submenuId=" + submenuId + ", submenuName=" + submenuName + ", submenuCreateDate="
				+ submenuCreateDate + ", menuId=" + menuId + ", position=" + position + "]";
	}

	
}

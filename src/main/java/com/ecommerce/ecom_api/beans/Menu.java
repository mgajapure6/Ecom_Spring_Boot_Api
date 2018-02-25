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
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;
	
	@Column
	private String menuName;
	
	@Column
	private String menuCreateDate;
	
	@Column
	private Boolean hasSubMenu;
	
	@Column
	private Integer moduleId;
	
	@Column
	private Integer position;

	public Menu() {
		super();
	}

	public Menu(Integer menuId, String menuName, String menuCreateDate, Boolean hasSubMenu, Integer moduleId,
			Integer position) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuCreateDate = menuCreateDate;
		this.hasSubMenu = hasSubMenu;
		this.moduleId = moduleId;
		this.position = position;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCreateDate() {
		return menuCreateDate;
	}

	public void setMenuCreateDate(String menuCreateDate) {
		this.menuCreateDate = menuCreateDate;
	}

	public Boolean getHasSubMenu() {
		return hasSubMenu;
	}

	public void setHasSubMenu(Boolean hasSubMenu) {
		this.hasSubMenu = hasSubMenu;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuCreateDate=" + menuCreateDate
				+ ", hasSubMenu=" + hasSubMenu + ", moduleId=" + moduleId + ", position=" + position + "]";
	}

	
}

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
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer moduleId;
	
	@Column
	private String moduleName;
	
	@Column
	private String moduleCreateDate;
	
	@Column
	private Boolean hasMenu;
	
	@Column
	private Integer position;

	public Module() {
		super();
	}

	public Module(Integer moduleId, String moduleName, String moduleCreateDate, Boolean hasMenu, Integer position) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleCreateDate = moduleCreateDate;
		this.hasMenu = hasMenu;
		this.position = position;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCreateDate() {
		return moduleCreateDate;
	}

	public void setModuleCreateDate(String moduleCreateDate) {
		this.moduleCreateDate = moduleCreateDate;
	}

	public Boolean getHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(Boolean hasMenu) {
		this.hasMenu = hasMenu;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleCreateDate=" + moduleCreateDate
				+ ", hasMenu=" + hasMenu + ", position=" + position + "]";
	}

}

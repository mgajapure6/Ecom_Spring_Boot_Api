package com.ecommerce.ecom_api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom_api.beans.SubMenu;

@Repository
public interface SubMenuRepository extends CrudRepository<SubMenu, Integer>{

	public List<SubMenu> findByMenuIdOrderByPositionAsc(Integer menuId);
}

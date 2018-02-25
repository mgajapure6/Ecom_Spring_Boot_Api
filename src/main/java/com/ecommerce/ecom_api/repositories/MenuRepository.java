package com.ecommerce.ecom_api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom_api.beans.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {

	public List<Menu> findByModuleIdOrderByPositionAsc(Integer moduleId);
}

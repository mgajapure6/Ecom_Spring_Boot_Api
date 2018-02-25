package com.ecommerce.ecom_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom_api.beans.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {

}

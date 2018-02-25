package com.ecommerce.ecom_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecom_api.beans.UserData;

public interface UserRepository extends CrudRepository<UserData, Integer> {
	
	UserData findByUserNameAndUserPassword(String userName, String userPassword);

}

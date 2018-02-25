package com.ecommerce.ecom_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom_api.beans.UserData;
import com.ecommerce.ecom_api.beans.WS_Response;
import com.ecommerce.ecom_api.repositories.UserRepository;

@RestController
@RequestMapping(value="/user_api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/findAllUser",method=RequestMethod.GET)
	public WS_Response getAllUser() {
		List<UserData> modules= (List<UserData>) userRepository.findAll();
		WS_Response response = new WS_Response();
		if(modules.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("User List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(modules);
			response.setMsg("User List Found");
		}
		return response;
	}
	
	@CrossOrigin//(origins = "http://localhost:4200")
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public WS_Response userLogin(@RequestBody UserData userData) {
		String username = userData.getUserName();
		String password = userData.getUserPassword();
		userData =  userRepository.findByUserNameAndUserPassword(username, password);
		System.out.println("userData :"+userData);
		WS_Response response = new WS_Response();
		if(userData == null) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("User Data Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(userData);
			response.setMsg("User Found");
		}
		return response;
	}


}

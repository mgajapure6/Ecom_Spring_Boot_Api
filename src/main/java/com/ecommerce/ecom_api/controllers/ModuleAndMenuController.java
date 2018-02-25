package com.ecommerce.ecom_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom_api.beans.Menu;
import com.ecommerce.ecom_api.beans.Module;
import com.ecommerce.ecom_api.beans.SubMenu;
import com.ecommerce.ecom_api.beans.WS_Response;
import com.ecommerce.ecom_api.repositories.MenuRepository;
import com.ecommerce.ecom_api.repositories.ModuleRepository;
import com.ecommerce.ecom_api.repositories.SubMenuRepository;

@RestController
@RequestMapping(value="/module_menu_api")
public class ModuleAndMenuController {
	
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private SubMenuRepository subMenuRepository;
	
	@RequestMapping(value="/saveModule",method=RequestMethod.POST)
	public WS_Response saveModule(@RequestBody Module module){
		module = moduleRepository.save(module);
		WS_Response response = new WS_Response();
		response.setStatus("success");
		response.setStatusCode(200);
		response.setObject(module);
		response.setMsg("Module Save Successfully");
		return response;
	} 
	
	@RequestMapping(value="/findAllModules",method=RequestMethod.GET)
	public WS_Response findAllModules(){
		List<Module> modules= (List<Module>) moduleRepository.findAll();
		WS_Response response = new WS_Response();
		if(modules.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("Module List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(modules);
			response.setMsg("Module List Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/findModulesByModuleId/{moduleId}",method=RequestMethod.GET)
	public WS_Response findModulesByModuleId(@PathVariable("moduleId") Integer moduleId){
		Module module= moduleRepository.findOne(moduleId);
		WS_Response response = new WS_Response();
		if(module==null) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("Module Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(module);
			response.setMsg("Module Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/saveMenu",method=RequestMethod.POST)
	public WS_Response saveMenu(@RequestBody Menu menu){
		Module module = moduleRepository.findOne(menu.getModuleId());
		module.setHasMenu(true);
		moduleRepository.save(module);
		menu = menuRepository.save(menu);
		WS_Response response = new WS_Response();
		response.setStatus("success");
		response.setStatusCode(200);
		response.setObject(menu);
		response.setMsg("Menu Save Successfully");
		return response;
	} 
	
	@RequestMapping(value="/findAllMenus",method=RequestMethod.GET)
	public WS_Response findAllMenus(){
		List<Menu> menus= (List<Menu>) menuRepository.findAll();
		WS_Response response = new WS_Response();
		if(menus.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("Menu List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(menus);
			response.setMsg("Menu List Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/findAllMenusByModuleId/{moduleId}",method=RequestMethod.GET)
	public WS_Response findAllMenusByModuleId(@PathVariable("moduleId") Integer moduleId){
		List<Menu> menus= (List<Menu>) menuRepository.findByModuleIdOrderByPositionAsc(moduleId);
		WS_Response response = new WS_Response();
		if(menus.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("Menu List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(menus);
			response.setMsg("Menu List Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/findMenuByMenuId/{menuId}",method=RequestMethod.GET)
	public WS_Response findMenusByMenuId(@PathVariable("menuId") Integer menuId){
		Menu menu= menuRepository.findOne(menuId);
		WS_Response response = new WS_Response();
		if(menu==null) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("Menu Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(menu);
			response.setMsg("Menu Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/saveSubMenu",method=RequestMethod.POST)
	public WS_Response saveSubMenu(@RequestBody SubMenu subMenu){
		Menu menu = menuRepository.findOne(subMenu.getMenuId());
		menu.setHasSubMenu(true);
		menuRepository.save(menu);
		subMenu = subMenuRepository.save(subMenu);
		WS_Response response = new WS_Response();
		response.setStatus("success");
		response.setStatusCode(200);
		response.setObject(subMenu);
		response.setMsg("SubMenu Save Successfully");
		return response;
	} 
	
	@RequestMapping(value="/findAllSubMenus",method=RequestMethod.GET)
	public WS_Response findAllSubMenus(){
		List<SubMenu> subMenus= (List<SubMenu>) subMenuRepository.findAll();
		WS_Response response = new WS_Response();
		if(subMenus.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("SubMenu List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(subMenus);
			response.setMsg("SubMenu List Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/findAllSubMenusByMenuId/{menuId}",method=RequestMethod.GET)
	public WS_Response findAllSubMenusByMenuId(@PathVariable("menuId") Integer menuId){
		List<SubMenu> subMenus= (List<SubMenu>) subMenuRepository.findByMenuIdOrderByPositionAsc(menuId);
		WS_Response response = new WS_Response();
		if(subMenus.size() <= 0) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("SubMenu List Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(subMenus);
			response.setMsg("SubMenu List Found");
		}
		return response;
	} 
	
	@RequestMapping(value="/findSubMenuBySubMenuId/{subMenuId}",method=RequestMethod.GET)
	public WS_Response findSubMenusBySubMenuId(@PathVariable("subMenuId") Integer subMenuId){
		SubMenu subMenu= subMenuRepository.findOne(subMenuId);
		WS_Response response = new WS_Response();
		if(subMenu==null) {
			response.setStatus("not found");
			response.setStatusCode(404);
			response.setObject(null);
			response.setMsg("SubMenu Not Found");
		}else {
			response.setStatus("success");
			response.setStatusCode(200);
			response.setObject(subMenu);
			response.setMsg("SubMenu Found");
		}
		return response;
	} 
	
	
	

}

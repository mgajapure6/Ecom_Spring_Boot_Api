package com.ecommerce.ecom_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ecommerce.ecom_api.beans.Menu;
import com.ecommerce.ecom_api.beans.Module;
import com.ecommerce.ecom_api.beans.SubMenu;
import com.ecommerce.ecom_api.repositories.MenuRepository;
import com.ecommerce.ecom_api.repositories.ModuleRepository;
import com.ecommerce.ecom_api.repositories.SubMenuRepository;

@ComponentScan({"com.ecommerce.ecom_api"})
@SpringBootApplication
public class EcommerceApiApplication implements CommandLineRunner {
	
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private SubMenuRepository subMenuRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		if(moduleRepository.count() < 1) {
			Module module2 = null;
			Module module3 = null;
			Module module4 = null;
			Menu menu6 = null;
			
			moduleRepository.save(new Module(1,"Dashboard","30-01-2018",false,1));
			module2 = moduleRepository.save(new Module(2,"Category","30-01-2018",true,2));
			module3 = moduleRepository.save(new Module(3,"Product","30-01-2018",true,3));
			module4 = moduleRepository.save(new Module(4,"Setting","30-01-2018",true,4));
			
			if(menuRepository.count() < 1) {
				menuRepository.save(new Menu(1, "Category Master", "30-01-2018", false, module2.getModuleId(), 1));
				menuRepository.save(new Menu(2, "Product Master", "30-01-2018", false, module3.getModuleId(), 1));
				menuRepository.save(new Menu(3, "Module Master", "30-01-2018", false, module4.getModuleId(), 1));
				menuRepository.save(new Menu(4, "Menu Master", "30-01-2018", false, module4.getModuleId(), 2));
				menuRepository.save(new Menu(5, "User Master", "30-01-2018", false, module4.getModuleId(), 3));
				menu6 = menuRepository.save(new Menu(6, "Other Settings", "30-01-2018", true, module4.getModuleId(), 4));
			}
			
			if(subMenuRepository.count() < 1) {
				subMenuRepository.save(new SubMenu(1, "font setting","30-01-2018",menu6.getMenuId(),1));
				subMenuRepository.save(new SubMenu(2, "theme color setting","30-01-2018",menu6.getMenuId(),2));
			}
		}
	}
}

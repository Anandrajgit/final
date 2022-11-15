package com.pab.Ecommerce.Controller;

import java.util.Optional;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pab.Ecommerce.BeanClass.Ebean;
import com.pab.Ecommerce.Repository.Erepository;

@Controller
public class Login {
 
	@Autowired
	private Erepository repo;
		
	@RequestMapping ("/register")
    public String insert(Ebean user) {
		repo.save(user);	
    	return"Register";
    }
	@RequestMapping ("/getUser")
    public String getUser(Model m) {
		
//		ModelAndView modelAndView=new ModelAndView("ShowUser.jsp");
//	
//		Ebean ebean=repo.findByUserName("bala").orElse(new Ebean());
//       		
//		modelAndView.addObject(ebean);
	 Optional<Ebean> bean = repo.findByUserName("bala");
	 		String rol=bean.get().getRoles();
	 m.addAttribute("anandraj",bean.get().getRoles());
		//m.addAttribute("anand", aLogin);
    	return "ShowUser";
    }
	
	
   
}
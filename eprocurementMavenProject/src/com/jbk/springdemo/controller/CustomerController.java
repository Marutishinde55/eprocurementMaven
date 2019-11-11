package com.jbk.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.springdemo.customerservice.CustomerService;
import com.jbk.springdemo.dao.CustomerDAO;
import com.jbk.springdemo.entity.Admin;
import com.jbk.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/login")
public String loginPage(Model model) {
		Customer thecustomer=new Customer();
		model.addAttribute("customer", thecustomer);
		return "login-page";
}
	@GetMapping("/forgotPassword")
	public String forgotPage() {
		return "forgotpage";
	}
	@GetMapping("/userPage")
	public String ProcessUserpage(@ModelAttribute("customer")Customer thecustomer) {
		boolean userexist=customerservice.checkuser(thecustomer.getUserName(),thecustomer.getPassword());
		if(userexist) {
			return "User-WelcomePage";
		}else {
			return "login-page";
		}
	}
	
	@GetMapping("/Admin")
	public String AdminLoginpage(Model model) {
			Admin theadmin=new Admin();
		model.addAttribute("admin", theadmin);
		return "AdminLogin";
	}
	
	
	
	
	@GetMapping("/AdminPage")
	public String listCustomers(@ModelAttribute("admin")Admin admin,Model model) {
		boolean AdminExist=customerservice.checkAdmin(admin.getUserName(),admin.getPassword());
		if(AdminExist) {
			List<Customer> thecustomers=customerservice.getCustomer();
			model.addAttribute("customers", thecustomers);
			return "list-Users";
		}else {
			return "AdminLogin";
		}
		
	}
	@GetMapping("/showformadd")
	public String customerform(Model model) {
		
		 Customer thecustomer=new Customer();
		  model.addAttribute("customer",thecustomer);
		 
		return "UserRegisteration";
		}
	@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer")Customer thecustomer) {
	
	customerservice.savecustomer(thecustomer);
	
	return "redirect:/customer/login";
}
	
	@GetMapping("/showformforupdate")
	public String showFormUpdate(@RequestParam("customerID")int theid,Model model) {
		Customer thecustomer=customerservice.getCustomers(theid);
		model.addAttribute("customer",thecustomer);
		return "UserRegisteration";
	}
	
	@GetMapping("/delete")
	public String deletecustomer(@RequestParam("customerID")int theid,Model model) {
		customerservice.delete(theid);
		List<Customer> thecustomers=customerservice.getCustomer();
		model.addAttribute("customers", thecustomers);
		return "list-Users";
	}
}



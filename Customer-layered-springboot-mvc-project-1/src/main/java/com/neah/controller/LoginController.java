package com.neah.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.neah.entity.Customer;
import com.neah.model.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("LoginPage", "customer" , new Customer());
	}
	
	@RequestMapping("/login")
	public ModelAndView loginController(@ModelAttribute("customer") Customer customer, HttpSession session) {
		ModelAndView modelView = new ModelAndView();
		
		if(loginService.loginCheck(customer)) {
			modelView.addObject("customer", customer); //request scope
			session.setAttribute("customer", customer); //data is set on session scope (avaibible in multiple request and response cycles)
			modelView.setViewName("index");
			//modelView.setViewName("LoginPage");
		}
		else {
			modelView.addObject("message", "Invalid User Credentials, Please try again");
			modelView.addObject("message", new Customer());
			modelView.setViewName("LoginPage");
		}
		
		return modelView;
	}
	
	@RequestMapping("/transferFunds")
	public ModelAndView transferFundsController(@RequestParam("accountId")int recepientAccountId,@RequestParam("amount") double balance,HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		
		int myAccountId=((Customer)session.getAttribute("customer")).getAccountId();
		Customer customer=loginService.transferFunds(myAccountId, recepientAccountId,balance );
		if(customer==null) {
			modelAndView.addObject("message", "Transaction Failed");
			session.setAttribute("customer", customer);
		}else
			modelAndView.addObject("message", "Your Account has been debited with balance "+balance+" and credited in Account No"+recepientAccountId+" and your current Balance is "+customer.getBalance());
		
		modelAndView.setViewName("Output");
		return modelAndView;
	}
	
} 
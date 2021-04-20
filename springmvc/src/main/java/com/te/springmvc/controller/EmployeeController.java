package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.dao.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao dao;

	@GetMapping("/emplogin")
	public String getLoginForm() {

		return "loginform";
	}
	
	

	@PostMapping("/loginform")
	public String authenticate(int id, String pwd, HttpServletRequest request, ModelMap modelMap) {
		
		EmployeeBean employeebean = dao.authentication(id, pwd);
		
		if (employeebean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeebean);
			return "header";

		} else {
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "loginform";
		}
	}

	@GetMapping("/search")
	public String getSearchForm(ModelMap modelMap, HttpSession session) {

		if (session.getAttribute("emp") != null) {
			return "searchform";
		} else {
			modelMap.addAttribute("errMsg", "please login first");
			return "loginform";
		}
	}

	@GetMapping("/searchs")
	public String getSearchEmp(int id, ModelMap modelMap,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean employeeBean2 = dao.getEmployee(id);
			if (employeeBean2 != null) {
				modelMap.addAttribute("msg", "Data not found for id" + id);
			}
			return "searchform";
		} else {
			modelMap.addAttribute("errMsg", "please login first");
			return "loginform";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "Login Successful");
		return "emplogin";

	}

}

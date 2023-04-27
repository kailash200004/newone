package com.jci.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.service.UserRegistrationService;

@Controller
public class LoginController {

	public static String dpcCode;

	@Autowired
	UserRegistrationService userRegService;

	@RequestMapping("index")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("index");
	
		return mv;
	}

	@RequestMapping("login")
	public ModelAndView loginDetails(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	/*
	 * @RequestMapping("dashboard") public ModelAndView dashboard(HttpServletRequest
	 * request){ System.out.println("dashboard"); ModelAndView mv = new
	 * ModelAndView("dashboard"); return mv; }
	 */

	@RequestMapping("loginAction")
	public ModelAndView loginDetailsCheck(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){
		ModelAndView mv = new ModelAndView("index");
		try {
			String usrname =  request.getParameter("email");
			String password = request.getParameter("password");
			String dpcId = request.getParameter("dpcId");
			String ifExist =  userRegService.checkLogin(usrname, password);
			int userId = userRegService.getUserId(usrname);
			int roleId = userRegService.getUserRoleId(userId);
			int refId = userRegService.getRefId(usrname);
			String dpcIdd = userRegService.getUserDpc(userId);
			String region = userRegService.getUserRegion(userId);
			String dpc_center = userRegService.getdpc_center(dpcIdd);
			session.setAttribute("userId", userId);
			session.setAttribute("usrname", usrname);
			session.setAttribute("dpcId", dpcIdd);
			session.setAttribute("region", region);
			session.setAttribute("zone", dpcId);
			session.setAttribute("roleId", roleId);
			session.setAttribute("refId", refId);
			session.setAttribute("dpc_center", dpc_center);
			/*
			 * if(ifExist!=null && !ifExist.equalsIgnoreCase("mobile")) return new
			 * ModelAndView("dashboard"); //return new ModelAndView((View)new
			 * RedirectView("dashboard.obj")); else if(ifExist.equalsIgnoreCase("mobile")) {
			 * mv.addObject("msg",
			 * "<div class=\"alert alert-danger\"><b>Failure !</b>Mobile User Can not Login Here.</div> \r\n"
			 * );
			 * 
			 * } else if(ifExist.equalsIgnoreCase("null")) {
			 * System.out.println("ifExist=====   "+ifExist); mv.addObject("msg",
			 * "<div class=\"alert alert-danger\"><b>Failure !</b>Please Enter correct username and password.</div> \r\n"
			 * ); }
			 */

			if(ifExist!=null)
				return new ModelAndView("dashboard");
			else
			{
				mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b>Please Enter correct username and password.</div> \r\n");
			}

		}catch(Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
}

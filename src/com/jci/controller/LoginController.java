package com.jci.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping("loginAction")
	public ModelAndView loginDetailsCheck(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){
		ModelAndView mv = new ModelAndView("index");
		try {
			String usrname =  request.getParameter("email");
			String password = request.getParameter("password");
			String dpcId = request.getParameter("dpcId");


			String ifExist =  userRegService.checkLogin(usrname, password);
			int userId = userRegService.getUserId(usrname);
			int refId = userRegService.getRefId(usrname);
			String dpcIdd = userRegService.getUserDpc(userId);
			String region = userRegService.getUserRegion(userId);
			String dpc_center = userRegService.getdpc_center(dpcIdd);
	///	System.out.println("userId==============>>>>>>>>>>>>>>>>> "+userId);
		//	int dpcId = userRegService.getUserDpc(userId);
			// System.out.println("userId "+userId+" dpcId "+dpcId+" region "+ region);
			session.setAttribute("userId", userId);
			session.setAttribute("usrname", usrname);
			session.setAttribute("dpcId", dpcIdd);
		//	request.getSession().setAttribute("DPCID", dpcIdd);
			session.setAttribute("region", region);
		//	session.setAttribute("dpcId", dpcId);
			session.setAttribute("zone", dpcId);
			session.setAttribute("refId", refId);
			session.setAttribute("dpc_center", dpc_center);
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

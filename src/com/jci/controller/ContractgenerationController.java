package com.jci.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.model.Contractgeneration;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.JbaModel;
import com.jci.service.ContractgenerationService;

@Controller
public class ContractgenerationController {

	@Autowired
	ContractgenerationService contractgenerationService;

	@RequestMapping("contractgeneration")
	public ModelAndView contractgeneration(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("contractgeneration");
		return mv;
	}

	@RequestMapping("savecontractgeneration")
	public ModelAndView saveEDC(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		try {
			Contractgeneration contractgeneration = new Contractgeneration();
			String contract_number = request.getParameter("contract_number");
			String contract_date = request.getParameter("contract_date");
			String full_contactnumber = request.getParameter("full_contactnumber");
			String crop_year = request.getParameter("crop_year");
			String variety_gradewisequantity = request.getParameter("variety_gradewisequantity");
			String delibry_type = request.getParameter("delibry_type");

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + crop_year + "" + delibry_type + ""
					+ variety_gradewisequantity + "" + delibry_type);
			Date currentdate = new Date();
           
              
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
        
            String formattedDate = df.format(currentdate);
            
               String date1=contractgeneration.setCreated_date(formattedDate);

			contractgeneration.setContract_number(contract_number);
			contractgeneration.setContract_date(contract_date);
			contractgeneration.setFull_contactnumber(full_contactnumber);
			contractgeneration.setCrop_year(crop_year);
			contractgeneration.setVariety_gradewisequantity(variety_gradewisequantity);
			contractgeneration.setDelibry_type(delibry_type);

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + contractgeneration);
			this.contractgenerationService.create(contractgeneration);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("contractgeneration.obj"));
	}

	@RequestMapping("viewcontractgeneration")
	public ModelAndView viewFarmerList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("contractgenerationlist");
		List<Contractgeneration> contractgeneration = contractgenerationService.getAll();
		mv.addObject("contractgenerationlist", contractgeneration);
		return mv;
	}

	@RequestMapping("contractgenerationDelete")
	public ModelAndView contractgenerationDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		int contract_id = Integer.parseInt(request.getParameter("contract_id"));
		this.contractgenerationService.delete(contract_id);

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("viewcontractgeneration.obj"));
	}
	
	@RequestMapping(value = { "editcontractgeneration" }, method = { RequestMethod.GET })
	public ModelAndView editcontractgeneration(final HttpServletRequest request) {
		
		final ModelAndView mv = new ModelAndView("editcontractgeneration");
		if (request.getParameter("contract_id") != null) {
			final int contract_id = Integer.parseInt(request.getParameter("contract_id"));
			final Contractgeneration contractgeneration = this.contractgenerationService.find(contract_id);
			mv.addObject("contractgeneration", contractgeneration);
		}
		return mv;
	}
	@RequestMapping("updatecontractgeneration")
	public ModelAndView updatecontractgeneration(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		try {
			int contract_id = Integer.parseInt(request.getParameter("contract_id"));
			Contractgeneration contractgeneration = this.contractgenerationService.find(contract_id);
			String contract_number = request.getParameter("contract_number");
			String contract_date = request.getParameter("contract_date");
			String full_contactnumber = request.getParameter("full_contactnumber");
			String crop_year = request.getParameter("crop_year");
			String variety_gradewisequantity = request.getParameter("variety_gradewisequantity");
			String delibry_type = request.getParameter("delibry_type");

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + crop_year + "" + delibry_type + ""
					+ variety_gradewisequantity + "" + delibry_type);

			contractgeneration.setContract_number(contract_number);
			contractgeneration.setContract_date(contract_date);
			contractgeneration.setFull_contactnumber(full_contactnumber);
			contractgeneration.setCrop_year(crop_year);
			contractgeneration.setVariety_gradewisequantity(variety_gradewisequantity);
			contractgeneration.setDelibry_type(delibry_type);

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + contractgeneration);
			this.contractgenerationService.update(contractgeneration);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("editcontractgeneration.obj"));
	}

}

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
import com.jci.model.ContractgenerationMillWise;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.JbaModel;
import com.jci.service.ContractgenerationMillWiseService;
import com.jci.service.ContractgenerationService;
import com.jci.service.PCSOServices;

@Controller
public class ContractgenerationController {

	@Autowired
	ContractgenerationService contractgenerationService;
	
	@Autowired
	ContractgenerationMillWiseService contractgenerationMillWiseService;
	
	@Autowired
	PCSOServices pcsoService;

	@RequestMapping("contractgenerationPCSOWise")
	public ModelAndView contractgeneration(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("contractgeneration");
		return mv;
	}

	@RequestMapping("savecontractgenerationMillWise")
	public ModelAndView saveEDC(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		try {
			ContractgenerationMillWise contractgenerationMill = new ContractgenerationMillWise();
			String fullcontractNo= request.getParameter("fullcontractNo");
			String contract_Qty=request.getParameter("contract_Qty");
			String delivery_type=request.getParameter("delivery_type");
			/*
			 * String contract_date=request.getParameter("contract_date"); String
			 * crop_year=request.getParameter("crop_year");
			 */
			String grade1= request.getParameter("grade1");
			String grade2= request.getParameter("grade2");
			String grade3= request.getParameter("grade3");
			String grade4= request.getParameter("grade4");
			String grade5= request.getParameter("grade5");
			String grade6= request.getParameter("grade6");
			String grade7= request.getParameter("grade7");
			String grade8= request.getParameter("grade8");
			String grade9= request.getParameter("grade9");
			
			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
			contractgenerationMill.setFull_contract_no(fullcontractNo);
			contractgenerationMill.setContract_qty(contract_Qty);
			contractgenerationMill.setDelivery_type(delivery_type);
			if(!grade1.isEmpty())
			contractgenerationMill.setGrade1_TD1(Double.parseDouble(grade1));
			if(!grade2.isEmpty())
			contractgenerationMill.setGrade2_TD2_W1(Double.parseDouble(grade2));
			if(!grade3.isEmpty())
				contractgenerationMill.setGrade3_TD3_W2_M1_B1(Double.parseDouble(grade3));
			if(!grade4.isEmpty())
				contractgenerationMill.setGrade4_TD4_W3_M2_B2(Double.parseDouble(grade4));
			if(!grade5.isEmpty())
				contractgenerationMill.setGrade5_TD5_W4_M3_B3(Double.parseDouble(grade5));
			if(!grade6.isEmpty())
				contractgenerationMill.setGrade6_TD6_W5_M4_B4(Double.parseDouble(grade6));
			if(!grade7.isEmpty())
				contractgenerationMill.setGrade7_TD7_W6_M5_B5(Double.parseDouble(grade7));
			if(!grade8.isEmpty())
				contractgenerationMill.setGrade8_TD8_W7_M6_B6(Double.parseDouble(grade8));
			if(!grade9.isEmpty())
				contractgenerationMill.setGrade8_W8(Double.parseDouble(grade9));
		    Date currentdate = new Date();
            String formattedDate = df.format(currentdate);
            contractgenerationMill.setCreated_date(formattedDate);

			this.contractgenerationMillWiseService.create(contractgenerationMill);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("contractgenerationPCSOWise.obj"));
	}
	@RequestMapping("contractgenerationMillWise")
	public ModelAndView contractgenerationMillWise(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("contractGenerationMillWise");
		return mv;
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
	/*
	 * @RequestMapping("updatecontractgeneration") public ModelAndView
	 * updatecontractgeneration(HttpServletRequest request, RedirectAttributes
	 * redirectAttributes) {
	 * 
	 * try { int contract_id =
	 * Integer.parseInt(request.getParameter("contract_id")); Contractgeneration
	 * contractgeneration = this.contractgenerationService.find(contract_id); String
	 * contract_number = request.getParameter("contract_number"); String
	 * contract_date = request.getParameter("contract_date"); String
	 * full_contactnumber = request.getParameter("full_contactnumber"); String
	 * crop_year = request.getParameter("crop_year"); String
	 * variety_gradewisequantity =
	 * request.getParameter("variety_gradewisequantity"); String delibry_type =
	 * request.getParameter("delibry_type");
	 * 
	 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + crop_year + "" + delibry_type
	 * + "" + variety_gradewisequantity + "" + delibry_type);
	 * 
	 * contractgeneration.setContract_number(contract_number);
	 * contractgeneration.setContract_date(contract_date);
	 * contractgeneration.setFull_contactnumber(full_contactnumber);
	 * contractgeneration.setCrop_year(crop_year);
	 * contractgeneration.setVariety_gradewisequantity(variety_gradewisequantity);
	 * contractgeneration.setDelibry_type(delibry_type);
	 * 
	 * System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + contractgeneration);
	 * this.contractgenerationService.update(contractgeneration);
	 * 
	 * redirectAttributes.addFlashAttribute("msg",
	 * "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
	 * + ""); } catch (Exception e) { System.out.println(e); } return new
	 * ModelAndView(new RedirectView("editcontractgeneration.obj")); }
	 */

}

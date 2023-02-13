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

import com.jci.model.Contractgenerationcommercial;
import com.jci.service.ContractgenerationcommercialService;

@Controller
public class ContractgenerationcommercialController {
	
	@Autowired
	ContractgenerationcommercialService contractgenerationcommercialService;

	@RequestMapping("contractgenerationcommercial")
	public ModelAndView contractgeneration(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("contractgenerationcommercial");
		return mv;
	}

	@RequestMapping("savecontractgenerationcommercial")
	public ModelAndView saveSGC(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		try {
			Contractgenerationcommercial contractgenerationcommercial = new Contractgenerationcommercial();

			String contracttype = request.getParameter("contracttype");
			String contract_num = request.getParameter("contract_num");
			String contract_date = request.getParameter("contract_date");
			String fullPcontactnum = request.getParameter("fullPcontactnum");
			String crop_year = request.getParameter("crop_year");
			String variety_grade_wise_quantity = request.getParameter("variety_grade_wise_quantity");
			String delibrytype = request.getParameter("delibrytype");
			String variety_grade_Wise_sale_price = request.getParameter("variety_grade_Wise_sale_price");
			String locationRegion = request.getParameter("locationRegion");
			
			Date currentdate = new Date();
	          SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
	          
	            String formattedDate = df.format(currentdate);
	            
	               String date1=contractgenerationcommercial.setCreated_date(formattedDate);

			contractgenerationcommercial.setContracttype(contracttype);
			contractgenerationcommercial.setContract_num(contract_num);
			contractgenerationcommercial.setContract_date(contract_date);
			contractgenerationcommercial.setFullPcontactnum(fullPcontactnum);
			contractgenerationcommercial.setCrop_year(crop_year);
			contractgenerationcommercial.setVariety_grade_wise_quantity(variety_grade_wise_quantity);
			contractgenerationcommercial.setDelibrytype(delibrytype);
			contractgenerationcommercial.setVariety_grade_Wise_sale_price(variety_grade_Wise_sale_price);
			contractgenerationcommercial.setLocationRegion(locationRegion);
			this.contractgenerationcommercialService.create(contractgenerationcommercial);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("contractgenerationcommercial.obj"));
	}

	@RequestMapping("viewcontractgenerationcommercial")
	public ModelAndView viewFarmerList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewcontractgenerationcommercial");
		List<Contractgenerationcommercial> contractgenerationcommercial = contractgenerationcommercialService.getAll();
		mv.addObject("contractgenerationcommerciallist", contractgenerationcommercial);
		return mv;
	}

	@RequestMapping("contractgenerationcommercialDelete")
	public ModelAndView contractgenerationcommercialDelete(HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws ParseException {
		int cgc_id = Integer.parseInt(request.getParameter("cgc_id"));
		this.contractgenerationcommercialService.delete(cgc_id);

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("viewcontractgeneration.obj"));
	}

	@RequestMapping(value = { "editcontractgenerationcommercial" }, method = { RequestMethod.GET })
	public ModelAndView editcontractgenerationcommercial(HttpServletRequest request) {

		final ModelAndView mv = new ModelAndView("editcontractgenerationcommercial");
		if (request.getParameter("cgc_id") != null) {
			final int cgc_id = Integer.parseInt(request.getParameter("cgc_id"));
			final Contractgenerationcommercial contractgenerationc = this.contractgenerationcommercialService
					.findById(cgc_id);
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>contractgenerationc>>>>>"+contractgenerationc);
			mv.addObject("contractgenerationc", contractgenerationc);
		}
		return mv;

	}

	@RequestMapping(value = {"updatecontractgenerationcommercial123"}, method = { RequestMethod.POST })
	public ModelAndView updateContractGenerationCommercial(HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		try {
			int cgc_id = Integer.parseInt(request.getParameter("cgc_id"));
			System.out.println(">>>>>>>>>>>>>>>cgc_id>>>>" + cgc_id);
			
			String contracttype = request.getParameter("contracttype");
			String contract_num = request.getParameter("contract_num");
			String contract_date = request.getParameter("contract_date");
			String fullPcontactnum = request.getParameter("fullPcontactnum");
			String crop_year = request.getParameter("crop_year");
			String variety_grade_wise_quantity = request.getParameter("variety_grade_wise_quantity");
			String delibrytype = request.getParameter("delibrytype");
			String variety_grade_Wise_sale_price = request.getParameter("variety_grade_Wise_sale_price");
			String locationRegion = request.getParameter("locationRegion");
			Contractgenerationcommercial contractgenerationcommercial = this.contractgenerationcommercialService.findById(cgc_id);
			contractgenerationcommercial.setContracttype(contracttype);
			contractgenerationcommercial.setContract_num(contract_num);
			contractgenerationcommercial.setContract_date(contract_date);
			contractgenerationcommercial.setFullPcontactnum(fullPcontactnum);
			contractgenerationcommercial.setCrop_year(crop_year);
			contractgenerationcommercial.setVariety_grade_wise_quantity(variety_grade_wise_quantity);
			contractgenerationcommercial.setDelibrytype(delibrytype);
			contractgenerationcommercial.setVariety_grade_Wise_sale_price(variety_grade_Wise_sale_price);
			contractgenerationcommercial.setLocationRegion(locationRegion);

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + contractgenerationcommercial);

			this.contractgenerationcommercialService.update(contractgenerationcommercial);

			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("viewcontractgenerationcommercial.obj"));
	}

}

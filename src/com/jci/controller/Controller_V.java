package com.jci.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;
import com.jci.service_phase2.PcsoentryService;

@Controller
public class Controller_V {

	@Autowired
	PcsoentryService pcsoentryservice;
	
	
	  @RequestMapping("entryofpcso")
	    public ModelAndView EntryofpcsoModel(HttpServletRequest request) {
		  System.out.println();
		  String username =(String)request.getSession().getAttribute("usrname");
	          ModelAndView mv = new ModelAndView("entryofpcso");
	          final List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>)this.pcsoentryservice.getAlldata();
	          mv.addObject("entryofpcsolist", (Object)allentryofpcsolist);
	          if(username == null) {
			     	mv = new ModelAndView("index");
			         }
	          return mv;
	    }
	  
	  
	  @RequestMapping("entryofpcsosave")
	    public ModelAndView saveUserMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	         ModelAndView mv= new ModelAndView("entryofpcsosave");
	         String username =(String)request.getSession().getAttribute("usrname");
	          try {
	            	List<EntryofpcsoModel> ll = new ArrayList<>();
	                int c = 0;
	                int count = Integer.valueOf(request.getParameter("count"));	                
	               String referenceno = request.getParameter("referenceno");
	               String referencedate = request.getParameter("referencedate");
	               String pcsodate = request.getParameter("pcsodate");
	               for(int i = 0; i<count; i++)
	                {
	               EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
	               String millcode = request.getParameter("millcode"+c);
	               String millname = request.getParameter("millname"+c);
	               String tallocation = request.getParameter("totalallocation"+c);
	               entryofpcso.setReference_no(referenceno);
	               entryofpcso.setReference_date(referencedate);
	               entryofpcso.setPcso_date(pcsodate);
	               		if(tallocation != "" && tallocation != null )
	                       {
	                              entryofpcso.setMill_code(millcode);
	                              entryofpcso.setMill_name(millname);
	                              entryofpcso.setTotal_allocation(tallocation);	                            	                           
	                              ll.add(entryofpcso);
	                       }
	                       c++;
	                }
	               mv.addObject("entryofpcso", (Object)ll);
	               mv.addObject("referencedate", (Object)referencedate);
	               mv.addObject("pcsodate", (Object)pcsodate);

	          } catch (Exception e) {
	               System.out.println(e);
	          }
	          if(username == null) {
			     	mv = new ModelAndView("index");
			         }
	          return mv;
	    }

	  
	  @RequestMapping("saveentryofpcsodata")
	    public ModelAndView entryofpcsosave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		  String username =(String)request.getSession().getAttribute("usrname");
        try {
      	
      	   int c = 0;
      	   int count = Integer.valueOf(request.getParameter("count"));
      	   Date date = new Date();
             String referenceno = request.getParameter("refno");
             String referencedate = request.getParameter("refdate");
             String pcsodate = request.getParameter("pcsodate");
             double sumoftotalallocation = Double.parseDouble(request.getParameter("sumoftotalallocation"));
             for(int i = 0; i<count; i++)
      	   {
          	   EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
      		   String millcode = request.getParameter("millcode"+c);
      		   String millname = request.getParameter("millname"+c);
      		   String tallocation = request.getParameter("totalallocation"+c);
      		   entryofpcso.setReference_no(referenceno);
                 SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                // Date refdate = formatter1.parse(referencedate);
                 entryofpcso.setReference_date(referencedate);
                // Date pcsodt = formatter1.parse(pcsodate);
                 entryofpcso.setPcso_date(pcsodate);
                 String createddate = formatter1.format(date);
                 entryofpcso.setCreated_date(createddate);
      		   entryofpcso.setMill_code(millcode);
      		   entryofpcso.setMill_name(millname);
      		   entryofpcso.setTotal_allocation(tallocation);
      		   entryofpcso.setMillwise_contract(0);
      		   entryofpcso.setPcsowise_contract(0);
      		   entryofpcso.setSumof_totalallocation(sumoftotalallocation);
      		   pcsoentryservice.create(entryofpcso);
      		   c++;
      	   }
				  redirectAttributes.addFlashAttribute("msg",
				  "<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n"
				  + "");
				 
             }
        catch (Exception e)
        {
             System.out.println(e);
             e.printStackTrace();
        }
        if(username == null) {
		     	return new ModelAndView("index");
		         }
        return new ModelAndView(new RedirectView("entryofpcso.obj"));
  }

	  
	  @RequestMapping("pcsolist") 
	  public ModelAndView pcsolist(HttpServletRequest request) { 
		  String username =(String)request.getSession().getAttribute("usrname");
		  ModelAndView mv = new ModelAndView("PCSO_List");
	  List<Date> pcso = pcsoentryservice.getAll(); 
	  mv.addObject("pcsolist",pcso); 
	  if(username == null) {
	     	mv = new ModelAndView("index");
	         }
	  return mv; 
	  }
	 
	  @RequestMapping("contractgenerationPCSOWise")
		public ModelAndView contractgeneration(HttpServletRequest req) {
			  String username =(String)req.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("contractgeneration");
			List<Date> pcso= pcsoentryservice.getAll(); 
			mv.addObject("pcso", (Object)pcso);
			 if(username == null) {
	         	mv = new ModelAndView("index");
	             }
			return mv;
		}
	  @ResponseBody
		 @RequestMapping(value = "pcsoDates" , method =  RequestMethod.GET )
	     public List<Date> pcsoDates(final HttpServletRequest request){
			 List<Date> pcso= pcsoentryservice.getAll(); 
			 return pcso;
		 }
	  
	  @ResponseBody
		 @RequestMapping(value = "pcso_details" , method =  RequestMethod.GET )
	     public String pcso_details(final HttpServletRequest request){
			  
			 String outerArray = request.getParameter("pcso1");
			 outerArray = outerArray.replaceAll("/", "'").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
			final String[] bpArr = outerArray.split(",");
				final List<String> list = Arrays.asList(bpArr);
			 List<PcsoDateModel> pcso= pcsoentryservice.pcso_details(outerArray);
			Gson gson= new Gson();
			 return gson.toJson(pcso);
		 }
		 
}

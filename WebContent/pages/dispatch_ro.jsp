<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.sf.jasperreports.engine.util.Java14BigDecimalHandler"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<!DOCTYPE html>
<html lang="en">
<script
       src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
       
</script>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
       rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
       rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
       rel="stylesheet" />
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
       src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
       href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
       src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
       src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
       src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
       src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
  <link rel="stylesheet" href="assets/css/chosen.css">
  <link rel="stylesheet" href="assets/css/docsupport/style.css">
  <link rel="stylesheet" href="assets/css/docsupport/prism.css">


  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


  
<style>
.required:after {
       content: " *";
       color: red;
}

  input[type="radio"]{
    display: inline;
}
</style>

</head>
<body class="fixed-navbar" onload="myFunction()">
       <div class="page-wrapper">
              <!-- START HEADER-->
              <%@ include file="header.jsp"%>
              <!-- END HEADER-->
              <!-- START SIDEBAR-->
              <%@ include file="sidebar.jsp"%>
              <!-- END SIDEBAR-->
              <div class="content-wrapper">
                     <!-- START PAGE CONTENT-->
                     <div class="page-heading">
                           <h1 class="page-title">HO Dispatch Instruction</h1>
                     </div>

                     <%
                     // Author vishal
                     %>

                     <%
                     List<String> contractList = (List<String>) request.getAttribute("ContractList");
                     %>
                     <%
                     List<Object[]> roList = (List<Object[]>) request.getAttribute("ronameList");
                     %>
                     <div class="page-content fade-in-up">
                           <div class="row">
                                  <div class="col-md-11">
                                         <div class="ibox">
                                                <span>${msg}</span>
                                                <div class="ibox-body">
                                                       <form action="savehodispatch.obj" method="POST">
                                                              <div class="child-checkbox" id="disableform">
                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Full Contract No.</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="contractno" name="contractno"
                                                                                         class="text-danger"> </span> <select name="fullcontractno"
                                                                                         id="fullcontractno" class="form-control textbox" required>
                                                                                         <option value="" disabled selected>Select</option>
                                                                                         <%
                                                                                         for (String Contract : contractList) {
                                                                                         %>
                                                                                         <option value="<%=Contract%>" readonly><%=Contract%></option>
                                                                                         <%
                                                                                         }
                                                                                         %>
                                                                                  </select>
                                                                           </div>


                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Contract Date</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="cdate" name="cdate" class="text-danger">
                                                                                  </span> <input class="form-control" name="contractdate"
                                                                                         id="contractdate" type="text" readonly
                                                                                          placeholder="DD-MM-YYYY">
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Crop Year</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <input name="cropyear"
                                                                                         id="cropyear" class="form-control textbox" required
                                                                                         readonly placeholder="Crop Year">



                                                                           </div>
                                                                     </div>

                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Contract Quantity </label> <input
                                                                                         class="form-control textbox" name="contractquantity"
                                                                                         min="0" type="number" id="contractquantity"
                                                                                         placeholder="Contract Quantity" required readonly>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>FC Ref No. </label> <input
                                                                                         class="form-control textbox" name="fc" type="number"
                                                                                         id="fc" placeholder="FC Ref No." required readonly>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Allowed Quantity </label> <input
                                                                                         class="form-control textbox" name="qty" type="number"
                                                                                         id="qty" placeholder="Allowed Quantity" required readonly>
                                                                           </div>
                                                                           </div>

                                            <div class="row">
                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Regional Office </label> <span class="text-danger">*
                                                                                  </span>&nbsp;<select name="region"
                                                                                         id="region" class="form-control textbox" required>
                                                                                         <option value="" disabled selected>Select</option>
                                                                                         <%
                                                                                         for (Object[] ro : roList) {
                                                                                         %>
                                                                                         <option value="<%=(String)ro[1] %>"><%=(String)ro[0]%></option>
                                                                                         <%
                                                                                         }
                                                                                         %>
                                                                                  </select>
                                                                           

                                                                     </div>
                                                                     <div class="col-sm-4" id="dpc_div">
                                                                           <label id="dpclabel" class="required">DPC</label>
                                                                           &nbsp;&nbsp;&nbsp;
                                                                           <div class="form-control" id="dpc_div" ></div>


</div>
                                                                     </div>

                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Last Date of Shipment</label> <span
                                                                                         class="text-danger">* </span>&nbsp; <span id="lastdate"
                                                                                         name="lastdate" class="text-danger"> </span> <input
                                                                                         class="form-control" name="lastdateofshipment"
                                                                                         id="instdate" type="date"   required>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>DI no.</label> <input
                                                                                          class="form-control taxtbox" name="uniqueno" min="0"
                                                                                         type="number" placeholder="Unique No" required>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Date (DI Date)</label> <span class="text-danger">*
                                                                                  </span>&nbsp; <span id="DIdate" name="DIdate" class="text-danger">
                                                                                  </span> <input class="form-control" name="dateofdi" id="instdate"
                                                                                         type="date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>" >
                                                                           </div>

                                                                     </div>
                                                                     <div class="row">

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Jute Variety</label> <span class="text-danger">*
                                                                                  </span> <select name="jutevariety" id="jutevariety"
                                                                                         class="form-control" required>
                                                                                         <option value="0">Select</option>
                                                                                         <option value="Bimli">Bimli</option>
                                                                                         <option value="Mesta">Mesta</option>
                                                                                         <option value="Tossa">Tossa</option>
                                                                                         <option value="White">White</option>
                                                                                  </select>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label>Quantity</label> <input class="form-control taxtbox"
                                                                                         name="quantity" min="0" type="number"
                                                                                         placeholder="Quantity" required>
                                                                           </div>

                                                                           <div class="col-sm-4 form-group">
                                                                                  <label id="lblName"></label>
                                                                                  <div id="form2"></div>

                                                                           </div>


                                                                     </div>
                                                                     <div class="row">
                                                                           <div class="col-sm-12 form-group">
                                                                                  <input type="submit" value="Submit" class="btn btn-primary"
                                                                                         id="submit">
                                                                           </div>
                                                                     </div>
                                                              </div>
                                                       </form>
                                                </div>
                                         </div>
                                  </div>
                           </div>
                     </div>
                     <!-- END PAGE CONTENT-->
                     <%@ include file="footer.jsp"%>
              </div>
       </div>

       <div class="sidenav-backdrop backdrop"></div>
       <script>
              $(document).ready(function() {
                     $("#fullcontractno").on("change", function() {
                           var cont = $(this).val();
                           alert(cont);
                           $.ajax({
                                  type : "GET",
                                  url : "HoDispatch.obj",
                                  data : {
                                         "contract" : cont
                                  },
                                  success : function(data) {
                                         displayContr(data);
                                         alert(data);
                                  },
                                  error : function(err) {
                                         // Handle errors here
                                         console.error('AJAX request failed: ' + err);
                                  }

                           });

                     });
                     function displayContr(data) {
                           alert(data);
                           var d = jQuery.parseJSON(data);
                           console.log(d);
                           document.getElementById("contractdate").value = d[0];
                           document.getElementById("cropyear").value = d[1];
                           document.getElementById("contractquantity").value = d[2];
                           document.getElementById("fc").value = d[3];
                           document.getElementById("qty").value = d[4];
                           document.getElementById("instdate").setAttribute("max", d[5]);
                           console.log(d[5]);
                     }
                     $("#region").on("change", function() {
                           
                           var id = (this.value);
                           alert(id);
                           var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose DPC...' class='chosen-select'  multiple tabindex='2' id = 'centerordpc'>";
                           if(id!=null){
                                  $.ajax({
                                         type:"GET",
                                         url:"findDpc.obj",
                                         data:{"id":id},
                                         success:function(result){
                                                alert(result)
                                                  var data= jQuery.parseJSON(result);
                                                  
                                                  alert(data);
                                                              html += "";
                                                    for (var i = 0; i< data.length; i++){
                                                         
                                                        html += "<option value=" +data[i].split("-")[0]+">"+data[i].split("-")[1]+"</option>"
                                                 } 
                                                $("#dpc_div").html(html);
                                               $("#centerordpc").chosen();
                                         /*     $("#centerordpc").addClass("chosen-select"); */
                                               /*  $('#centerordpc option').prop('selected', true);  
                                                 $('#centerordpc').trigger('chosen:updated'); */
                                                                                 
                                         }                    
                                  });
                           }
              
                     });
              } );
       </script>

<script>
$("#region").on("change",function(){
       //alert("DI no.");
       var cp=$("#cropyear").val();
       var reg=(this.value);
       alert(cp +"----------------"+reg);
       $ajax({
              type:"GET",
              url:"countHo.obj",
              success:function(result){
                     
              }
       });
});
</script>



       <script>
              $("#jutevariety")
                           .on(
                                         "change",
                                         function() {
                                                //alert("variety");

                                                $("#form2").empty();
                                                var basis_no;
                                                basis_no = 2;
                                                var variety = (this.value);
                                                //alert("variety= "+variety+"  basis= "+basis_no);
                                                if (variety === '0') {
                                                       $("#lblName").empty();
                                                } else {
                                                       $
                                                                     .ajax({
                                                                           type : "GET",
                                                                           url : "findGradeOfMSP.obj",
                                                                           data : jQuery.param({
                                                                                  "variety" : variety,
                                                                                  "basis_no" : basis_no
                                                                           }),
                                                                           success : function(result) {
                                                                                  data = jQuery.parseJSON(result);
                                                                                  count = data.length;
                                                                                   //alert(count);
                                                                                  $('#lblName').text(
                                                                                                'Enter Grade Price');
                                                                                  for (i = 0; i < data.length; i++) {
                                                                                         $('<label/>').text(
                                                                                                       data[i] + " : ")
                                                                                                       .appendTo('#form2');
                                                                                         //$('<label/>').attr({text:data[i],  fontcolor:'red'}).appendTo('#form2');
                                                                                         // $('<br/>').appendTo('#form2');
                                                                                         $('<input/>')
                                                                                                       .attr(
                                                                                                                     {
                                                                                                                           type : 'text',
                                                                                                                           id : 'grade'
                                                                                                                                         + i,
                                                                                                                           name : 'gprice'
                                                                                                                                         + i,
                                                                                                                           type : 'number',
                                                                                                                           value : '0',
                                                                                                                           min : '0',
                                                                                                                           oninput : 'javascript: if (this.value.length > 6) this.value = this.value.slice(0, 6);'
                                                                                                                     })
                                                                                                       .appendTo('#form2');
                                                                                         $('<br/>').appendTo(
                                                                                                       '#form2');

                                                                                  }
                                                                           }

                                                                     });
                                                }

                                         });
       </script>
<script>

</script>
       <!-- END PAGA BACKDROPS-->
       <!-- CORE PLUGINS-->
       <script src="./assets/vendors/jquery/dist/jquery.min.js"
              type="text/javascript"></script>
       <script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
              type="text/javascript"></script>
       <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
              type="text/javascript"></script>
       <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
              type="text/javascript"></script>
       <script
              src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
              type="text/javascript"></script>
       <!-- PAGE LEVEL PLUGINS-->
       <!-- CORE SCRIPTS-->
       <script src="assets/js/app.min.js" type="text/javascript"></script>

       <!-- PAGE LEVEL SCRIPTS-->
</body>
<script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script>
    <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>

  <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</html>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@page import="java.util.Date"%>
<%@ page import="java.text.ParseException" %>



<head>
       <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
  
 <style>
.required:after {
	content: " *";
	color: red;
}
</style> 
</head>
<body class="fixed-navbar" onload="myFunction()">
  
            
           <%
    List<Object[]> getChallanlist = (List<Object[]>) request.getAttribute("getChallanlist");
           String billOfSupplyNo = (String) request.getAttribute("billOfSupplyNo");
           
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
           String serverCurrentDate = dateFormat.format(new Date());

%>
         
           
            
            
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="saveentryofGenrationbill.obj" method="POST" name ="myForm" enctype="multipart/form-data">
                           <div class="child-checkbox" id="disableform">
                                 <div class="row">
                                       <div class="col-sm-4 form-group">
	                                             <label>Challan No</label>
	                                              <span class="text-danger">* </span>&nbsp; <span id="Challan_No" name="Challan_No" class="text-danger"> </span>
	                                        	 <select name="Challan_No1" id="Challan_No1" class="form-control taxtbox" required>
	                                        		
													    <option value="">-Select-</option>
													    <%
													    for (Object[] row : getChallanlist) {
													       String field1 = (String)row[0];
													       String field2 = (String)row[1];
													    %>
												    <option value="<%= field1 %>"><%= field1 %></option>
												     
													      
                                              
        
													    <%
													    }
													    %> 
													</select>
	                                        		
	                                        
                                        </div>
                                         <div class="col-sm-4 form-group">
												<label>Challan Date</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Challan_Date" name="Challan_Date" class="text-danger"> </span>
												<input class="form-control" name="Challan_Date1" id="ChallanDate1"  value="" required  readonly="readonly">
										   </div>
										   
										  
                                         
		                                       
                                         <div class="col-sm-4 form-group">
												<label>Shipment Details</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Shipment_Details" name=Shipment_Details class="text-danger"> </span>
												<input class="form-control" name="Shipment_Details" id="Shipment_Details1"  placeholder="Shipment Details" required>
										</div> 
										
										
	                                     
                                 </div>
                                  
                                    
                                    <div class="row">
                                    
                                    
                                    
                                            <div class="col-sm-4 form-group">
	                                            <label>Shipment Value</label> 
	                                            <span class="text-danger">* </span>&nbsp; <span id="Shipment_Value " name="Shipment_Value " class="text-danger" > </span>
												 <input class="form-control taxtbox" name="Shipment_Value1" min="0" step="1" pattern="\d+"  placeholder="Shipment_Value" required oninput="calculateGST()">
	                                     </div>
	                                       
	                                    
	                                       <div class="col-sm-4 form-group">
	                                             <label>SGST Amt</label>
	                                             <input class="form-control taxtbox" name="SGST_Amt" id="SGST_Amt" min=0 step=0.01 placeholder="SGST_Amt"  readonly="readonly" >
	                                       </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label>CGST Amt</label>
	                                             <input class="form-control taxtbox" name="CGST_Amt" id="CGST_Amt" min=0 step=0.01 placeholder="CGST_Amt"  readonly="readonly" >
	                                       </div>
	                                       
	                                      
	                                     
                                     </div> 
                                       
                                   <div class="row">
                                   
	                                       
	                                       
	                                        <div class="col-sm-4 form-group">
	                                             <label>IGST Amt</label>
	                                             <input class="form-control taxtbox" name="IGST_Amt" min="0" step="0.01" pattern="[0-9]*"  id="IGST_Amt" placeholder="IGST_Amt" >
	                                       </div>
	                                        <div class="col-sm-4 form-group">
	                                             <label>TCS Amt</label>
	                                             <input class="form-control taxtbox" name="TCS_Amt" min="0" step="0.01" pattern="[0-9]*"id="TCS_Amt" placeholder="TCS_Amt"  >
	                                       </div>
	                                       
	                                      <div class="col-sm-4 form-group">
	                                             <label>TDS Amt</label>
	                                             <input class="form-control taxtbox" name="TDS_Amt"min="0" step="0.01" pattern="[0-9]*" id="TDS_Amt" placeholder="TDS_Amt"  >
	                                       </div>
                                   
                                        
	                                        
	                                     
	                                       
	                                      
	                                       
	                                     
	                                       
	                                       
                                    </div>  
                                     
                                        <div class="row">
                                        
                                         <div class="col-sm-4 form-group">
												<label>Bill of Supply No</label> 
												<input class="form-control" name="Bill_of_Supply" id="Bill_of_Supply" value="<%=billOfSupplyNo %>" placeholder="Bill_of_Supply"  readonly="readonly" >
										   </div>
										   <div class="col-sm-4 form-group">
	                                             <label>Invoice Value</label>
	                                             <input class="form-control taxtbox" name="Invoice_Value" id="Invoice_Value" min="0" step="0.01" pattern="[0-9]*"  placeholder="Invoice_Value"   readonly="readonly">
	                                       </div>
										   <div class="col-sm-4 form-group">
												<label>BOS Date</label> 
												<input class="form-control" name="BOS_Date" id="BOS_Date" value="<%= serverCurrentDate %>" placeholder="BOS_Date"    readonly="readonly">
										   </div>
                                   
                                            
	                                     
	                                      
	                                       
                                    </div>
                                       
                                        <div class="row">
                                        <div class="col-sm-4 form-group">
	                                             <label>Supplier Name</label>
	                                             <input class="form-control taxtbox" name="Supplier_Name" id="Supplier_Name" placeholder="Supplier_Name" 	>
	                                       </div>
                                        
                                         <div class="col-sm-4 form-group">
												<label>Supplier GSTN</label> 
												<input class="form-control" name="Supplier_GSTN" id="Supplier_GSTN" placeholder="Supplier_GSTN"  >
										   </div>
										   <div class="col-sm-4 form-group">
												<label>Supplier Address</label> 
												<input class="form-control" name="Supplier_Address" id="Supplier_Address" placeholder="Supplier_Address" >
										   </div>
                                   
                                            
	                                     
	                                      
	                                       
                                    </div>
                                       
                                        <div class="row">

											<div class="col-sm-4 form-group">
												<label>Recipient Name</label> <input
													class="form-control taxtbox" name="Recipient_Name"
													id="Recipient_Name" placeholder="Recipient_Name">
											</div>

											<div class="col-sm-4 form-group">
												<label>Recipient GSTN </label> <input class="form-control taxtbox"
													name="Recipient_GSTN" id="Recipient_GSTN"
													placeholder="Recipient_GSTN">
											</div>
											<div class="col-sm-4 form-group">
												<label>Recipient Address</label> <input class="form-control taxtbox"
													name="Recipient_Address" id="Recipient_Address"
													placeholder="Recipient_Address">

											</div>





										</div>
         
                                        <div class="row">
                                        
                                         <div class="col-sm-4 form-group">
	                                             <label>Consignee Name</label>
	                                             <input class="form-control taxtbox" name="Consignee_Name" id="Consignee_Name"  placeholder="Consignee_Name" 	>
	                                       </div>
                                        
                                         <div class="col-sm-4 form-group">
												<label>Consignee GSTN </label> 
												<input class="form-control taxtbox" name="Consignee_GSTN" id="Consignee_GSTN" placeholder="Consignee_GSTN" >
										   </div>
										   <div class="col-sm-4 form-group">
												<label>Consignee Address</label> 
												<input class="form-control taxtbox" name="Consignee_Address" id="Consignee_Address" placeholder="Consignee_Address"  >
										   </div>
                                   
                                          
	                                      
	                                       
                                    </div>
                                     <div class="row">
                                     <div class="col-sm-4 form-group">
												<label>Contarct no</label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contarct_no" name="Contarct_no" class="text-danger"> </span>
												<input class="form-control" name="Contarct_no" id="Contarctno"  value="" readonly="readonly">
										   </div>
										   <div class="col-sm-2 form-group" style="display: none;">
												<label "display: none;">Clientstate </label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contarct_no" name="Contarct_no" class="text-danger"> </span>
												<input  type="hidden" class="form-control" name="Clientstate" id="Clientstate"  value="" readonly="readonly">
										   </div>
										    <div class="col-sm-2 form-group" style="display: none;">
												<label "display: none;">Clientcode </label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contarct_no" name="Contarct_no" class="text-danger"> </span>
												<input  type="hidden" class="form-control" name="Clientcode" id="Clientcode"  value="" readonly="readonly">
										   </div>
										    <div class="col-sm-2 form-group" style="display: none;">
												<label "display: none;">ClientPan </label> 
												<span class="text-danger">* </span>&nbsp; <span id="Contarct_no" name="Contarct_no" class="text-danger"> </span>
												<input  type="hidden" class="form-control" name="ClientPan" id="ClientPan"  value="" readonly="readonly">
										   </div>
										   </div>
	                                     <div class="row"> 
                                                <div class="col-sm-1 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit" onclick="">
									            </div>
									         <!--   <div class="clear">
												  <button type="submit" value="submit" name="subscribe" id="mc-embedded-subscribe" class="submit- btn btn-default" onclick="window.open('https://login.mailchimp.com/signup'), window.location = 'https://google.com'">Submit</button>
											   </div>  -->
											<!--    <div class="col-sm-1 form-group">
									             <input type="cancel" value="cancel"class="btn btn-primary" id="cancel" onclick="">
									            </div> -->
											   
									          </div>
                                   </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    
    <div class="sidenav-backdrop backdrop"></div>
    
     <script type="text/javascript">
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		
			  var contractdate = $("#contractdate").val();
			  var instdate = $("#instdate").val();
			  var paymenttype = $("#paymenttype").val();
			  
			  if(contractdate =="" || instdate =="")
				  {
				    alert("Please select mandatory Fields!");
				  }
			  if(paymenttype =="letterofcredit")
				  {
					  var dateofship = $("#dateofship").val();
					  var dateofexpiry = $("#dateofexpiry").val();
					  if(dateofship =="" || dateofexpiry =="")
						  {
						    alert("Please select mandatory Fields!");
						  }
				  }
			  
		    });
	 });
		
	</script> 
	
	
    
  

  
    <script type="text/javascript">
    
    $(document).ready(function() {
    	
    	function formatDate(date) {
	        var day = date.getDate().toString().padStart(2, '0');
	        var month = (date.getMonth() + 1).toString().padStart(2, '0');
	        var year = date.getFullYear();
	        return day + '/' + month + '/' + year;
	    }
   	    $('#Challan_No1').on('change', function() {
   	    var field2Value = $(this).val();
   	   
   	      $.ajax({
   	            type: 'GET',
   	            url: 'fetchingdata1.obj',
   	            data: { "contractno": field2Value },
   	            success: function(data) {
   	            	alert(data);
   	           
   	           
   	        try {
   	            var dataArray = JSON.parse(data);

   	            if (dataArray && dataArray.length > 0) {
   	                var contractNo = dataArray[0][0];
   	                var creationDateStr = dataArray[0][1];
   	                var millcode = dataArray[0][2];
					 var creationDate = new Date(creationDateStr);
   	                console.log("Creation Date as Date object: ", creationDate);
   	                
   	                
   	                $('#Contarctno').val(contractNo);
   	                $('#ChallanDate1').val(formatDate(creationDate));
   	             $('#Millcode').val(millcode);
   	             
   	             
   	             
			   	          $.ajax({
			                  type: 'GET',
			                  url: 'fetchingdataforbill.obj',
			                  data: { "contractno": millcode },
			                  success: function(secondData) {
			                      alert(secondData);
			                      try { 
			                      var dataArray = JSON.parse(secondData);

			       	              if (dataArray && dataArray.length > 0) {
			       	                var unit_name = dataArray[0][1];
			       	                var unit_address1 = dataArray[0][2];
			       	                var unit_state = dataArray[0][3];
			       	                var unit_state_location = dataArray[0][4];
			       	                var client_gstin = dataArray[0][5];
			       	                var client_pan = dataArray[0][6];
			       	                var client_state = dataArray[0][7];
			       	                var client_address1 = dataArray[0][8];
			       	                var client_name = dataArray[0][9];
			       	                
			    					
			       	                
			       	                
			       	                $('#Recipient_Name').val(unit_name);
			       	                $('#Recipient_GSTN').val(client_gstin);
			       	                $('#Recipient_Address').val(unit_address1);
			       	                $('#Consignee_Name').val(client_name);
			       	                $('#Consignee_GSTN').val(client_gstin);
			       	                $('#Consignee_Address').val(client_address1);
			       	                $('#Clientstate').val(client_state);
			       	                $('#Clientcode').val(unit_state);
			       	                $('#ClientPan').val(client_pan);
			       	           }
			             	        } catch (error) {
			             	            console.error("Error parsing JSON: " + error);
			             	        }
			                      
			                      
			                  },
			                  error: function(error) {
			                      console.error('Second Ajax call error:', error);
			                  }
			              });
   	            }
   	        } catch (error) {
   	            console.error("Error parsing JSON: " + error);
   	        }
   	           
   	       var formattedDate = formatDate(ChallanDate1);
   	                 $('#Contarctno').val(data1.Contract_No);
   	                 $('#ChallanDate1').val(formattedDate);
   	             
   	                 
   	            }
   	             
   	        }); 
   	    });
   	});

         
         </script>
         
  
	      
         
         
         

 
         
         
  <script>
    function calculateGST() {
        // Retrieve the shipment value entered by the user
        var shipmentValue = parseFloat(document.getElementsByName("Shipment_Value1")[0].value);

        // Check if the entered value is a valid number
        if (!isNaN(shipmentValue)) {
            // Calculate SGST and CGST amounts (assuming 18% GST rate)
            var gstRate = 0.18;
            var sgstAmt = (gstRate / 2) * shipmentValue;
            var cgstAmt = (gstRate / 2) * shipmentValue;
            var totalGstAmt = sgstAmt + cgstAmt;
            var invoiceValue = shipmentValue + totalGstAmt;

            // Set the calculated amounts to the respective input fields
            document.getElementById("SGST_Amt").value = sgstAmt.toFixed(2);
            document.getElementById("CGST_Amt").value = cgstAmt.toFixed(2);
            document.getElementById("Invoice_Value").value = invoiceValue.toFixed(2);
        }
    }
</script>
     
     
    
  
    


  
		  
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>

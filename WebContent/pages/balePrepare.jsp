<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.List"%>
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
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL STYLES-->
    <style>
		.required:after {
			content: " *";
			color: red;
		}
	</style>
</head>

<body class="fixed-navbar">
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
                <h1 class="page-title">Bale Preparation</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                        <% 
                        	List<String> allDpcList = (List) request.getAttribute("allDpcList");
                        %>
                            <div class="ibox-body">
                            	<span>${msg}</span>
                                <form action="saveBale.obj" method="POST">
                                    <div class="row">
                                    	
                                   		<!-- <div class="col-sm-4 form-group">
											<label>Date of Packing</label> 
											<input class="form-control" type="Date" name="packing_date" placeholder="Packing Date" required>
										</div> -->
                                    	
                                      <%--  <div class="col-sm-4 form-group">
                                            <label>Place of Packing</label>
                                            <!-- <input class="form-control" type="text" name="dpcname" placeholder="Place of Packing" required> -->
                                             <select name="dpcname" id="dpcname" class="form-control">
                                            	<%
                                            		String[] str;
	                                            	for(int i=0; i<allDpcList.size() ; i++){
	                                            		str = allDpcList.get(i).split("-");
	                                            %>
	                                            <option value="<%=str[0]%>"><%=str[1]%></option>
	                                            <% 
	                                            	}
	                                            %>		
                                            </select> 
                                        </div> --%>
                                        
                                        
                                        <div class="col-sm-4 form-group">
  										
										<%-- <input class="form-control"  type="text" placeholder="Place of Purchase" value="<%=dpcCenter%>" onkeyup="deleteErrorMsg()" oninput="javascript: if (this.value.length > 4) this.value = this.value.slice(0, 4);" >
      									<input class="form-control" name="dpcid" id="dpcid" type="hidden" value="<%=dpcid%>" > --%>
     									                                       <div class="col-sm-4 form-group">
                                            <label class="required">DPC Name</label> 
											<select name="place_of_packing" id="place_of_packing" class="form-control">
												<option value="">-Select-</option>
												<%-- <option value="<%=dpcid%>"><%=dpcCenter%></option> --%>
											</select>
                                        </div>
     									
     									</div>
                                       <!-- <div class="col-sm-4 form-group">
                                            <label class="required">packing_date</label> 
											<select name="packing_date" id="packing_date" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
                                        </div> -->
                                         <div class="col-sm-4 form-group">
                                            <label class="required">Crop Year</label> 
											<select name="crop_year" id="crop_year" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
                                        </div>
                                      
                                       <div class="col-sm-4 form-group">
                                             <label class="required">Bin number</label>
                                        	 <input class="form-control" name="bin_no" id="binnumb" type="number" placeholder="Bin Number" required onkeyup="checkLen()" required>
                                        </div> 
                                        
                                        <div class="col-sm-4 form-group">
                                             <label class="required" >Basis</label>
                                        	 <select name="basis" id="basis" class="form-control" required>
                                        		<option value="">-Select-</option>
                                        		<option value="msp">MSP</option>
                                        		<option value="commercial">Commercial</option>
                                        	 </select>
                                        </div>
                                        
                                        <div class="col-sm-4 form-group">
											<label class="required">Jute Variety</label>
                                        	<select name="jute_variety" id="jute_variety" class="form-control" required>
                                        		
                                        	</select>
										</div> 
										
										<div class="col-sm-4 form-group">
											<label class="required">Jute Grade</label>
                                        	<select name="jute_grade" id="jute_grade" class="form-control" required>
                                        		
                                        	</select>
										</div>
										
										<div class="col-sm-4 form-group">
											<label class="required">Bale Check SlipNo.(From)</label>
                                        	<input class="form-control" name="slip_no_from" id="slip_no_from" type="number" placeholder="Bale Check SlipNo" required onkeyup="baleFromLen()" min="0">
										</div>
                                    </div>
                                     
                                    <div class="row">
										<!-- <div class="col-sm-4 form-group">
                                             <label>Jute Grade</label>
                                        	 <input class="form-control" name="jutegrade" type="text" placeholder="Jute Grade" required>
                                        </div>  -->
                                        
                                        <div class="col-sm-4 form-group">
											<label class="required">Bale Check SlipNo.(To)</label>
                                        	<input class="form-control" name="slip_no_to" id="slip_no_to" type="number" placeholder="Bale Check SlipNo" onblur="calculateNoOfBales()" min="0" required onkeyup="baleToLen()">
										</div>
										
										<div class="col-sm-4 form-group">
											<label class="required">Total Bales</label>
                                        	<input class="form-control" name="bale_no" id="bale_no" type="number" placeholder="Total bales" readonly required>
										</div>
                                    </div>
                                    
                                    <div class="row">
                                    	
                                    </div>
                                    
                                    <div  id="form2">
                                    	
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-default" type="submit">Submit</button>
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
	$(function(){
	    var dtToday = new Date();
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();
	    var maxDate = year + '-' + month + '-' + day;    
	    $('#datepurchase').attr('max', maxDate);
	});
		
	</script>
	<script>
	$("#basis").on("change", function() {
		var msp_no;
		var variety = (this.value);	
		if(variety=="msp"){
			msp_no = 2;
		}
		else if(variety=="commercial"){
			msp_no = 1;
		}
		$.ajax({
			type:"GET",
			url:"findJuteOnBasis.obj",
			data:{"msp_no":msp_no},
			success:function(result){
 				   var data= jQuery.parseJSON(result);
	 					 var html = "<option disabled selected value>-Select-</option>";
 				     for (var i = 0; i< data.length; i++){
 				    	 var sar = data[i]
 					 html += "<option value="+sar+">"+data[i]+"</option>"			
 				  } 
 				$("#jutevariety").html(html);
			}		
		});
	});
	</script>
	
<!-- 	<script>
	$("#jutevariety").on("change", function() {
		var basis_no;
		var grade;
		var count=0;
		var data;
		var basis = document.getElementById("basis").value;	
		if(basis=="commercial")
			basis_no=2;
		else if(basis=="msp")
			basis_no=1;
		 var variety = (this.value);
			 $.ajax({
				type:"GET",
				url:"findGradeOnJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
					// alert(data);
					count = data.length;
					$('#lblName').text('Enter Grade Details');
					 if(variety=='Bimli'){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}else if(variety=="Mesta"){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}
					 else{
						$('#form2 input ').remove();
						$('#form2 label').remove();
					} 
					
			        for (i=0;i<data.length;i++){
			        	$('<div class="form-group">').appendTo('#form2');
			        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
			        	// $('<br/>').appendTo('#form2');
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'grade'+i,value:'' }).appendTo('#form2');
	 				   $('</div>').appendTo('#form2');
	 				    //$('<br/>').appendTo('#form2');
			        }
	 			  } 		     
				});	
	});	
	</script>
 	-->	
	<script>
	$("#jutevariety").on("change", function() {
		var basis_no;
		var grade;
		var count=0;
		var data;
		var basis = document.getElementById("basis").value;	
		if(basis=="commercial")
			basis_no=2;
		else if(basis=="msp")
			basis_no=1;
		 var variety = (this.value);
			 $.ajax({
				type:"GET",
				url:"findGradeOnJuteVariety.obj",
				data: jQuery.param({ "variety": variety, "basis_no" : basis_no}) ,
				success:function(result){
					data = jQuery.parseJSON(result);
					var data= jQuery.parseJSON(result);
					
					
					var html = "<option disabled selected value>-Select-</option>";
			     	for (var i = 0; i< data.length; i++){
			    	 	var sar = data[i]
				 		html += "<option value="+sar+">"+data[i]+"</option>"			
			 	 	} 
					$("#jutegarde").html(html);
					
					
					
					// alert(data);
					/* count = data.length;
					$('#lblName').text('Enter Grade Details');
					 if(variety=='Bimli'){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}else if(variety=="Mesta"){
						$('#form2 input').remove();
						$('#form2 label').remove();
					}
					 else{
						$('#form2 input ').remove();
						$('#form2 label').remove();
					} 
					
			        for (i=0;i<data.length;i++){
			        	$('<div class="form-group">').appendTo('#form2');
			        	$('<label/>').text(data[i]+" : ").appendTo('#form2');
			        	// $('<br/>').appendTo('#form2');
	 				    $('<input/>').attr({ type: 'text', id: 'grade'+i, name: 'grade'+i,value:'' }).appendTo('#form2');
	 				   $('</div>').appendTo('#form2');
	 				    //$('<br/>').appendTo('#form2');
			        } */
	 			  } 		     
				});	
	});	
	</script>
	<script>
	function checkLen(){
		var binnumber = document.getElementById("binnumb").value;
		var max_chars = 3;
		// binnumber.value = binnumber.value.substr(0, max_chars);
		if(binnumber.toString().length == 3){
			// alert("hell");
			$("#binnumb").prop("type", "text");
			$("#binnumb").attr("maxlength", "3");
			$("#binnumb").attr("minlength", "1");
		}
	}
	</script>
	
	<script>
	function calculateNoOfBales(){
		var fromCheckSlipNo = document.getElementById("fromCheckSlipNo").value;	
		var toCheckSlipNo = document.getElementById("toCheckSlipNo").value;
		var noOfBales = (toCheckSlipNo - fromCheckSlipNo)+1;
		if(noOfBales >= 0){
			document.getElementById("noOfBales").value = noOfBales;
		}
		else
		{
			alert("No of bales can not be negative or 0");
			return false;
		}
	}
	
	function baleFromLen(){
		var binnumber = document.getElementById("fromCheckSlipNo").value;
		if(binnumber.toString().length == 6){
			$("#fromCheckSlipNo").prop("type", "text");
			$("#fromCheckSlipNo").attr("maxlength", "6");
			$("#fromCheckSlipNo").attr("minlength", "1");
		}
	}
	
	function baleToLen(){
		var binnumber = document.getElementById("toCheckSlipNo").value;
		if(binnumber.toString().length == 6){
			$("#toCheckSlipNo").prop("type", "text");
			$("#toCheckSlipNo").attr("maxlength", "6");
			$("#toCheckSlipNo").attr("minlength", "1");
		}
	}

	</script>
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
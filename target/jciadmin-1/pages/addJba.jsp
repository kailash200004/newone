<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.AreaDetailCode"%>
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
    <!-- PAGE LEVEL STYLES-->
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
                <h1 class="page-title">JBA Price</h1>
            </div>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                            
                            <div class="ibox-body">
                                <form action="saveJbaRate.obj" method="POST" >
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                           <!--  <label>JBA Date</label>
                                            <input class="form-control" type="date" name="datejba" placeholder="JaBA Date" required> -->
                                        
                                           <label>JBA Date</label>
<!-- <select class="form-control" name="datejba" id="datejba"
												onchange="deleteErrorMsg()">
												<option disabled selected value>-Select-</option>
												<option value="<%=(new java.util.Date()).toLocaleString()%>"><%= (new java.util.Date()).toLocaleString()%></option>
												 
												
											</select> -->
                                        <input readonly class="form-control" id="datejba" type=date name="datejba" placeholder="JaBA Date" required>
                                        </div>
                                        
                                        
                                        
                                    	<div class="col-sm-4 form-group">
											<label>Jute Variety</label>
                                        	<select name="jutevariety" id="jutevariety" class="form-control">
                                        		<option value="">-Select-</option>
                                        		<option value="tossa">Tossa</option>
                                        		<option value="white">White</option>
                                        	</select>
										</div>
										
										
									<!-- 	<div class="col-sm-4 form-group">
											<label>Area code</label>
                                        	<input type="text" name="areacode"  id="areacode" class="form-control">
                                        		
                                        	
										</div> -->
										
										<div class="col-sm-4 form-group">
											<label class="required">Area Code</label> &nbsp;&nbsp; <span
												id="errPin" name="errPin" class="text-danger"> </span>
											<%
												List<AreaDetailCode> AreaCode = (List<AreaDetailCode>) request.getAttribute("AreaCode");
											%>
											<select class="form-control" name="areacode" id="areacode"
												onchange="deleteErrorMsg()">
												<option disabled selected value>-Select-</option>
												<%
													for (AreaDetailCode areaLists : AreaCode) {
												%>
												<option value="<%=areaLists.getAreaName()%>"><%=areaLists.getAreaName()%></option>
												<%
													}
												%>
											</select>
										</div>
										  
								                              
										
                                   
                                       <div class="col-sm-4 form-group">
                                            <label>Crop Year</label> 
											<select name="cropyr" id="cropyr" class="form-control">
												<option value="">-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
											</select>
                                        </div>
                                      
                                      
                                    
                                    
                                    
                                   
                                
                                        <div class="col-sm-4 form-group" id ="tossadiv">
											<label> <p style="color:green"> Grade Wise Price For Tossa</p></label>
											
		
											<input class="form-control" type="text" name="gradewisepp1"  id ="gradewisepp1"/>
      <input class="form-control" type="text" name="gradewisepp2" id ="gradewisepp2" />
      <input class="form-control" type="text" name="gradewisepp3"  id ="gradewisepp3"/>
      <input class="form-control"  type="text" name="gradewisepp4" id ="gradewisepp4" />
      <input  class="form-control" type="text" name="gradewisepp5"  id ="gradewisepp5"/>
      <input  class="form-control" type="text" name="gradewisepp6"  id ="gradewisepp6"/>
      <input class="form-control" type="text" name="gradewisepp7"  id ="gradewisepp7"/>
      <input class="form-control" type="text" name="gradewisepp8"  id ="gradewisepp8"/>
          
										</div>
										
										
                                        <div class="col-sm-4 form-group" id ="whitediv">
											<label><p style="color:green"> Grade Wise Price For White</label>
											
											
      <input class="form-control" type="text" name="gradewisepp9"    id ="gradewisepp9"/>
      <input class="form-control" type="text" name="gradewisepp10"    id ="gradewisepp10"/>
      <input class="form-control"  type="text" name="gradewisepp11"  id ="gradewisepp11"/>
      <input  class="form-control" type="text" name="gradewisepp12"   id ="gradewisepp12"/>
      <input  class="form-control" type="text" name="gradewisepp13"   id ="gradewisepp13"/>
      <input class="form-control" type="text" name="gradewisepp14"   id ="gradewisepp14"/>
      <input class="form-control" type="text" name="gradewisepp15"   id ="gradewisepp15"/>
      <input class="form-control" type="text" name="gradewisepp16"   id ="gradewisepp16"/>
          
										</div>
										
										
										
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#whitediv").hide();
			$("#tossadiv").hide();
			var now = new Date();
			var day = ("0" + now.getDate()).slice(-2);
			var month = ("0" + (now.getMonth() + 1)).slice(-2);
			var today = now.getFullYear() + "-" + (month) + "-" + (day);
		//	$('#fromDt').val(today);
			//alert(today);
			$('#datejba').val(today);
			 
		});

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
		
	$('#jutevariety').change(function () {
			 var selectedText = $(this).find("option:selected").text();
	            var selectedValue = $(this).val();
	            console.log(" Value:" + selectedValue);
	            if(selectedValue == 'tossa' ){
	            	$("#whitediv").hide();
	            	$("#tossadiv").show();
	            }
	            if(selectedValue == 'white' ){
	            	$("#whitediv").show();
	            	$("#tossadiv").hide();
	            }
	            if(selectedValue == '' ){
	            	$("#whitediv").hide();
	            	$("#tossadiv").hide();
	            }
		
	});
	
	
	</script>
	
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

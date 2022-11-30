<!DOCTYPE html>
<html lang="en">
<%@page import="com.jci.model.BalePreparationModel"%>
<%@page import="com.jci.model.BalePreparation"%>
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
				<h1 class="page-title">Bale Preparation</h1>
			</div>
			<%
				BalePreparation baleData = (BalePreparation) request.getAttribute("baleMod");
			
			%>
			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<form action="updateBalePreparation.obj" method="POST">
									     <input type="hidden" id="baleId" name="baleId"value="<%=baleData.getBaleId()%>">
										 <input type="hidden" id="juteVarietyjs"name="jute_variety"value="<%=baleData.getJute_variety()%>"> 
										 <input type="hidden" id="place_of_packing"name="place_of_packing"value="<%=baleData.getPlace_of_packing()%>">
										 

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
											<label>Crop Year</label> <select name="crop_year" id="cropyr"
												class="form-control">
												<option value="">-Select-</option>
												<option
													<%if (baleData.getCrop_year().equals("2021-2022")) {
	out.print("selected");
}%>
													value="2021-2022">2021-2022</option>
												<option
													<%if (baleData.getCrop_year().equals("2022-2023")) {
	out.print("selected");
}%>
													value="2022-2023">2022-2023</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Bin number</label> <input class="form-control"
												name="bin_no" id="binnumb" type="number"
												placeholder="Bin Number" required onkeyup="checkLen()"
												value="<%=baleData.getBin_no()%>">
										</div>

										<div class="col-sm-4 form-group">
											<label>Basis</label> <select name="basis" id="basis"
												class="form-control" value="<%=baleData.getBasis()%>">
												<option value="">-Select-</option>
												<%-- <% 
                                        			if(baleData.getBasis()!=null){
                                        		%>
                                        				<option value="<%baleData.getBasis();%>" selected><%=baleData.getBasis()%></option>
                                        		<%
                                        			}
                                        		 %> --%>
												<option
													<%if (baleData.getBasis().equals("msp")) {
	out.print("selected");
}%>
													value="msp">MSP</option>
												<option
													<%if (baleData.getBasis().equals("commercial")) {
	out.print("selected");
}%>
													value="commercial">Commercial</option>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Jute Variety</label> <select name="jute_variety"
												id="jutevariety" class="form-control">
												<%
													if (baleData.getJute_variety() != null) {
												%>
												<option selected value="<%baleData.getJute_variety();%>"><%=baleData.getJute_variety()%></option>
												<%
													}
												%>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Jute Grade</label> <select name="jute_grade"
												id="jutegarde" class="form-control"
												value="<%=baleData.getJute_grade()%>">
												<%
													if (baleData.getJute_grade() != null) {
												%>
												<option selected value="<%baleData.getJute_grade();%>" ><%=baleData.getJute_grade()%></option>
												<%
													}
												%>
											</select>
										</div>

										<div class="col-sm-4 form-group">
											<label>Bale Check SlipNo.(From)</label> <input
												class="form-control" name="slip_no_from"
												id="fromCheckSlipNo" type="text"
												placeholder="Bale Check SlipNo"
												value="<%=baleData.getSlip_no_from()%>">
										</div>

									</div>

									<div class="row">
										<!-- <div class="col-sm-4 form-group">
                                             <label>Jute Grade</label>
                                        	 <input class="form-control" name="jutegrade" type="text" placeholder="Jute Grade" required>
                                        </div>  -->

										<div class="col-sm-4 form-group">
											<label>Bale Check SlipNo.(To)</label> <input
												class="form-control" name="slip_no_to" id="toCheckSlipNo"
												type="text" placeholder="Bale Check SlipNo"
												onblur="calculateNoOfBales()"
												value="<%=baleData.getSlip_no_to()%>">
										</div>

										<div class="col-sm-4 form-group">
											<label>Total Bales</label> <input class="form-control"
												name="bale_no" id="noOfBales" type="text"
												placeholder="Total bales"
												value="<%=baleData.getBale_no()%>" readonly>
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

	<script>
		$(function() {
			var dtToday = new Date();
			var month = dtToday.getMonth() + 1;
			var day = dtToday.getDate();
			var year = dtToday.getFullYear();
			if (month < 10)
				month = '0' + month.toString();
			if (day < 10)
				day = '0' + day.toString();
			var maxDate = year + '-' + month + '-' + day;
			$('#datepurchase').attr('max', maxDate);
		});
	</script>

	<script>
		$("#basis")
				.on(
						"change",
						function() {
							var msp_no;
							var variety = (this.value);
							if (variety == "msp") {
								msp_no = 2;
							} else if (variety == "commercial") {
								msp_no = 1;
							}
							$
									.ajax({
										type : "GET",
										url : "findJuteOnBasis.obj",
										data : {
											"msp_no" : msp_no
										},
										success : function(result) {
											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												var sar = data[i];
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
											}
											$("#jutevariety").html(html);
										}
									});
						});
	</script>
	<script>
		$("#jutevariety")
				.on(
						"change",
						function() {
							var basis_no;
							var grade;
							var count = 0;
							var data;
							var basis = document.getElementById("basis").value;
							if (basis == "commercial")
								basis_no = 2;
							else if (basis == "msp")
								basis_no = 1;
							var variety = (this.value);
							$
									.ajax({
										type : "GET",
										url : "findGradeOnJuteVariety.obj",
										data : jQuery.param({
											"variety" : variety,
											"basis_no" : basis_no
										}),
										success : function(result) {
											data = jQuery.parseJSON(result);
											var data = jQuery.parseJSON(result);
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {
												var sar = data[i];
												html += "<option value="+sar+">"
														+ data[i] + "</option>"
											}
											$("#jutegarde").html(html);
										}
									});
						});
	</script>

	<script>
		function checkLen() {
			var binnumber = document.getElementById("binnumb").value;
			var max_chars = 3;
			// binnumber.value = binnumber.value.substr(0, max_chars);
			if (binnumber.toString().length == 3) {
				// alert("hell");
				$("#binnumb").prop("type", "text");
				$("#binnumb").attr("maxlength", "3");
				$("#binnumb").attr("minlength", "1");
			}
		}
	</script>

	<script>
		function calculateNoOfBales() {
			var fromCheckSlipNo = document.getElementById("fromCheckSlipNo").value;
			var toCheckSlipNo = document.getElementById("toCheckSlipNo").value;
			var noOfBales = (toCheckSlipNo - fromCheckSlipNo) + 1;
			if (noOfBales >= 0) {
				document.getElementById("noOfBales").value = noOfBales;
			} else {
				alert("No of bales can not be negative or 0");
				return false;
			}
		}
	</script>

	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>
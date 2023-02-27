<!DOCTYPE html>
<html lang="en">

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
				<h1 class="page-title">Contract Generation PCSO Wise</h1>
			</div>

			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">

							<div class="ibox-body">
								<span>${msg}</span>
								<form action="savecontractgeneration.obj" method="POST">
									<div class="row">
									
									
										<div class="col-sm-4 form-group">
											<label class="required">PCSO Date</label> <input
												type="date" name="pcso_date" id="pcso_date"
												class="form-control" required>

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Contract Quantity</label> <input
												type="number" name="contract_Qty" id="contract_Qty"
												class="form-control" placeholder="Contract Quantity" required>
										</div>


										<div class="col-sm-4 form-group">
											<label class="required">(Contract Number) BT- </label> <input
												class="form-control" name="contactnumber"
												id="contactnumber" type="number" placeholder="Contract Number"
												required>
										</div>
									</div>
									<div class="row">
									<div class="col-sm-4 form-group">
											<label class="required">Contract Date</label> <input
												type="date" name="contract_date" id="contract_date"
												class="form-control" required>

										</div>
										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control"
												required>
												<option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												</select>
										</div>
										</div>
										<div class="row">
										<div class="col-sm-4 form-group">
											
											<label class="required">TD1</label>
											<input type="number" name="grade1" id="grade1"
												class="form-control"  />
												</div>
											<label class="required">TD2_W1</label>
											<input type="number" name="grade2" id="grade2"
												class="form-control"  />
												<label class="required">TD3_W2_M1_B1</label>
											<input type="number" name="grade3" id="grade3"
												class="form-control"  />
												<label class="required">TD4_W3_M2_B2</label>
											<input type="number" name="grade4" id="grade4"
												class="form-control"  />
												<label class="required">TD5_W4_M3_B3</label>
											<input type="number" name="grade5" id="grade5"
												class="form-control"  />
												<label class="required">TD6_W5_M4_B4</label>
											<input type="number" name="grade6" id="grade6"
												class="form-control"  />
												<label class="required">TD7_W6_M5_B5</label>
											<input type="number" name="grade7" id="grade7"
												class="form-control"  />
												<label class="required">TD8_W7_M6_B6</label>
											<input type="number" name="grade8" id="grade8"
												class="form-control"  />
												<label class="required">W8</label>
											<input type="number" name="grade9" id="grade9"
												class="form-control"  />
										</div>

										<!-- <div class="col-sm-4 form-group">
											<label class="required">Type of Delivery</label> <select type="text"
												name="delibry_type" id="delibry_type" class="form-control"
												required>
											<option disabled selected value>-Select-</option>
												<option value="Mill Delivery">Mill Delivery</option>
												<option value="Ex-Godown">Ex-Godown</option>
												</select>
										</div> -->
									</div>
									<div class="row">
										<div class="form-group">
											<button class="btn btn-success" type="submit">Submit</button>
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



	<!-- PAGE LEVEL SCRIPTS-->
</body>
</html>

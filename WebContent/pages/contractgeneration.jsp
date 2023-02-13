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
				<h1 class="page-title">Contract Generation </h1>
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
											<label class="required">Contract Number</label> <input
												type="number" name="contract_number" id="contract_number"
												class="form-control" placeholder="Contract Number" required>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Contract Date</label> <input
												type="date" name="contract_date" id="contract_date"
												class="form-control" required>

										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Full Contract Number</label> <input
												class="form-control" name="full_contactnumber"
												id="full_contactnumber" type="number" placeholder="Full Contract Number"
												required>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 form-group">
											<label class="required">Crop Year</label> <select
												name="crop_year" id="crop_year" class="form-control"
												required>
												<option disabled selected value>-Select-</option>
												<option value="2021-2022">2021-2022</option>
												<option value="2022-2023">2022-2023</option>
												</select>
										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Variety-Grade Wise Quantity</label> <input
												type="number" name="variety_gradewisequantity"
												id="variety_gradewisequantity" class="form-control" placeholder="Variety-Grade Wise Quantity" required>

										</div>

										<div class="col-sm-4 form-group">
											<label class="required">Type of Delivery</label> <select type="text"
												name="delibry_type" id="delibry_type" class="form-control"
												required>
											<option disabled selected value>-Select-</option>
												<option value="Mill Delivery">Mill Delivery</option>
												<option value="Ex-Godown">Ex-Godown</option>
												</select>
										</div>
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

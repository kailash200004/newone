<!DOCTYPE html>
<html>

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
<!-- THEME STYLES-->
<link href="assets/css/main.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<link href="./assets/css/pages/auth-light.css" rel="stylesheet" />
<style>
#captcha {
	user-select: none;
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	background-color: #e8f0fe;
	padding: 6px;
	font-size: 1rem;
	font-style: italic;
	font-weight: bold;
}
</style>

</head>

<body class="bg-silver-300">
	<div class="content">
		<div class="brand"></div>
		<form id="login-form" action="loginAction.obj" method="post">
			<h2 class="login-title">Sign In</h2>
			<center>
				<img src="assets\img\logos\main_logo.png">
			</center>
			<div class="form-group">
				<div class="input-group-icon right">
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
					<input class="form-control" type="email" name="email"
						placeholder="Email" autocomplete="off">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group-icon right">
					<div class="input-icon">
						<i class="fa fa-lock font-16"></i>
					</div>
					<input class="form-control" type="password" name="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group-icon right">
					<div id="captchaBackground">
						<div class="row">
							<div class="col-3">
								<span id="captcha">captcha text</span>

							</div>
							<div class="col-6">
								<input id="textBox" class="form-control" type="text"
									name="text" placeholder="Enter tha Captcha">
							</div>
							<div class="col-3">
								<input id="submit" type="hidden">
								<button id="refresh" class="btn btn-outline-dark" type="">Refresh</button>
							</div>
						</div>


						<span id="output"></span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-info btn-block" type="submit"
					id="submitcaptcha">Login</button>
			</div>


		</form>
	</div>
	<!-- BEGIN PAGA BACKDROPS-->
	<div class="sidenav-backdrop backdrop"></div>
	<div class="preloader-backdrop">
		<div class="page-preloader">Loading</div>
	</div>
	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS -->
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS -->
	<script
		src="./assets/vendors/jquery-validation/dist/jquery.validate.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#login-form').validate({
				errorClass : "help-block",
				rules : {
					email : {
						required : true,
						email : true
					},
					password : {
						required : true
					}
				},
				highlight : function(e) {
					$(e).closest(".form-group").addClass("has-error")
				},
				unhighlight : function(e) {
					$(e).closest(".form-group").removeClass("has-error")
				},
			});
		});
	</script>

	<script>
		let captchaText = document.querySelector('#captcha');
		let userText = document.querySelector('#textBox');
		let submitButton = document.querySelector('#submit');
		let output = document.querySelector('#output');
		let refreshButton = document.querySelector('#refresh');

		let alphaNums = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9' ];
		let emptyArr = [];
		for (let i = 1; i <= 7; i++) {
			emptyArr.push(alphaNums[Math
					.floor(Math.random() * alphaNums.length)]);
		}
		captchaText.innerHTML = emptyArr.join('');

		$(document).ready(function() {
			$("#submitcaptcha").click(function() {
				if (userText.value === "") {
					output.classList.add("redText");
					output.innerHTML = "Please Fill tha captcha";
					return false;
				}
				if (userText.value === captchaText.innerHTML) {
					output.classList.add("greenText");
					output.innerHTML = "";
				} else {
					output.classList.add("redText");
					output.innerHTML = "Incorrect, please try again";
					return false;
				}
			});
		});

		$(document).ready(
				function() {
					$("#refresh").click(
							function() {
								userText.value = "";
								let refreshArr = [];
								for (let j = 1; j <= 7; j++) {
									refreshArr.push(alphaNums[Math.floor(Math
											.random()
											* alphaNums.length)]);
								}
								captchaText.innerHTML = refreshArr.join('');
								output.innerHTML = "";
								return false;
							});
				});
	</script>
</body>

</html>
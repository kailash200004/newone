<style>
body {
	zoom: 85%;
}
</style>
<nav class="page-sidebar" id="sidebar">
	<div class="page-brand">
		<a class="link" href="#"> <span class="brand"> <span
				class="brand-tip"> <img src="assets/img/logo5.png">
			</span>
		</span> <span class="brand-mini"> <img src="assets/img/logo5.png">
		</span>
		</a>
	</div>
	<div id="sidebar-collapse">
		<div class="admin-block d-flex">
			<div>
				<img style="border-radius: 37px;"
					src="https://placehold.jp/100x100.png" width="45px" />
			</div>
			
  <div class="admin-info">
  
	<div class="font-strong">Welcome <br>
	<span style="color: #ffc107;">
	<%
		String Email=(String)request.getSession().getAttribute("usrname");
		out.print(Email);
		if(Email==null){
			
		    String redirectURL = "http://localhost:8080/jciadmin/index.obj";
		    response.sendRedirect(redirectURL);
		
		}
		
  	%>
	</span>
	
	
	</div></div>
			
			</div>
			<!-- <div class="admin-info">
				<div class="font-strong">Nikhil Saxena</div>
				<small>Administrator</small>
			</div>
		</div> -->
		<ul class="side-menu metismenu">
			<li><a href="dashboard.obj"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Dashboard</span> </a></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">Privileges</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li><a href="userrole.obj">Add Role</a></li>
					<li><a href="useraction.obj">Add Action</a></li>
					<li><a href="userprivilige.obj">Add Privileges</a></li>
					<li><a href="viewuserrole.obj">View User Role</a></li>
					<!-- <li><a href="#">Re-assortment</a></li> -->
				</ul></li>
				
			<li><a href="javascript:void(0);;"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">0. &nbsp;User Management</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<li><a class="active" href="UserRegistration.obj"><b>User
							Registration</b></a></li>
					<li><a class="active" href="viewUserRegistration.obj"><b>View
							User Registration</b></a></li>

				</ul></li>
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">1. &nbsp;Farmer Registration </span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<!-- <li>
                                <a class="active" href="addOrganisation.obj">Add Organization</a>
                            </li> -->
					<!--  <li>
                                <a href="addFarmer.obj">Add Farmer</a>
                            </li> -->
					<li><a class="active" href="FarmerRegistration.obj"><b>Farmer Registration</b></a></li>
					<li><a class="active" href="ViewFarmerRegistration.obj"><b>View Farmer List Reg</b></a></li>
				</ul>
				</li>
				<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">2. &nbsp;Market Arrival</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li><a href="rulingMarketForm.obj">Ruling Market Rate at DPC</a></li>
					<li><a href="viewmarketArrival.obj"> View Ruling Market List</a></li>
					 
					<li><a href="jbaRate.obj">JBA Rate</a></li>
					<li><a href="JbaPriceList.obj">JBA List</a></li>
					
					
				</ul></li>

			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">3. &nbsp;Raw Jute Procurement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li><a href="mspPriceCalculation.obj"><b>MSP Grades Price </b></a></li>
					<li><a href="commercialPriceCalculation.obj"><b>Commercial Ceiling Price Intimation </b></a></li>
					<li><a href="rawJutePaymentAndProcurement.obj"><b>Raw Jute Procurement & Payment</b></a></li>
					<!-- <li><a href="verificationTallyslip.obj"><b>Verification of Tally Slip</b></a></li> -->
					<li><a href="dailyPurchaseConf.obj"><b>Daily Purchase Confirmation</b></a></li>
					<li><a href="Distributionoftallyslips.obj"><b>Distribution of tally Slip</b></a></li>
				  	<li><a href="mspGradesPriceList.obj"><b>MSP Grades Price Listing </b></a></li>
					<li><a href="viewCommercialCeilingPrice.obj"><b>View Commercial Ceiling Price Intimation</b></a></li>
					<li><a href="tallyapproval.obj"><b>Verification Pending Tally Slip</b></a></li>
					<li><a href="viewVerifiedTallySlipList.obj"><b>Verified Tally Slip List</b></a></li>
			<li><a href="disputedtallyslip.obj"><b>Disputed Tally Slip List</b></a></li>
					<!-- <li><a class="active" href="juteProcurementList.obj"><b>Jute Procurement List</b></a></li> -->
					
					<li><a href="dailyPurchaseList.obj"><b>Daily Purchase List</b></a></li>
					
					
					
					<li><a href="viewDistributionoftallyslips.obj"><b>View Distribution of Tally Slip</b></a></li>
					 <!--  <li><a href="#">Entry of MSP Portal</a></li>
					<li><a href="CommercialCeilingPriceIntimations.obj"><b>Commercial Ceiling Price Intimation</b></a></li>-->
				
				</ul></li>
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">4. &nbsp;Progress of Assortment</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
					<li><a href="balePreparation.obj">Bale Preperation</a></li>
					<li><a href="viewbalePreparation.obj"> View Bale Preperation</a></li>
					<li><a href="addRopeMaking.obj">Rope Making</a></li>
					<li><a href="ropeMakingListing.obj">View Rope Making</a></li>
					<!-- <li><a href="#">Re-assortment</a></li> -->
				</ul></li>

			 
				
				
				
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">5.&nbsp;BIN Performance Calculation</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">
				
					<li><a href="bin.obj">Batch Identification Number</a></li>
					<li><a href="binList.obj">BIN List</a></li>
					<li><a href="binPurchasemapping.obj">BIN Purchase Mapping</a></li>
					<li><a href="BinListfromDb.obj">BIN List</a></li>

				</ul></li>
				<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">6.&nbsp;Contract</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">
					<li><a href="entryofpcso.obj">Entry of PCSO </a></li>
					<li><a href="pcsolist.obj">PCSO List</a></li>
							<li><a href="entry_derivativeprice.obj">Entry of
							Derivative Price</a></li>
					<li><a href="entryderivativepricelist.obj">Entry of
							Derivative Price List</a></li>
					<li><a href="contractgenerationPCSOWise.obj">Contract Generation PCSO Wise</a></li>
					<li><a href="contractgenerationMillWise.obj">Contract Generation Mill Wise</a></li>
					<li><a href="viewcontractgeneration.obj">Contract
							Generation List</a></li>
				</ul></li>
			<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">7.&nbsp;Payment Arrangement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level ">

					<li><a href="entryofpayment.obj">Entry of payment instrument</a></li>
					<li><a href="HOdispatch.obj">HO Dispatch Instruction</a></li>
					<li><a href="entryofsale.obj">Entry of Sale</a></li>
					<li><a href="uploadingreceipt.obj">Uploading of receipt</a></li>
					
					

				</ul></li>
				
				<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">8.&nbsp;Commercial / Daily Sales / Free
						Sale</span> <i class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">

					<li><a href="entryofoperationcost.obj">Entry of Operation
							Cost</a></li>
					

					<li><a href="salespricecalculation.obj">Sale Price
							Calculation</a></li>
					
					<li><a href="contractgenerationcommercial.obj">Contract
							Generation Commercial</a></li>
							<li><a href="salespricecalculationlist.obj">Sale Price
							Calculation List</a></li>
							
							<li><a href="entryofoperationcostlist.obj">Entry of
							Operation Cost List</a></li>
					<li><a href="viewcontractgenerationcommercial.obj">Contract
							Generation Commercial List</a></li>
				</ul></li>
				
				<!-- <li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">6.&nbsp;Contract</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">

					<li><a href="entry_derivativeprice.obj">Entry of Derivative Price</a></li>
					<li><a href="entryderivativepricelist.obj">Entry of Derivative Price List</a></li>
					<li><a href="contractgeneration.obj">Contract Generation</a></li>
				</ul></li>
				<li><a href="javascript:void(0);"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label">7.&nbsp;Payment Arrangement</span> <i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level">

					<li><a href="entryofpaymentinstrument.obj">Entry of Payment Instrument</a></li>
					

				</ul></li> -->






			<!-- <li><a href="#"><i
					class="sidebar-item-icon fa fa-calculator"></i> <span
					class="nav-label">Sidebar Tab</span> </a></li> -->
		</ul>
	</div>

	<div class="foter-bottom">
		<div>
			<img src="assets/img/icon1.png" class="sidebar-item-icon"><span>Logout</span>
		</div>
	</div>
	<!-- foter-bottom -->
</nav>
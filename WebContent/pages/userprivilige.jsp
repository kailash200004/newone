<!DOCTYPE html>
<html lang="en">
<%@ page import="java.sql.*"%>
<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.UserActionModel"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>


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
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
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
         <h1 class="page-title">User Role</h1>
			
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                             <span>${msg}</span>
                            <div class="ibox-body">
                                <form action="saveuserprivilige.obj" method="POST" name="myForm" onsubmit="return validate()">
                                    <div class="row">
                                        <div class="col-sm-4 form-group">
                                         
                                        
                                           <label>User Role</label>
                                         <Select type="text" name="userrole" id="userrole" class="form-control" placeholder="User Role"  required/>
                                      <option disabled selected value>Select</option>
                                             
    
            
            	<%
						List<UserRoleModel> alluserroleList = (List<UserRoleModel>) request.getAttribute("userroleList");	
            			//out.println("====="+request.getAttribute("arrOfStr"));
            	%>
                                      <%
                                      for(UserRoleModel userrole : alluserroleList) {
												%>
												<option value="<%=userrole.getRole_Id()%>"><%=userrole.getRole_name()%></option>
                                  <%
													}
												%>
									  
                                        </div>
                                        

								                              
										
                <div class="col-sm-4 form-group">                    
                                 
          <div id="useraction"></div>
										
										
                                    </div>   
                                   
                                 
                                    
	                                                <div class="col-sm-4 form-group">                       
                                    <div class="form-group">
                                  
                                        <button class="btn btn-default" type="submit" id="create">Create</button>
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

    	$('select[name="userrole"]').on('change', function() {
    	     cval=this.value;
    	     //alert("set");
    	     $.get('userpriviligeajax.obj', {
    	roleId : cval
    	}, function(responseText) {
    		var text= responseText.replace("[]","").replace("]","");
    		const myArray= responseText.split(",");
    		console.log(myArray);
    	$("#useraction").html(responseText);
    	});
    	     alert(cval);
    	     alert("hello");
    	     
    	     
    	      
    	});  });</script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    </div>
</body>
</html>

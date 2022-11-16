<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%@page import="com.jci.model.JbaModel"%>

<!DOCTYPE html>
<html lang="en">

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
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
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
                <h1 class="page-title">JBA  Details</h1>
            </div>
				<%
					List<JbaModel> jbapri = (List<JbaModel>) request.getAttribute("jbaList");	
				%>
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <div class="ibox-body">
                    	<span>${msg}</span>
                        <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sl.No</th>
										
										<th>Date</th>
										<th>Grade Wise Price Details</th>
										<!-- <th>ID</th>
										<th>Jute Variety</th>
										<th>Crop Year</th>
										<th>Area code</th> 										
										<th>Grade Wise Price</th> -->
										<th>Edit</th>
										<th>Delete</th>									
									</tr>
								</thead>
								<tbody>
									<% 
									int i= 1;
							for(JbaModel jbaList : jbapri){
							%>
									<tr>
										<td><%=i%></td>
						                
										<td><%=jbaList.getJbaDate()%></td>
										<td><a href="http://49.50.79.121:8080/jciDocs/14.09.2022.jpg" target="_blank"><span>Grade Price</span></a></td>
										
										<%--  <td><%=jbaList.getId()%></td>
				                    	<td><%=jbaList.getJutevariety()%></td>
										 <td><%=jbaList.getCropyr()%>
										<td><%=jbaList.getAreaCode()%></td> 
										<td><%=jbaList.getGradeWisePrice()%></td>
									    <!-- <td><a href="editJBAList.obj?id=<%=jbaList.getId()%>" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td> --> --%>
									    <td><a onClick="EditBtn_click(<%=jbaList.getId()%>)" class="btn btn-warning btn-sm btn-block"><i class="fa fa-pencil" aria-hidden="true" style="font-size: 15px;"></i></a></td>
										<td><a href="JbaDelete.obj?id=<%=jbaList.getId()%>" onclick="return confirm('Are you sure you want to delete this item?');"><i class="btn btn-danger btn-sm btn-block"><i class="fa fa-trash" aria-hidden="true" style="font-size: 15px;"></i></a></td>
									</tr>
											<!--<div class="sliderbox slider9"><a href="https://www.bobfinancial.com/documents/VoltasEMIOfferStoreList.pdf" target="_blank">&nbsp;</a></div>-->
									
									<% 
							i++; }
							
							%>
								</tbody>
   
                        </table>
                    </div>
                </div>
                 
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    <!-- BEGIN THEME CONFIG PANEL-->
     
    <!-- END THEME CONFIG PANEL-->
    <!-- BEGIN PAGA BACKDROPS-->
    <div class="sidenav-backdrop backdrop"></div>
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script>
    function EditBtn_click(id) {
        //alert(id);
        $.ajax({
    		url:"RouteEditforCheck.obj",
    		type : 'GET',
    		data : {
    			id : id
    		},
    		success : function(data) {				 
    			//alert(data);
    			if(data>7){
    				alert('JBA List is not editable after 7 Days');
    			}else{
    				window.open("editJBAList.obj?id="+id,"_self")

    			}
    			//$("#TotalL2pending").html(data);
    		}
    	});
    }  
    </script>
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
                pageLength: 10,
                //"ajax": './assets/demo/data/table_data.json',
                /*"columns": [
                    { "S": "name" },
                    { "data": "office" },
                    { "data": "extn" },
                    { "data": "start_date" },
                    { "data": "salary" }
                ]*/
            });
        })
    </script>
</body>

</html>
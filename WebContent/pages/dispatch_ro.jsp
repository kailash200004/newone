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


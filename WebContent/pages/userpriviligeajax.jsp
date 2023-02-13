<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@page import="com.jci.model.UserRoleModel"%>
<%@page import="com.jci.model.UserActionModel"%>
<%@page import="com.jci.model.UserPriviligeModel"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.AbstractList"%>
<%@page import="com.jci.dao.impl.UserPriviligeDaoImpl"%>
Sytem.out.printl("Hello World");
<form action="saveuserprivilige.obj" method="post">
Sytem.out.printl("Hello");
<div class="rightmanagetable"><ul>

<%
String[] arrOfStr=null;
//ArrayList<UserPrivilege> uPri= new ArrayList<UserPrivilegeUtil>();
UserPriviligeModel uPri=null;
int role_Id= 0;
try{
	role_Id= Integer.parseInt(request.getParameter("role_Id"));
  uPri=UserPriviligeDaoImpl.getUserPrivilegeListing(role_Id);
  arrOfStr = uPri.getAction_permissions().split(","); 
}catch(Exception ex){
	
}
%>

<input type="hidden" name="roleId" value="<%=role_Id%>">

<%
ArrayList<UserActionModel> actList=(ArrayList<UserActionModel>) request.getAttribute("useractionlist");
for(UserActionModel useract:actList){
	String mycheck="";
	
	try{
		
	for(int i=0;i<arrOfStr.length;i++){
		if(arrOfStr[i].equals(Integer.toString(useract.getAction_id()))){
			mycheck="checked";
	}
	} 
	}catch(Exception ex)
	{

	}
	
 %>
<li><span><input type="checkbox" value="<%=useract.getAction_id()%>" <%=mycheck%> name="<%=useract.getAction_name()%>"><%=useract.getAction_id() %></span></li>
<%
}%>  

</ul>
</div>
<div class="r-mng-btn"><input type="submit" value="submit" name="submit"><input type="Reset" name="Reset"></div>
</form>





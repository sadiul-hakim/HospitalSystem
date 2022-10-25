<%-- 
    Document   : ChangeUserPassword
    Created on : Oct 16, 2022, 11:53:34 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>

<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>


<%
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
    User user=SecurityContext.getCurrentUser(request);
%>


<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
            
        <main class="container">
            <div class="row">
                <form class="col-md-5 offset-2 card mx-auto my-5 p-3" action="UserChangePasswordServlet?id=<%= user.getId()%>" method="post">
                    <h3 class="common-heading">Change Password</h3>
                    <div class="form-group mb-2">
                        <label for="oldPassword">Old Password</label>
                        <input type="password" name="oldPassword" required="true" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <label for="newPassword">New Password</label>
                        <input type="password" name="newPassword" required="true" class="form-control"/>
                    </div>
                    <input type="submit" value="Change" class="btn btn-success"/>
                </form>
            </div>
        </main>
        
        <%@include file="Footer.jsp" %>
    </body>
</html>

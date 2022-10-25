<%-- 
    Document   : UserLogin
    Created on : Oct 13, 2022, 7:28:17 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>

<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>


<%
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(isAuthenticated){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    
    User user=SecurityContext.getCurrentUser(request);
%>


<!DOCTYPE html>
<html>
<%@include file="HeadTag.jsp" %>
<body>


<%@include file="DefaultNavbar.jsp" %>


<div class="card  mx-auto mt-5  login-temp p-4">
    <h3>User Login</h3>

    <form action="UserLoginServlt" method="post">
        <div class="form-group">
            <label for="email">Email : </label>
            <input type="email" name="email" required="true" class="form-control"/>
            <c:if test="${errors.email!=null}">
                <p class="text-danger"><c:out value="${errors.email}"/></p>
            </c:if>
        </div>
        <div class="form-group">
            <label for="password">Password : </label>
            <input type="password" name="password" required="true" class="form-control"/>
            <c:if test="${errors.password!=null}">
                <p class="text-danger"><c:out value="${errors.password}"/></p>
            </c:if>
        </div>
        <br/>
        <button type="submit" class="btn login-btn">Login</button>
        <br/>
        <p>Don't have any account? <a href="UserRegister.jsp">Create One</a></p>
       
    </form>
</div>
</body>
</html>

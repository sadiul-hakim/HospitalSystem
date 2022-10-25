<%-- 
    Document   : UserRegister
    Created on : Oct 13, 2022, 7:32:02 PM
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


<div class="card  mx-auto mt-5  register-temp p-4">
    <h3>User Register</h3>

    <form action="UserRegisterServlt" method="post">
        <div class="form-group">
            <label for="fullname">Full Name : </label>
            <input type="text" name="fullname" required="true" class="form-control"/>
            <c:if test="${errors.fullname != null}">
                <small class="text-danger"><c:out value="${errors.fullname}"/></small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="email">Email : </label>
            <input type="email" name="email" required="true" class="form-control"/>
            <c:if test="${errors.email != null}">
                <small class="text-danger"><c:out value="${errors.email}"/></small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="password">Password : </label>
            <input type="password" name="password" required="true" class="form-control"/>
            <c:if test="${errors.password != null}">
                <small class="text-danger"><c:out value="${errors.password}"/></small>
            </c:if>
        </div>
        <br/>
        <button type="submit" class="btn login-btn">Register</button>
        <br/>
        <p>Already have an account? <a href="UserLogin.jsp">Login</a></p>
       
    </form>
</div>
</body>
</html>
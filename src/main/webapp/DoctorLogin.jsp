<%-- 
    Document   : DoctorLogin
    Created on : Oct 13, 2022, 7:27:36 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>

<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>


<%
    Doctor doctor=SecurityContext.loggedDoctor(request);
    
    if(doctor!=null){
        request.getRequestDispatcher("DoctorDashboard.jsp").forward(request,response);
    }
%>


<!DOCTYPE html>
<html>
<%@include file="HeadTag.jsp" %>
<body>

<%@include file="DefaultNavbar.jsp" %>


<div class="card  mx-auto mt-5  login-temp p-4">
    <h3>Doctor Login</h3>

    <form action="DoctorLoginServlet" method="post">
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
    </form>
</div>

</body>
</html>
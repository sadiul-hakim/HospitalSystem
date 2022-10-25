<%-- 
    Document   : Doctor.jsp
    Created on : Oct 15, 2022, 1:47:25 PM
    Author     : Hakim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.dao.specialist.Specialist" %>
<%@page import="java.util.List" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>


<%
   boolean isAdminLoggedIn=SecurityContext.adminLoggedIn(request);
   
   if(!isAdminLoggedIn){
        request.getRequestDispatcher("Admin_Login.jsp").forward(request,response);
   }
           
   List<Specialist> specialists=ServerCalls.getAllSpecialists();
   List<Doctor> doctors=ServerCalls.allDoctors();
%>



<!DOCTYPE html>
<html>
<%@include file="HeadTag.jsp" %>
<body>
<%@include file="AdminNavbar.jsp" %>

<main class="container-fluid">
    <div class="row my-2">
        <div class="col-md-3 card">
            <%@include file="AddDoctor.jsp" %>
        </div>
        <div class="col-md-9 card">
            <%@include file="DoctorList.jsp" %>
        </div>
    </div>
</main>

<%@include file="Footer.jsp" %>
</body>
</html>
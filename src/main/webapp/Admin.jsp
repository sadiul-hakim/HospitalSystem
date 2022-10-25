<%-- 
    Document   : Admin
    Created on : Oct 15, 2022, 11:48:04 PM
    Author     : Hakim
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.dao.appointment.Appointment" %>
<%@page import="com.HospitalSystem.dao.admin.Admin" %>
<%@page import="com.HospitalSystem.dao.specialist.Specialist" %>
<%@page import="java.util.List" %>


<%
   Admin admin=SecurityContext.loggedAdmin(request);
   
   if(admin==null){
        request.getRequestDispatcher("Admin_Login.jsp").forward(request,response);
    }
   
   List<Specialist> specialists=ServerCalls.getAllSpecialists();
   List<Doctor> doctors=ServerCalls.allDoctors();
   List<User> users=ServerCalls.allUsers();
   List<Appointment> appointments=ServerCalls.allAppointments();
%>

<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="AdminNavbar.jsp" %>
        <%@include file="AdminMainComp.jsp" %>
        <%@include file="Footer.jsp" %>
    </body>


</html>

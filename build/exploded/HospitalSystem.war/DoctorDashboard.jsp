<%-- 
    Document   : DoctorDashboard
    Created on : Oct 16, 2022, 3:24:04 PM
    Author     : Hakim
--%>

<%@page import="com.HospitalSystem.entity.SecurityContext" %>
<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="com.HospitalSystem.entity.AppointmentStatus" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.dao.appointment.Appointment" %>
<%@page import="java.util.List" %>

<%
    Doctor doctor=SecurityContext.loggedDoctor(request);
    
    if(doctor==null){
        request.getRequestDispatcher("DoctorLogin.jsp").forward(request,response);
    }
    
    List<Appointment> appointments=ServerCalls.appointmentRelatedToADoctor(doctor.getId());
    int total=appointments.size();
    int done=0;
    int pending=0;
    
    for(Appointment ap:appointments){
        if(ap.getAppointmentStatus().equals(AppointmentStatus.OK)){
            done++;
        }else if(ap.getAppointmentStatus().equals(AppointmentStatus.PENDING)){
            pending++;
        }
    }

%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="DoctorNavbar.jsp" %>
        
        <main class="container my-5">
            <div class="row">
                <div class="col-md-4 card d-flex justify-content-center align-items-center">
                    <h2><i class=" fa fa-calendar"></i></h2>
                    <h4>Total Appointment</h4>
                    <h4><%= total%></h4>
                </div>
                <div class="col-md-4 card d-flex justify-content-center align-items-center gap-2">
                    <h2><i class=" fa fa-calendar-check-o"></i></h2>
                    <h4>Completed Appointment</h4>
                    <h4><%= done%></h4>
                </div>
                <div class="col-md-4 card d-flex justify-content-center align-items-center">
                    <h2><i class=" fa fa-calendar-minus-o"></i></h2>
                    <h4>Pending Appointment</h4>
                    <h4><%= pending%></h4>
                </div>
            </div>
        </main>
        
        <%@include file="Footer.jsp" %>
    </body>
</html>

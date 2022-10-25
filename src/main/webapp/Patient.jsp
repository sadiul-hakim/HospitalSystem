<%-- 
    Document   : Patient
    Created on : Oct 16, 2022, 10:24:09 PM
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
    

%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="DoctorNavbar.jsp" %>

        <main class="container">
            <div class="row">
                <div class="col-12 card my-4">
                    <h2 class="common-heading">Patient Details</h2>

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Full Name</th>
                                <th scope="col">Gender</th>
                                <th scope="col">Age</th>
                                <th scope="col">Date</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Disease</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Appointment a:appointments){%>
                            <tr>
                                <td><%= a.getFullname()%></td>
                                <td><%= a.getGender()%></td>
                                <td><%= a.getAge()%></td>
                                <td><%= a.getDate()%></td>
                                <td><%= a.getEmail()%></td>
                                <td><%= a.getPhone()%></td>
                                <td><%= a.getDesease()%></td>
                                <td><%= a.getAppointmentStatus()%></td>
                                <td>
                                    <%if(a.getAppointmentStatus().equals(AppointmentStatus.PENDING)){%>
                                    <a class="btn btn-success" href="DoneAppointmentServlet?id=<%= a.getId()%>">Done</a>
                                    <%}else{%>
                                    #
                                    <%}%>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>

        <%@include file="Footer.jsp" %>
    </body>
</html>

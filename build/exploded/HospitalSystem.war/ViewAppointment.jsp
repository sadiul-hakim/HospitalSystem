<%-- 
    Document   : ViewAppointment
    Created on : Oct 16, 2022, 8:32:13 PM
    Author     : Hakim
--%>

<%@page import="com.HospitalSystem.entity.SecurityContext" %>
<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.dao.appointment.Appointment" %>
<%@page import="java.util.List" %>
<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="com.HospitalSystem.entity.AppointmentStatus" %>

<%
    User user=SecurityContext.getCurrentUser(request);
    
    if(user==null){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    List<Doctor> doctors=ServerCalls.allDoctors();
    List<Appointment> appointments=ServerCalls.appointmentRelatedToAUser(user.getId());
    Doctor doctor=null;
%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>

        <main class="container">
            <div class="row my-5">
                <div class="col-md-9 gap-2 card">
                    <h2 class="common-heading">Appointment List</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Full Name</th>
                                <th scope="col">Gender</th>
                                <th scope="col">Age</th>
                                <th scope="col">Date</th>
                                <th scope="col">Disease</th>
                                <th scope="col">Doctor</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Appointment a:appointments){%>
                            <tr>
                                <td><%= a.getFullname()%></td>
                                <td><%= a.getGender()%></td>
                                <td><%= a.getAge()%></td>
                                <td><%= a.getDate()%></td>
                                <td><%= a.getDesease()%></td>
                                <td>
                                    <%
                                        for(Doctor d:doctors){
                                            if(d.getId()==a.getDoctor()){
                                                doctor=d;                                            
                                            }   
                                        }
                                    %>
                                    <%= doctor!=null ? doctor.getName() : "Not Found"%>
                                </td>
                                <td>

                                    <%if(a.getAppointmentStatus().equals(AppointmentStatus.PENDING)){%>
                                    <p style="background:#ffb90f;color:white;">
                                        <i class=" fa fa-clock-o"></i><%= a.getAppointmentStatus()%>
                                    </p>
                                    <%}else{%>
                                    <%= a.getAppointmentStatus()%>
                                    <%}%>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>
                <div class="col-md-3">
                    <img src="img/doc-2.jpg" alt="view appointment pic" style="width:100%;height: 250px"/>
                </div>
            </div>
        </main>

        <%@include file="Footer.jsp" %>
    </body>
</html>

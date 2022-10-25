<%-- 
    Document   : UserAppointment
    Created on : Oct 16, 2022, 6:59:50 PM
    Author     : Hakim
--%>

<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>
<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="java.util.List" %>

<%
    User user=SecurityContext.getCurrentUser(request);
    
    if(user==null){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
    List<Doctor> doctors=ServerCalls.allDoctors();
    
%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
        <main class="container">
            <div class="row">
                <div class="col-md-3 d-flex justify-content-center align-items-center">
                    <img src="img/doc-1.jpg" alt="appointment pic" style="width:100%;height: 250px"/>
                </div>
                <div class="col-md-9">
                    <h2 class="common-heading">User Appointment</h2>
                    <form action="AddUserAppointmentServlet?id=<%= user.getId()%>" method="post" class="card p-2 mb-2">
                        <div class="row mb-2">
                            <div class="form-group col-md-6">
                                <label for="fullname">Full Name</label>
                                <input type="text" class="form-control" name="fullname" required="true"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="gender">Gender</label>
                                <select required="true" name="gender" class="form-control">
                                    <option value="">--Select Gender--</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Others">Others</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="form-group col-md-6">
                                <label for="age">Age</label>
                                <input type="number" class="form-control" name="age" required="true"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="date">Appointment Date</label>
                                <input type="date" class="form-control" name="date" required="true"/>
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="form-group col-md-6">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" required="true"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="phone">Phone</label>
                                <input type="number" class="form-control" name="phone" required="true"/>
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="form-group col-md-6">
                                <label for="disease">Disease</label>
                                <input type="text" class="form-control" name="desease" required="true"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="doctor">Doctor</label>
                                <select required="true" name="doctor" class="form-control">
                                    <option value="">--Select Doctor--</option>
                                    <%for(Doctor d:doctors){%>
                                    <option value="<%= d.getId()%>"><%= d.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="form-group col-12">
                                <label for="address">Full Address</label>
                                <textarea rows="5" class="form-control" name="address" required="true"></textarea>
                            </div>
                        </div>
                        <div class="d-grid gap-2 col-6 mx-auto">
                            <input type="submit" value="Submit" class="btn btn-success"/>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    </body>

    <%@include file="Footer.jsp" %>
</html>

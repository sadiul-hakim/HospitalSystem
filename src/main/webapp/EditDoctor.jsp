<%-- 
    Document   : EditDoctor
    Created on : Oct 16, 2022, 11:21:37 AM
    Author     : Hakim
--%>

<%@page import="com.HospitalSystem.entity.ServerCalls" %>
<%@page import="com.HospitalSystem.dao.doctor.Doctor" %>
<%@page import="com.HospitalSystem.dao.specialist.Specialist" %>
<%@page import="java.util.List" %>

<%

    int id=Integer.valueOf(request.getParameter("id"));
    System.out.println(id+"=>id");
    Doctor doctor=ServerCalls.getDoctor(id);
    List<Specialist> specialists=ServerCalls.getAllSpecialists();
%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>
    <body>
        <%@include file="AdminNavbar.jsp" %>
        <main class="container">

            <h4 class="common-heading">Edit Doctor</h4>
            <form action="EditDoctorServlet?id=<%=id%>" method="post" class="card mx-auto w-50 p-2">
                <div class="form-group mb-2">
                    <label for="name">Full Name</label>
                    <input type="text" class="form-control" required="true" name="name" value="<%= doctor.getName()%>"/>

                </div>
                <div class="form-group mb-2">
                    <label for="dob">DOB</label>
                    <input type="date" class="form-control" required="true" name="dob" value="<%= doctor.getDob()%>"/>

                </div>
                <div class="form-group mb-2">
                    <label for="qualifications">Qualification</label>
                    <input type="text" class="form-control" required="true" name="qualifications" value="<%= doctor.getQualifications()%>"/>

                </div>
                <div class="form-group mb-2">
                    <label for="specialist">Specialist</label>
                    <select name="specialist" class="form-control" required="true">
                        <option value="">--Select Specialist--</option>
                        <%for(Specialist s:specialists){%>
                        <option value="<%= s.getName()%>"><%= s.getName()%></option>
                        <%}%>
                    </select>

                </div>
                <div class="form-group mb-2">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" required="true" value="<%= doctor.getEmail()%>"/>

                </div>
                <div class="form-group mb-2">
                    <label for="phone">Phone</label>
                    <input type="number" class="form-control" name="phone" required="true" value="<%= doctor.getPhone()%>"/>

                </div>
                <div class="form-group mb-2">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" required="true"/>
                </div>
                    <button type="submit" class="btn btn-primary m">Submit</button>
            </form>

        </main>
    </body>
</html>

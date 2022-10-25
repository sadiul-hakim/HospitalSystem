<%-- 
    Document   : DoctorList
    Created on : Oct 15, 2022, 2:10:49 PM
    Author     : Hakim
--%>

<h3 class="common-heading">Doctor Details</h3>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Full Name</th>
            <th scope="col">DOS</th>
            <th scope="col">Qualifications</th>
            <th scope="col">Specialist</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <tbody>
        <%for(Doctor d:doctors){%>
        <tr>
            <td><%= d.getName()%></td>
            <td><%= d.getDob()%></td>
            <td><%= d.getQualifications()%></td>
            <td><%= d.getSpecialist()%></td>
            <td><%= d.getEmail()%></td>
            <td><%= d.getPhone()%></td>
            <td>
                <a class="btn btn-success" href="EditDoctor.jsp?id=<%=d.getId()%>">Edit</a>
                <a class="btn btn-danger" href="DeleteDoctorServlet?id=<%=d.getId()%>">Delete</a>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>



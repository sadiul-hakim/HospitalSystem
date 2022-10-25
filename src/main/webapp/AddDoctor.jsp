<%-- 
    Document   : AddDoctor
    Created on : Oct 15, 2022, 1:52:28 PM
    Author     : Hakim
--%>

<h4 class="common-heading">Add Doctor</h4>
<form action="DoctorServlet" method="post">
    <div class="form-group mb-2">
        <label for="name">Full Name</label>
        <input type="text" class="form-control" required="true" name="name"/>
        <c:if test="${errors.name!=null}">
            <p class="text-danger"><c:out value="${errors.name}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="dob">DOB</label>
        <input type="date" class="form-control" required="true" name="dob"/>
         <c:if test="${errors.dob!=null}">
            <p class="text-danger"><c:out value="${errors.dob}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="qualifications">Qualification</label>
        <input type="text" class="form-control" required="true" name="qualifications"/>
         <c:if test="${errors.qualifications!=null}">
            <p class="text-danger"><c:out value="${errors.qualifications}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="specialist">Specialist</label>
        <select name="specialist" class="form-control">
            <option value="">--Select Specialist--</option>
            <%for(Specialist s:specialists){%>
            <option value="<%= s.getName()%>"><%= s.getName()%></option>
            <%}%>
        </select>
        <c:if test="${errors.specialist!=null}">
            <p class="text-danger"><c:out value="${errors.specialist}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" required="true"/>
        <c:if test="${errors.email!=null}">
            <p class="text-danger"><c:out value="${errors.email}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="phone">Phone</label>
        <input type="number" class="form-control" name="phone" required="true"/>
        <c:if test="${errors.phone!=null}">
            <p class="text-danger"><c:out value="${errors.phone}"/></p>
        </c:if>
    </div>
    <div class="form-group mb-2">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" required="true"/>
        <c:if test="${errors.password!=null}">
            <p class="text-danger"><c:out value="${errors.password}"/></p>
        </c:if>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
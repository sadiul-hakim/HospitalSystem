<%-- 
    Document   : AdminMainComp
    Created on : Oct 15, 2022, 12:17:21 PM
    Author     : Hakim
--%>

<main class="container">
    <h2 class="common-heading">Admin Dashboard</h2>
    <div class="row d-flex justify-content-between">
        <div class="col-md-4 mb-2 admin-card g-2 card d-flex justify-content-center align-items-center">
            <h2>
                <i class="fa fa-plus-square"></i>
            </h2>
            <h4>Doctors</h4>
            <h4><%= doctors.size()%></h4>

        </div>
        <div class="col-md-4 mb-2  admin-card g-2 card  d-flex justify-content-center align-items-center">
            <h2>
                <i class="fa fa-user-circle-o"></i>
            </h2>
            <h4>User</h4>
            <h4><%= users.size()%></h4>
        </div>
        <div class="col-md-4 mb-2  admin-card g-2 card  d-flex justify-content-center align-items-center">
            <h2>
                <i class="fa fa-calendar-check-o"></i>
            </h2>
            <h4>Total Appointment</h4>
            <h4><%= appointments.size()%></h4>
        </div>
        <div class="col-md-4 mb-2  admin-card g-2 card  d-flex justify-content-center align-items-center" data-bs-toggle="modal" data-bs-target="#exampleModal">
            <h2>
                <i class="fa fa-briefcase"></i>
            </h2>
            <h4>Specialist</h4>
            <h4><%= specialists.size()%></h4>
           
            
        </div>
    </div>
</main>

<%--Modal--%>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Add Specialist</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="AddSpecialistServlet" method="post">
                    <div class="form-group">
                        <label for="name">Enter specialist name</label>
                        <input type="text" name="name" required="true" class="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Add</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

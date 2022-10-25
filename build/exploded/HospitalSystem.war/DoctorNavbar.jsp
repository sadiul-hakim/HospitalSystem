<%-- 
    Document   : DoctorNavbar
    Created on : Oct 16, 2022, 3:26:00 PM
    Author     : Hakim
--%>


<header class="header">

    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="DoctorDashboard.jsp"> <i class="fa fa-home"></i> Hospital</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="DoctorDashboard.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="Patient.jsp">Patient</a>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0 mr-2">

                    <li class="nav-item"><i class="fa fa-user-circle-o"></i> <%= doctor.getName()%></li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="DoctorLogoutServlet">
                            <i class="fa fa-share-square-o"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>


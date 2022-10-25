<%-- 
    Document   : UserNavbar
    Created on : Oct 15, 2022, 10:52:38 AM
    Author     : Hakim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">

    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp"> <i class="fa fa-home"></i> Hospital</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user-circle-o"></i><%= user.getFullname()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="ChangeUserPassword.jsp">Change Password</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="UserLogoutServlet">Logout</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="UserAppointment.jsp"> Appointment</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="ViewAppointment.jsp"> View Appointment</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</header>



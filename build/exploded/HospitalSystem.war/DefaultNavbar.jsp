<%-- 
    Document   : Navbar
    Created on : Oct 13, 2022, 6:11:13 PM
    Author     : Hakim
--%>

<header class="header">

    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp"> <i class="fa fa-home"></i> Hospital</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="Admin_Login.jsp"> <i class="fa fa-sign-in"></i> Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="DoctorLogin.jsp"> Doctor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="UserLogin.jsp"> User</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<%-- 
    Document   : index
    Created on : Oct 13, 2022, 6:01:35 PM
    Author     : Hakim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.HospitalSystem.dao.user.User" %>
<%@page import="com.HospitalSystem.entity.SecurityContext" %>


<%
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
    User user=SecurityContext.getCurrentUser(request);
%>



<!DOCTYPE html>
<html>
    <%@include file="HeadTag.jsp" %>

    <body>
        <% if(isAuthenticated){ %>
        <%@include file="UserNavbar.jsp" %>

        <%}else{%>

        <%@include file="DefaultNavbar.jsp" %>

        <%}%>

        <%@include file="HomeCarousel.jsp" %>
        <%@include file="Features.jsp" %>

        <hr class="common-hr"/>

        <%@include file="Team.jsp" %>
        <%@include file="Footer.jsp" %>
    </body>

</html>
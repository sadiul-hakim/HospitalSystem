package com.HospitalSystem.servlet;

import com.HospitalSystem.dao.appointment.AppointmentService;
import com.HospitalSystem.dao.appointment.AppointmentServiceImp;
import com.HospitalSystem.entity.AuthErrorMessage;
import com.HospitalSystem.entity.Message;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "DoneAppointmentServlet", urlPatterns = {"/DoneAppointmentServlet"})
public class DoneAppointmentServlet extends HttpServlet {
    private final Message errorMessage=new AuthErrorMessage();
    private final AppointmentService service=new AppointmentServiceImp(errorMessage);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("Patient.jsp");
            
           int id=Integer.valueOf(request.getParameter("id"));
           boolean isDone=service.doneAppointment(id);
           
           if(isDone){
                out.println(
                        "<div class=\"alert alert-success mb-0\"> Appointment Done</div>"
                );
                dispatcher.include(request, response);
           }else{
               out.println(
                        "<div class=\"alert alert-danger mb-0\">Something went wrong.Try Again!</div>"
                );
                dispatcher.include(request, response);
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

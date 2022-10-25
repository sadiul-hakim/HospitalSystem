package com.HospitalSystem.servlet;

import com.HospitalSystem.dao.appointment.AppointmentDTO;
import com.HospitalSystem.dao.appointment.AppointmentService;
import com.HospitalSystem.dao.appointment.AppointmentServiceImp;
import com.HospitalSystem.entity.AppointmentStatus;
import com.HospitalSystem.entity.AuthErrorMessage;
import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.ValidationUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "AddUserAppointmentServlet", urlPatterns = {"/AddUserAppointmentServlet"})
public class AddUserAppointmentServlet extends HttpServlet {
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
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("UserAppointment.jsp");
            
           int user_id=Integer.valueOf(request.getParameter("id"));
           int doctor=Integer.valueOf(request.getParameter("doctor"));
           String fullname=request.getParameter("fullname");
           String gender=request.getParameter("gender");
           int age=Integer.valueOf(request.getParameter("age"));
           String date=request.getParameter("date");
           String email=request.getParameter("email");
           String phone=request.getParameter("phone");
           String desease=request.getParameter("desease");
           String address=request.getParameter("address");
           
           AppointmentDTO dto=convertToDTO(user_id, doctor,age, fullname, gender, date,  email, phone, desease, address);
           
            Map<String,String> errors=ValidationUtil.getINSTANCE().validate(dto);
            
            if(!errors.isEmpty()){
                request.setAttribute("errors", errors);
                dispatcher.forward(request, response);
            }
            
            boolean isAdded=service.add(dto);
            
            if(!isAdded){
                out.println(
                        "<div class=\"alert alert-danger mb-0\"> %s</div>".formatted(errorMessage.getMesssage().get())
                );
                dispatcher.include(request, response);
            }else{
                out.println(
                        "<div class=\"alert alert-success mb-0\"> Appointment Added successfully</div>"
                );
                dispatcher.include(request, response);
            }
        }
    }
    
    private AppointmentDTO convertToDTO(
            int user_id,
            int doctor,
            int age,
            String fullname,
            String gender,
            String date,
            String email,
            String phone,
            String desease,
            String address
    ){
        return new AppointmentDTO(user_id, doctor, fullname, age, email, phone, gender, date, desease, address,AppointmentStatus.PENDING);
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

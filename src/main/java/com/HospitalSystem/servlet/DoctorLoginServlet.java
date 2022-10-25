package com.HospitalSystem.servlet;

import com.HospitalSystem.dao.doctor.Doctor;
import com.HospitalSystem.dao.doctor.DoctorLoginDTO;
import com.HospitalSystem.dao.doctor.DoctorRepositoryImp;
import com.HospitalSystem.dao.doctor.DoctorService;
import com.HospitalSystem.dao.doctor.DoctorServiceImp;
import com.HospitalSystem.entity.AuthErrorMessage;
import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.SecurityContext;
import com.HospitalSystem.entity.Sha256Encryptor;
import com.HospitalSystem.entity.ValidationUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "DoctorLoginServlet", urlPatterns = {"/DoctorLoginServlet"})
public class DoctorLoginServlet extends HttpServlet {
    private final Message errorMessage=new AuthErrorMessage();
    private final DoctorService service=new DoctorServiceImp(
            new DoctorRepositoryImp(errorMessage),
            new Sha256Encryptor(),
            errorMessage
    );
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
            RequestDispatcher dispatcher=request.getRequestDispatcher("DoctorLogin.jsp");
           String email=request.getParameter("email");
           String password=request.getParameter("password");
           
           DoctorLoginDTO dto=convertToDTO(email, password);
           
            Map<String,String> errors=ValidationUtil.getINSTANCE().validate(dto);
            
            if(!errors.isEmpty()){
                request.setAttribute("errors", errors);
                dispatcher.forward(request, response);
            }
            
            Optional<Doctor> doctor=service.loginDoctor(dto);
            
            if(!doctor.isPresent()){
                 out.println(
                        "<div class=\"alert alert-danger mb-0\"> %s </div>".formatted(errorMessage.getMesssage().get())
                );
                dispatcher.include(request, response);
            }else{
                SecurityContext.doctorLogin(request, doctor.get());
                response.sendRedirect("DoctorDashboard.jsp");
            }
            
        }
    }
    
    private DoctorLoginDTO convertToDTO(String email,String password){
     return new  DoctorLoginDTO(email, password);
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

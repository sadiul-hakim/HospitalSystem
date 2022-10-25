package com.HospitalSystem.servlet;

import com.HospitalSystem.dao.doctor.DoctorDTO;
import com.HospitalSystem.dao.doctor.DoctorRepositoryImp;
import com.HospitalSystem.dao.doctor.DoctorService;
import com.HospitalSystem.dao.doctor.DoctorServiceImp;
import com.HospitalSystem.entity.AuthErrorMessage;
import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.Sha256Encryptor;
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
@WebServlet(name = "EditDoctorServlet", urlPatterns = {"/EditDoctorServlet"})
public class EditDoctorServlet extends HttpServlet {
     private final Message errorMessage = new AuthErrorMessage();
    private final DoctorService doctorService = new DoctorServiceImp(
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
           RequestDispatcher dispatcher=request.getRequestDispatcher("Doctor.jsp");
            
            int id=Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String qualifications = request.getParameter("qualifications");
            String specialist = request.getParameter("specialist");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            DoctorDTO dto=convertoToDTO(name, dob, qualifications, specialist, phone, email, password);
            
            Map<String,String> errors=ValidationUtil.getINSTANCE().validate(dto);
            
            if(!errors.isEmpty()){
                request.setAttribute("errors", errors);
                dispatcher.forward(request, response);
            }
            
            boolean isUpdated=doctorService.updateDoctor(id,dto);
            
            if(!isUpdated){
                out.println(
                        "<div class=\"alert alert-danger mb-0\"> %s </div>".formatted(errorMessage.getMesssage().get())
                );
                dispatcher.include(request, response);
            }else{
                out.println(
                        "<div class=\"alert alert-success mb-0\">Doctor Updated Successfully successfully</div>"
                );
                dispatcher.include(request, response);
            }
            
        }
    }
    
     private DoctorDTO convertoToDTO(
            String name,
            String dob,
            String qualifications,
            String specialist,
            String phone,
            String email,
            String password
    ) {
        return new DoctorDTO(name, dob, qualifications, specialist, phone, password, email);
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

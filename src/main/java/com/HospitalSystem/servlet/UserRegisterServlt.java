package com.HospitalSystem.servlet;

import com.HospitalSystem.dao.user.UserDTO;
import com.HospitalSystem.dao.user.UserRepositoryImp;
import com.HospitalSystem.dao.user.UserService;
import com.HospitalSystem.dao.user.UserServiceImp;
import com.HospitalSystem.entity.AuthErrorMessage;
import com.HospitalSystem.entity.Sha256Encryptor;
import com.HospitalSystem.entity.ValidationUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import com.HospitalSystem.entity.Message;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "UserRegisterServlt", urlPatterns = {"/UserRegisterServlt"})
public class UserRegisterServlt extends HttpServlet {
    private final Message errorMessage=new AuthErrorMessage();
    private final UserService userService=new UserServiceImp(
            new UserRepositoryImp(errorMessage),
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
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("UserRegister.jsp");
           
            String fullnane=request.getParameter("fullname");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
            UserDTO dto=convertToDto(fullnane, email, password);
            
            Map<String,String> errors=ValidationUtil.getINSTANCE().validate(dto);
            
            if(!errors.isEmpty()){
                request.setAttribute("errors", errors);
                dispatcher.forward(request, response);
            }
            
            boolean userSaved=userService.saveUser(dto);
            
            if(userSaved){
                response.sendRedirect("UserLogin.jsp");
            }else{
                out.println(
                        "<div class=\"alert alert-danger mb-0\"> %s </div>".formatted(errorMessage.getMesssage().get())
                );
                dispatcher.include(request, response);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private UserDTO convertToDto(String fullname,String email,String password){
        return new UserDTO(fullname, email, password);
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

package com.HospitalSystem.entity;

import com.HospitalSystem.dao.admin.Admin;
import com.HospitalSystem.dao.doctor.Doctor;
import com.HospitalSystem.dao.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Hakim
 */
public class SecurityContext {

    private static final String AUTHENTICATION_KEY = "auth.key";
    private static final String ADMIN_KEY = "admin.key";
    private static final String DOCTOR_KEY = "doctor.key";

    public static void login(HttpServletRequest request, User user) {
        HttpSession oldSession = request.getSession(false);
        
        
        if (oldSession != null) {
            oldSession.invalidate();
        }
          
        HttpSession session=request.getSession(true);
        session.setAttribute(AUTHENTICATION_KEY, user);
     
        
    }

    public static void adminLogin(HttpServletRequest request, Admin admin) {
       HttpSession oldSession = request.getSession(false);
        
        
        if (oldSession != null) {
            oldSession.invalidate();
        }
          
        HttpSession session=request.getSession(true);
        session.setAttribute(ADMIN_KEY, admin);
        
    }
    
    public static void doctorLogin(HttpServletRequest request, Doctor doctor) {
       HttpSession oldSession = request.getSession(false);
        
        
        if (oldSession != null) {
            oldSession.invalidate();
        }
          
        HttpSession session=request.getSession(true);
        session.setAttribute(DOCTOR_KEY, doctor);
        
    }

    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute(AUTHENTICATION_KEY);
       
    }
    
    public static void adminLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute(ADMIN_KEY);
       
    }
    
    public static void doctorLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute(DOCTOR_KEY);
       
    }

    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return (User) session.getAttribute(AUTHENTICATION_KEY);
    }
    
    public static Admin loggedAdmin(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        return (Admin) session.getAttribute(ADMIN_KEY);
    }
    
    public static Doctor loggedDoctor(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        return (Doctor) session.getAttribute(DOCTOR_KEY);
    }

    public static boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        return session.getAttribute(AUTHENTICATION_KEY) != null;
    }
    
    public static boolean adminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        return session.getAttribute(ADMIN_KEY) != null;
    }
    

}

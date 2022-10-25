package com.HospitalSystem.dao.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Hakim
 */
public class LoginDTO {
    @NotEmpty
    @Size(min=4,max=35)
    private String email;
    
    @NotEmpty
    @Size(min=8,max=16)
    private String password;  

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

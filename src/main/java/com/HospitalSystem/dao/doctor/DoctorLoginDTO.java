package com.HospitalSystem.dao.doctor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Hakim
 */
public class DoctorLoginDTO {
    
    @NotEmpty
    @Size(min=6,max=35)
    private String email;
    
    @NotEmpty
    @Size(min=6,max=16)
    private String password;

    public DoctorLoginDTO() {
    }

    public DoctorLoginDTO(String email, String password) {
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

    @Override
    public String toString() {
        return "DoctorLoginDTO{" + "email=" + email + ", password=" + password + '}';
    }
    
    
    
}

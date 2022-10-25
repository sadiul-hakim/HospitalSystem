package com.HospitalSystem.dao.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Hakim
 */

public class UserDTO {

    @NotEmpty
    @Size(min=4,max=30)
    private String fullname;
    
    @NotEmpty
    @Size(min=4,max=35)
    private String email;
    
    @NotEmpty
    @Size(min=4,max=16)
    private String password;

    public UserDTO(String fullname, String email, String password) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

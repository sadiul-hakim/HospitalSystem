package com.HospitalSystem.dao.doctor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Hakim
 */
public class DoctorDTO {

    @NotEmpty
    @Size(min=4,max=25)
    private String name;
    
    @NotEmpty
    private String dob;
    
    @NotEmpty
    private String qualifications;
    
    @NotEmpty
    private String specialist;
    
    @NotEmpty
    private String phone;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    @Size(min=8,max=16)
    private String password;

    public DoctorDTO(String name, String dob, String qualifications, String specialist, String phone, String password,String email) {
        this.name = name;
        this.dob = dob;
        this.qualifications = qualifications;
        this.specialist = specialist;
        this.phone = phone;
        this.password = password;
        this.email=email;
    }

    public DoctorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" + "name=" + name + ", dob=" + dob + ", qualifications=" + qualifications + ", specialist=" + specialist + ", phone=" + phone + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
}

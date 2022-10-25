package com.HospitalSystem.dao.doctor;

/**
 *
 * @author Hakim
 */
public class Doctor {
    private int id;
    private String name;
    private String dob;
    private String qualifications;
    private String specialist;
    private String phone;
    private String email;
    private String password;

    public Doctor() {
    }

    public Doctor(int id, String name, String dob, String qualifications, String specialist, String phone, String password,String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.qualifications = qualifications;
        this.specialist = specialist;
        this.phone = phone;
        this.password = password;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Doctor{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", qualifications=" + qualifications + ", specialist=" + specialist + ", phone=" + phone + ", email=" + email + ", password=" + password + '}';
    }

   
    
    
    
}

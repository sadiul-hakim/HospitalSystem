package com.HospitalSystem.dao.appointment;

import com.HospitalSystem.entity.AppointmentStatus;

/**
 *
 * @author Hakim
 */
public class Appointment {
    private int id;
    private int user_id;
    private int doctor;
    private String fullname;
    private int age;
    private String email;
    private String phone;
    private String gender;
    private String date;
    private String desease;
    private String address;
    private AppointmentStatus appointmentStatus;

    public Appointment() {
    }

    public Appointment(int id, int user_id, int doctor, String fullname, int age, String email, String phone, String gender, String date, String desease, String address,AppointmentStatus appointmentStatus) {
        this.id = id;
        this.user_id = user_id;
        this.doctor = doctor;
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.date = date;
        this.desease = desease;
        this.address = address;
        this.appointmentStatus=appointmentStatus;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesease() {
        return desease;
    }

    public void setDesease(String desease) {
        this.desease = desease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", user_id=" + user_id + ", doctor=" + doctor + ", fullname=" + fullname + ", age=" + age + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", date=" + date + ", desease=" + desease + ", address=" + address + ", appointmentStatus=" + appointmentStatus + '}';
    }

   
    
    
}

package com.HospitalSystem.dao.appointment;

import com.HospitalSystem.db.ConnectionPool;
import com.HospitalSystem.entity.AppointmentStatus;
import com.HospitalSystem.entity.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class AppointmentServiceImp implements AppointmentService {
    private final Message errorMessage;

    public AppointmentServiceImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public boolean add(AppointmentDTO dto) {
        boolean isAdded=false;
        try(Connection connecion=ConnectionPool.getConnection()){
            String query="insert into appointments(user_id,doctor,fullname,age,email,phone,gender,date,desease,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";
            
            try(PreparedStatement statement=connecion.prepareStatement(query)){
                statement.setInt(1, dto.getUser_id());
                statement.setInt(2, dto.getDoctor());
                statement.setString(3, dto.getFullname());
                statement.setInt(4, dto.getAge());
                statement.setString(5, dto.getEmail());
                statement.setString(6, dto.getPhone());
                statement.setString(7, dto.getGender());
                statement.setString(8, dto.getDate());
                statement.setString(9, dto.getDesease());
                statement.setString(10, dto.getAddress());
                statement.setString(11, dto.getAppointmentStatus().toString());
                
                statement.execute();
                isAdded=true;
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AppointmentServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not add Appointment.Please try Again.");
        }
        return isAdded;
    }

    @Override
    public boolean doneAppointment(int id) {
        boolean isDone=false;
        try(Connection connecion=ConnectionPool.getConnection()){
            String query="update appointments set status=? where id =?";
            
            try(PreparedStatement statement=connecion.prepareStatement(query)){
                statement.setString(1, AppointmentStatus.OK.toString());
                statement.setInt(2,id);
                
                statement.execute();
                isDone=true;
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AppointmentServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not make Appointment done.Please try Again.");
        }
        return isDone;
    }
    
}

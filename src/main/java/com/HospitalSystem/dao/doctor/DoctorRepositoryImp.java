package com.HospitalSystem.dao.doctor;

import com.HospitalSystem.dao.user.UserRepositoryImp;
import com.HospitalSystem.db.ConnectionPool;
import com.HospitalSystem.entity.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class DoctorRepositoryImp implements DoctorRepository {

    private final Message errorMessage;

    public DoctorRepositoryImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean add(DoctorDTO dto) {
        boolean isSaved = false;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "insert into doctors(name,dob,qualifications,specialist,phone,email,password) values (?,?,?,?,?,?,?)";

            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getDob());
                statement.setString(3, dto.getQualifications());
                statement.setString(4, dto.getSpecialist());
                statement.setString(5, dto.getPhone());
                statement.setString(6, dto.getEmail());
                statement.setString(7, dto.getPassword());

                statement.execute();
                isSaved = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Add Doctor.Please Try Again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSaved;
    }

    @Override
    public boolean update(int id, DoctorDTO dto) {
        boolean isSaved = false;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "update doctors set name=?,dob=?,qualifications=?,specialist=?,phone=?,email=?,password=? where id=?;";

            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getDob());
                statement.setString(3, dto.getQualifications());
                statement.setString(4, dto.getSpecialist());
                statement.setString(5, dto.getPhone());
                statement.setString(6, dto.getEmail());
                statement.setString(7, dto.getPassword());
                statement.setInt(8, id);

                statement.executeUpdate();
                isSaved = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Update Doctor.Please Try Again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSaved;
    }

    @Override
    public boolean delete(int id) {
        boolean isSaved = false;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "delete from doctors where id=?";

            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setInt(1, id);

                statement.execute();
                isSaved = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Delete Doctor.Please Try Again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSaved;
    }

    @Override
    public Optional<Doctor> login(DoctorLoginDTO dto) {
        Optional<Doctor> doctor = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "select * from doctors where email=?";

            try ( PreparedStatement statement = poll.prepareStatement(query)) {
                statement.setString(1, dto.getEmail());
                set = statement.executeQuery();

                if (set.next()) {
                    int id = set.getInt("id");
                    String name = set.getString("name");
                    String dob = set.getString("dob");
                    String qualifications = set.getString("qualifications");
                    String specialist = set.getString("specialist");
                    String phone = set.getString("phone");
                    String email = set.getString("email");
                    String password = set.getString("password");

                    if (!password.equals(dto.getPassword())) {
                        errorMessage.clear();
                        errorMessage.setMessage("Invalid Credentials!Please Try Again.");
                    }
                    
                    doctor=Optional.of(
                            new Doctor(id, name, dob, qualifications, specialist, phone, password, email)
                    );
                    
                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("Invalid Credentials!Please Try Again.");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Delete Doctor.Please Try Again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(set!=null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return doctor;

    }

}

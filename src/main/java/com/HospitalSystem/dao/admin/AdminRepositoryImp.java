package com.HospitalSystem.dao.admin;

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
public class AdminRepositoryImp implements AdminRepository {

    private final Message errorMessage;

    public AdminRepositoryImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }
    
        
    @Override
    public Optional<Admin> login(AdminDTO dto) {
        ResultSet set=null;
        Optional<Admin> admin=Optional.ofNullable(null);
        try(Connection connection=ConnectionPool.getConnection()){
            String query="select * from admin where email=?";
            
            try(PreparedStatement statement=connection.prepareStatement(query)){
                statement.setString(1, dto.getEmail());
                
                set=statement.executeQuery();
                
                if(set.next()){
                    String email=set.getString("email");
                    String fullname=set.getString("fullname");
                    String password=set.getString("password");
                    
                    if(!dto.getPassword().equals(password)){
                        errorMessage.clear();
                        errorMessage.setMessage("Invalid credentials.");
                        return admin;
                    }
                    
                    admin=Optional.of(new Admin(fullname,email,password));
                }else{
                    errorMessage.clear();
                    errorMessage.setMessage("Invalid credentials.");
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not login admin.Please try again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(set!=null){
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                    errorMessage.clear();
                    errorMessage.setMessage("Server error (Admin Login)");
                }
            }
        }
        
        return admin;
    }
    
}

package com.HospitalSystem.dao.specialist;

import com.HospitalSystem.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class SpecialistServiceImp implements SpecialistService {

    @Override
    public boolean add(String name) {
        boolean isAdded=false;
        String query="insert into specialists(name) values(?)";
        try(Connection connection=ConnectionPool.getConnection()){
            
            try(PreparedStatement statement=connection.prepareStatement(query)){
                statement.setString(1, name);
                
                statement.execute();
                isAdded=true;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isAdded;
    }

    
    
}

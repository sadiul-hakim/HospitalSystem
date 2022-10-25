package com.HospitalSystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hakim
 */
public class ConnectionPool {
//    private static final ConnectionPool INSTANCE=new ConnectionPool();
//
//    public ConnectionPool() {
//    }
//
//    public static ConnectionPool getINSTANCE() {
//        return INSTANCE;
//    }
//    
//    public DataSource getDataSource(){
//        var config=new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/hospitalsystem");
//        config.setUsername("Hakim");
//        config.setPassword("hakim@123");
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setMaximumPoolSize(25);
//        
//        return new HikariDataSource(config);
//    }
//    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","Hakim","hakim@123");
    }
   
}

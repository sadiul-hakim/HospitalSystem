package com.HospitalSystem.dao.user;

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
public class UserRepositoryImp implements UserRepository {

    private final Message errorMessage;

    public UserRepositoryImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean save(UserDTO user) {
        boolean isSaved = false;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "insert into users(fullname,email,password) values (?,?,?)";

            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setString(1, user.getFullname());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());

                statement.execute();
                isSaved = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Register User.Please Try Again!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSaved;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "select * from users where email=?";
            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setString(1, email);

                set = statement.executeQuery();

                if (set.next()) {
                    user = Optional.of(new User(
                            set.getInt("id"),
                            set.getString("fullname"),
                            set.getString("email"),
                            set.getString("password")));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not get User By This e-mail.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                    errorMessage.clear();
                    errorMessage.setMessage("Server error.(Result Set)");
                }
            }
        }

        return user;
    }

    @Override
    public Optional<User> loginUser(LoginDTO loginDto) {
        String query = "select * from users where email=?";
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;

        try ( Connection poll = ConnectionPool.getConnection()) {

            try ( PreparedStatement statement = poll.prepareStatement(query)) {
                statement.setString(1, loginDto.getEmail());

                set = statement.executeQuery();

                if (set.next()) {
                    int id = set.getInt("id");
                    String fullname = set.getString("fullname");
                    String email = set.getString("email");
                    String password = set.getString("password");

                    if (!password.equals(loginDto.getPassword())) {
                        errorMessage.clear();
                        errorMessage.setMessage("Invalid credentials.");
                        return user;
                    }

                    user = Optional.of(new User(id, fullname, email, password));
                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("Invalid credentials.");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not login User with this mail.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                    errorMessage.clear();
                    errorMessage.setMessage("Server error.(Result Set)");
                }
            }
        }

        return user;
    }

    @Override
    public boolean changePassword(int id, String old, String newPassword) {
        Optional<User> user = getUserById(id);
        boolean isChanged = false;

        if (!user.get().getPassword().equals(old)) {
            return isChanged;
        }

        try ( Connection poll = ConnectionPool.getConnection()) {
            String query = "update users set password=? where id=?";
            try ( PreparedStatement statement = poll.prepareStatement(query)) {
                statement.setString(1, newPassword);
                statement.setInt(2, id);
                
                statement.executeUpdate();
                
                isChanged=true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isChanged;

    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection poll = ConnectionPool.getConnection()) {

            String query = "select * from users where id=?";
            try ( PreparedStatement statement = poll.prepareStatement(query)) {

                statement.setInt(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    user = Optional.of(new User(
                            set.getInt("id"),
                            set.getString("fullname"),
                            set.getString("email"),
                            set.getString("password")));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not get User By This e-mail.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                    errorMessage.clear();
                    errorMessage.setMessage("Server error.(Result Set)");
                }
            }
        }

        return user;
    }

}

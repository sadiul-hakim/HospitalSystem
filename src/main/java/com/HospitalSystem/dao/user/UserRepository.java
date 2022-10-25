package com.HospitalSystem.dao.user;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface UserRepository {
    boolean save(UserDTO user);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(int id);
    Optional<User> loginUser(LoginDTO loginDto);
    boolean changePassword(int id,String old,String newpassword);
}

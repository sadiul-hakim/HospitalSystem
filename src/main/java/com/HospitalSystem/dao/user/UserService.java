package com.HospitalSystem.dao.user;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface UserService {
    boolean saveUser(UserDTO user);
    Optional<User> loginUser(LoginDTO loginDTO);
    boolean changePassword(int id,String old,String newPassword);
}

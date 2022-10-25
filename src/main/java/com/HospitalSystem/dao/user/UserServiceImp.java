package com.HospitalSystem.dao.user;

import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.PasswordEncryption;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncryption passwordEncryption;
    private final Message errorMessage;

    public UserServiceImp(UserRepository userRepository,PasswordEncryption passwordEncryption,Message errorMessage) {
        this.userRepository = userRepository;
        this.passwordEncryption=passwordEncryption;
        this.errorMessage=errorMessage;
    }
      
    
    @Override
    public boolean saveUser(UserDTO user) {
        
        Optional<User> u=userRepository.getUserByEmail(user.getEmail());
        
        if(u.isPresent()){
            errorMessage.clear();
            errorMessage.setMessage("User already exists with this e-mail.");
            return false;
        }
        
        String password=user.getPassword();
        String newPassword=passwordEncryption.encrypt(password);
        
        user.setPassword(newPassword);
        
        return userRepository.save(user);
    }

    @Override
    public Optional<User> loginUser(LoginDTO loginDTO) {
        String password=loginDTO.getPassword();
        loginDTO.setPassword(passwordEncryption.encrypt(password));
        
        return userRepository.loginUser(loginDTO);
    }

    @Override
    public boolean changePassword(int id, String old, String newPassword) {
        old=passwordEncryption.encrypt(old);
        newPassword=passwordEncryption.encrypt(newPassword);
        
        return userRepository.changePassword(id, old, newPassword);
    }   
    
}

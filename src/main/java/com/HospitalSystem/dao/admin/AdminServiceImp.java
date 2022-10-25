package com.HospitalSystem.dao.admin;

import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.PasswordEncryption;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class AdminServiceImp implements AdminService{
    private final AdminRepository adminRepository;
    private final PasswordEncryption passwordEncryption;
    private final Message errorMessage;

    public AdminServiceImp(AdminRepository adminRepository, PasswordEncryption passwordEncryption, Message errorMessage) {
        this.adminRepository = adminRepository;
        this.passwordEncryption = passwordEncryption;
        this.errorMessage = errorMessage;
    }
    
    @Override
    public Optional<Admin> loginAdmin(AdminDTO dto) {
        String password=dto.getPassword();
        password=passwordEncryption.encrypt(password);
        
        dto.setPassword(password);
        
        return adminRepository.login(dto);
    }
    
}

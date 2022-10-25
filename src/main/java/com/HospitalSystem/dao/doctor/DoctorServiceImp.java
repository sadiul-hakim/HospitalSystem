package com.HospitalSystem.dao.doctor;

import com.HospitalSystem.entity.Message;
import com.HospitalSystem.entity.PasswordEncryption;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncryption passwordEncryption;
    private final Message errorMessage;

    public DoctorServiceImp(DoctorRepository doctorRepository, PasswordEncryption passwordEncryption, Message errorMessage) {
        this.doctorRepository = doctorRepository;
        this.passwordEncryption = passwordEncryption;
        this.errorMessage = errorMessage;
    }
    
    
    
    @Override
    public boolean addDoctor(DoctorDTO dto) {
        String password=dto.getPassword();
        String newPassword=passwordEncryption.encrypt(password);
        
        dto.setPassword(newPassword);
        
        return doctorRepository.add(dto);
    }

    @Override
    public boolean updateDoctor(int id, DoctorDTO dto) {
         String password=dto.getPassword();
        String newPassword=passwordEncryption.encrypt(password);
        
        dto.setPassword(newPassword);
        
        return doctorRepository.update(id, dto);
    }

    @Override
    public boolean deleteDoctor(int id) {
        return doctorRepository.delete(id);
    }

    @Override
    public Optional<Doctor> loginDoctor(DoctorLoginDTO dto) {
        String password=dto.getPassword();
        password=passwordEncryption.encrypt(password);
        
        dto.setPassword(password);
        
        return doctorRepository.login(dto);
    }

   
    
}

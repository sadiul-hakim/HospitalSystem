package com.HospitalSystem.dao.doctor;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface DoctorService {
    boolean addDoctor(DoctorDTO dto);
    boolean updateDoctor(int id,DoctorDTO dto);
    boolean deleteDoctor(int id);
    Optional<Doctor> loginDoctor(DoctorLoginDTO dto);
}

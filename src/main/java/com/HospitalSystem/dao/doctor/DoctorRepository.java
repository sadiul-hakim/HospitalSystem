package com.HospitalSystem.dao.doctor;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface DoctorRepository {
    boolean add(DoctorDTO dto);
    boolean update(int id,DoctorDTO dto);
    boolean delete(int id);
    Optional<Doctor> login(DoctorLoginDTO dto);
}

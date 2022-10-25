package com.HospitalSystem.dao.admin;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface AdminRepository {
    Optional<Admin> login(AdminDTO dto);
}

package com.HospitalSystem.dao.admin;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface AdminService {
    Optional<Admin> loginAdmin(AdminDTO dto);
}

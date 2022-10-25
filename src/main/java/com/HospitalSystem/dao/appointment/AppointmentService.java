package com.HospitalSystem.dao.appointment;

/**
 *
 * @author Hakim
 */
public interface AppointmentService {
    boolean add(AppointmentDTO dto);
    boolean doneAppointment(int id);
}

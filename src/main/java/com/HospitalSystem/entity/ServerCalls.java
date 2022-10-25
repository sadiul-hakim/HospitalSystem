package com.HospitalSystem.entity;

import com.HospitalSystem.dao.appointment.Appointment;
import com.HospitalSystem.dao.doctor.Doctor;
import com.HospitalSystem.dao.specialist.Specialist;
import com.HospitalSystem.dao.specialist.SpecialistServiceImp;
import com.HospitalSystem.dao.user.User;
import com.HospitalSystem.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class ServerCalls {

    public static List<Doctor> allDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "select * from doctors";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {
                    doctors.add(
                            new Doctor(
                                    set.getInt("id"),
                                    set.getString("name"),
                                    set.getString("dob"),
                                    set.getString("qualifications"),
                                    set.getString("specialist"),
                                    set.getString("phone"),
                                    set.getString("password"),
                                    set.getString("email")
                            )
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return doctors;
    }
    public static List<User> allUsers() {
        List<User> users = new ArrayList<>();
        String query = "select * from users";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {
                    users.add(
                            new User(
                            set.getInt("id"),
                            set.getString("fullname"),
                            set.getString("email"),
                            set.getString("password"))
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return users;
    }

    public static List<Appointment> allAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "select * from appointments";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {
                    appointments.add(
                            new Appointment(
                                    set.getInt("id"),
                                    set.getInt("user_id"),
                                    set.getInt("doctor"),
                                    set.getString("fullname"),
                                    set.getInt("age"),
                                    set.getString("email"),
                                    set.getString("phone"),
                                    set.getString("gender"),
                                    set.getString("date"),
                                    set.getString("desease"),
                                    set.getString("address"),
                                    AppointmentStatus.valueOf(set.getString("status"))
                            )
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return appointments;
    }

    public static List<Appointment> appointmentRelatedToAUser(int user_id) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "select * from appointments where user_id=?";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, user_id);
                set = statement.executeQuery();

                while (set.next()) {
                    appointments.add(
                            new Appointment(
                                    set.getInt("id"),
                                    set.getInt("user_id"),
                                    set.getInt("doctor"),
                                    set.getString("fullname"),
                                    set.getInt("age"),
                                    set.getString("email"),
                                    set.getString("phone"),
                                    set.getString("gender"),
                                    set.getString("date"),
                                    set.getString("desease"),
                                    set.getString("address"),
                                    AppointmentStatus.valueOf(set.getString("status"))
                            )
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return appointments;
    }

    public static List<Appointment> appointmentRelatedToADoctor(int doctor) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "select * from appointments where doctor=?";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, doctor);
                set = statement.executeQuery();

                while (set.next()) {
                    appointments.add(
                            new Appointment(
                                    set.getInt("id"),
                                    set.getInt("user_id"),
                                    set.getInt("doctor"),
                                    set.getString("fullname"),
                                    set.getInt("age"),
                                    set.getString("email"),
                                    set.getString("phone"),
                                    set.getString("gender"),
                                    set.getString("date"),
                                    set.getString("desease"),
                                    set.getString("address"),
                                    AppointmentStatus.valueOf(set.getString("status"))
                            )
                    );
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return appointments;
    }

    public static List<Specialist> getAllSpecialists() {
        List<Specialist> specialists = new ArrayList<>();
        String query = "select * from specialists";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {
                    specialists.add(new Specialist(
                            set.getInt("id"),
                            set.getString("name")
                    ));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return specialists;

    }

    public static Doctor getDoctor(int id) {
        Doctor doctor = new Doctor();
        String query = "select * from doctors where id=?";
        ResultSet set = null;
        try ( Connection connection = ConnectionPool.getConnection()) {

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, id);
                set = statement.executeQuery();
                if (set.next()) {
                    System.out.println(set.getInt("id") + "id from server");
                    doctor = new Doctor(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("dob"),
                            set.getString("qualifications"),
                            set.getString("specialist"),
                            set.getString("phone"),
                            set.getString("password"),
                            set.getString("email")
                    );

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCalls.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SpecialistServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return doctor;
    }
}

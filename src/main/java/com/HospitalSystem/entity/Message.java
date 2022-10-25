package com.HospitalSystem.entity;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface Message {
    Optional<String> getMesssage();
    void setMessage(String msg);
    void clear();
}

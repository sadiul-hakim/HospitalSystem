package com.HospitalSystem.dao.specialist;

/**
 *
 * @author Hakim
 */
public class Specialist {
    private int id;
    private String name;

    public Specialist() {
    }

    public Specialist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialist{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}

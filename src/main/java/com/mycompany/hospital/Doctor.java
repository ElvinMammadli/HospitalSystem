/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

/**
 *
 * @author khagani
 */
public class Doctor {
    private int id;
    private String name;
    private String surname;
    private String personal_id;
    private int clinic_id;

    protected Doctor(int clinic_id) {
        this.clinic_id = clinic_id;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    protected String getPersonal_id() {
        return personal_id;
    }

    protected void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    protected int getClinic_id() {
        return clinic_id;
    }
    
    
}

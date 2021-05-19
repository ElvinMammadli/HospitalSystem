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
public class Patient {
    private String passport_id;
    private String name;
    private String surname;
    private float discount;

    protected Patient(String passport_id) {
        this.passport_id = passport_id;
    }

    Patient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    protected float getDiscount() {
        return discount;
    }

    protected String getPassport_id() {
        return passport_id;
    }

    protected void setDiscount(float discount) {
        this.discount = discount;
    }
    
}

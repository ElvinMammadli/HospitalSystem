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
public class User {
    private String name;
    private String surname;
    private int passport_id;
    private int clinc_id;
    private int type;
    private String password;

    protected User(int passport_id, String password) {
        this.passport_id = passport_id;
        this.password = password;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setType(int type) {
        this.type = type;
    }

    protected String getsurname() {
        return surname;
    }

    protected void setsurname(String surname) {
        this.surname = surname;
    }

    protected int getClinc_id() {
        return clinc_id;
    }

    protected void setClinc_id(int clinc_id) {
        this.clinc_id = clinc_id;
    }

    protected String getName() {
        return name;
    }

    protected int getPassport_id() {
        return passport_id;
    }

    protected int getType() {
        return type;
    }

    protected String getPassword() {
        return password;
    }
    
}

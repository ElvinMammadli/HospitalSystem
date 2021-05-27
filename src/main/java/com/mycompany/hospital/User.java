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
public class User{
    private String name;
    private String Personal_id;
    private int type;
    private String password;
    protected ConnectionSQL connectionSQL= new ConnectionSQL();
    protected User(String Personal_id, String password) {
        this.Personal_id = Personal_id;
        this.password = password;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setType(int type) {
        this.type = type;
    }

    protected String getName() {
        return name;
    }

    protected String getPersonal_id() {
        return Personal_id;
    }

    protected int getType() {
        return type;
    }

    protected String getPassword() {
        return password;
    }

    
}

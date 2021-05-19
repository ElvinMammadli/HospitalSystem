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
public class Clinic {
    private int id;
    private String name;

    protected Clinic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected int getId() {
        return id;
    }

    protected String getName() {
        return name;
    }
    
}

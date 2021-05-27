/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khagani
 */
public class Registration_employee extends User {

    public Registration_employee(String Personal_id, String password) {
        super(Personal_id, password);
    }
    protected int registerpatient(Patient patient){
        int status=0;
        try {
            status=connectionSQL.registerpatient(patient);
        } catch (SQLException ex) {
            Logger.getLogger(Registration_employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    protected int deletePatient(String Patient){
        int status=0;
        try {
            status=connectionSQL.deletePatient(Patient);
        } catch (SQLException ex) {
            Logger.getLogger(Registration_employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status; 
    }
    
}

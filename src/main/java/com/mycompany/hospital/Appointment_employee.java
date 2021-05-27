/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khagani
 */
public class Appointment_employee extends User {

    public Appointment_employee(String Personal_id, String password) {
        super(Personal_id, password);
    }
    protected Patient checkpatientregistration(Patient patient){
        try{
            patient=connectionSQL.checkpatientregistration(patient);
        }catch(Exception e){
            System.err.println(e);
        }
        return patient;
    }
    protected ArrayList<String> getTime(String yy,String mm,String dd,Doctor doctor){
        ArrayList<String> time=null;
        try {
            time=connectionSQL.getTime(yy, mm, dd, doctor);
        } catch (SQLException e) {
            System.out.println(e);
        }
    return time;
    }
    protected int setAppointment(Doctor doctor,Patient patient,String date,String time){
        int status=0;
        try {
            status=connectionSQL.setAppointment(doctor, patient, date, time);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}

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
public class Appointment {
    private String patient_namesurname;
    private String date;
    private String time;
    private String doctor_namesurname;
    private String clinic_name;

    public Appointment(String patient_namesurname, String date, String time,String doctor_namesurname, String clinic_name) {
        this.patient_namesurname = patient_namesurname;
        this.date = date;
        this.time=time;
        this.doctor_namesurname = doctor_namesurname;
        this.clinic_name = clinic_name;
    }

    public String getPatient_namesurname() {
        return patient_namesurname;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getDoctor_namesurname() {
        return doctor_namesurname;
    }

    public String getClinic_name() {
        return clinic_name;
    }
    
}

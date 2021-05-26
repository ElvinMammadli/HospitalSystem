/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author khagani
 */
public class Startpage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
  ConnectionSQL connectionSQL = new ConnectionSQL();
        ArrayList<Doctor> doctor_array = new ArrayList<>();
        Doctor doctor = new Doctor(3);
        //doctor_array=connectionSQL.getdoctors(doctor);
       // for(int i=0; i< doctor_array.size(); i++)
       //    System.out.println(doctor_array.get(i).getId()+" "+doctor_array.get(i).getName()+" "+doctor_array.get(i).getSurname()+" "+doctor_array.get(i).getPersonal_id()+" ");
        /*ArrayList<Clinic> clinic_array = new ArrayList<>();
        clinic_array=connectionSQl.getclinic();
        System.out.println(clinic_array.size());
        for(int i=0; i<clinic_array.size(); i++)
            System.out.println(clinic_array.get(i).getId()+" "+clinic_array.get(i).getName());
        @param args the command line arguments
        
       /* Patient patient = new Patient("99656550969");
        
        patient=connectionSQl.checkpatientregistration(patient);
        if(patient.getName().matches("Null")){
            patient.setName("Elvin");
            patient.setSurname("Mammadli");
            int status =connectionSQl.registerpatient(patient);
            System.out.println("status"+status);
        }
        System.out.println(patient.getPassport_id()+" "+patient.getName()+" "+ patient.getSurname());
        /* User user = new User(123,"A");
        
        user=connectionSQl.login(user);
        System.out.println(user.getType());
        if(user.getType()==0)
            System.out.println("yanlis sifre girdiniz");
        else if (user.getType()==-1)
            System.out.println("yanlis passport girdiniz");
        else if(user.getType()==-2)
            System.out.println("error");    */   
    }

     
    
       
    
    
}



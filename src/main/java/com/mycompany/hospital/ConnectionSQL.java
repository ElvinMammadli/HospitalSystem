
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author khagani
 */
public class ConnectionSQL {
    private static Connection con;
    private Statement  stmt;
    private ResultSet  rs;   
    private static final String url="jdbc:sqlserver://localhost:1433;databaseName=Sifapoliklinigi_db;user=root;password=Eldeyme01";

    
    protected static void connect() throws SQLException{
        try {
            con = DriverManager.getConnection(url);
            System.out.print("Connected\n");
        }catch (SQLException e){
            System.err.print(e);     
        }
    }
    protected static void disconnect(){
        con=null;
        System.out.print("disconnect");
    }
    protected User login(User user) throws SQLException{
        connect();
        stmt=con.createStatement();
        rs=stmt.executeQuery("SELECT Password,Type FROM dbo.user_T where Personal_id=" +user.getPassport_id());
        if(rs.next()){
            if(user.getPassword().compareTo(rs.getString("Password"))==0){
                switch(rs.getInt("Type")){
                    case 3:
                        rs=stmt.executeQuery("select * from dbo.doctor_T where Personal_id="+user.getPassport_id());
                        if(rs.next()){
                            user.setName(rs.getString("Name"));
                            user.setsurname(rs.getString("Surname"));
                            user.setClinc_id(rs.getInt("Clinic_id"));
                            user.setType(3);
                        }
                        else
                            user.setType(-2);
                        
                        break;
                    case 2:
                        user.setName("Randevu gorevlisi");
                        user.setType(2);
                        break;
                    case 1:
                        user.setName("Kayit gorevlisi");
                        user.setType(1);
                        break;
                }
            }
            else
                user.setType(0);
        }
        else
            user.setType(-1);
        disconnect();
        return user;
    }
    protected Patient checkpatientregistration(Patient patient) throws SQLException{
        connect();
        stmt=con.createStatement();
        try{
            rs=stmt.executeQuery("Select * from dbo.patient_T where Personal_id='"+patient.getPassport_id()+"'");
            if(rs.next()){
                System.out.print(rs.getString("Name"));
                patient.setName(rs.getString("Name"));
                patient.setSurname(rs.getString("Surname"));
            }
            else
                patient.setName("Null");
        }catch(Exception e){
        System.out.println(e);
        }
        disconnect();
     return patient;
    }
    protected int registerpatient(Patient patient) throws SQLException{
        connect();
        int status=0;
        stmt=con.createStatement();
        try{
        status=stmt.executeUpdate("insert into patient_T (Personal_id,Name,Surname) values('"+patient.getPassport_id()+"','"+patient.getName()+"','"+patient.getSurname()+"')");

        }catch(Exception e){
            System.out.print(e);
        }
        disconnect();
        return status;
    }
    protected ArrayList<Clinic> getclinic()throws SQLException{
        ArrayList<Clinic> clinic_array= new ArrayList<>();
        connect();
        stmt=con.createStatement();
        rs=stmt.executeQuery("Select * from clinic_T");
        while(rs.next()){
            Clinic tmp_clinic=new Clinic(rs.getInt("Id"), rs.getString("Name"));
            clinic_array.add(tmp_clinic);
            
        
        }
        disconnect();
        return clinic_array;
    }
    protected ArrayList<Doctor> getdoctors(Doctor doctor) throws SQLException{
        connect();
        stmt=con.createStatement();
        ArrayList<Doctor> doctors_array = new ArrayList<>();
        rs=stmt.executeQuery("select * from doctor_t where Clinic_id="+doctor.getClinic_id());
        while(rs.next()){
            Doctor tmp_doctor= new Doctor(doctor.getClinic_id());
            tmp_doctor.setName(rs.getString("Name"));
            tmp_doctor.setId(rs.getInt("Id"));
            tmp_doctor.setSurname(rs.getString("Surname"));
            tmp_doctor.setPersonal_id(rs.getString("Personal_id"));
            doctors_array.add(tmp_doctor);
        }
        disconnect();
        return doctors_array;
    }
    protected int setAppointment(Doctor doctor,User user){
    
    
    
    return 1;
    
    }
}

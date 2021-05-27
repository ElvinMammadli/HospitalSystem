
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
import java.util.Date;

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
            System.out.println("Connected to Database\n");
        }catch (SQLException e){
            System.err.print(e);     
        }
    }
    protected static void disconnect(){
        con=null;
        System.out.println("Disconnect from Database");
    }
    protected User login(User user) throws SQLException{
        connect();
        stmt=con.createStatement();
        rs=stmt.executeQuery("SELECT Password,Type FROM dbo.user_T where Personal_id=" +user.getPersonal_id());
        if(rs.next()){
            if(user.getPassword().compareTo(rs.getString("Password"))==0){
                switch(rs.getInt("Type")){
                    case 1:
                        user.setName("Randevu gorevlisi");
                        user.setType(1);
                        break;
                    case 2:
                        user.setName("Kayit gorevlisi");
                        user.setType(2);
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
    protected ArrayList<Doctor> getdoctors(Clinic clinic) throws SQLException{
        connect();
        stmt=con.createStatement();
        ArrayList<Doctor> doctors_array = new ArrayList<>();
        rs=stmt.executeQuery("select * from doctor_t where Clinic_id="+clinic.getId());
        while(rs.next()){
            Doctor tmp_doctor= new Doctor(clinic.getId());
            tmp_doctor.setName(rs.getString("Name"));
            tmp_doctor.setId(rs.getInt("Id"));
            tmp_doctor.setSurname(rs.getString("Surname"));
            tmp_doctor.setPersonal_id(rs.getString("Personal_id"));
            doctors_array.add(tmp_doctor);
        }
        disconnect();
        return doctors_array;
    }
    protected ArrayList<Patient> getpatient()throws SQLException{
        connect();
        ArrayList<Patient> patient_array= new ArrayList<>();
        
        stmt=con.createStatement();
        try{
           rs=stmt.executeQuery("Select * from dbo.patient_T");
           while(rs.next()){
               Patient patient = new Patient(rs.getString("Personal_id"));
               patient.setName(rs.getString("Name"));
               patient.setSurname(rs.getString("Surname"));
               patient_array.add(patient);
           }
        }catch(Exception e){
        System.out.print(e);
        }
        disconnect();
        return patient_array;
    }
    protected int deletePatient(String personal_id) throws SQLException{
        connect();
        stmt=con.createStatement();
        int status=stmt.executeUpdate("Delete from dbo.patient_T where Personal_id="+personal_id);
        disconnect();
        return status;
    
    
    }
    protected ArrayList<String> getTime(String yy,String mm,String dd,Doctor doctor) throws SQLException{
        ArrayList<String> time = new ArrayList<>();
        connect();
        stmt=con.createStatement();
        try{
            rs=stmt.executeQuery("select cast(Time as nvarchar(5)) as Time from dbo.appointment_T where (DATEPART(yy, Date) ='"+yy+"' AND DATEPART(mm, Date) ='"+mm+"' AND    DATEPART(dd, Date) = '"+dd+"') AND Doctor_id="+doctor.getId());
            while(rs.next()){
                System.out.println("test");
                time.add(rs.getString("Time"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return time; 
    }
    protected int setAppointment( Doctor doctor,Patient patient,String date,String time) throws SQLException{
        int status=0;
        connect();
        stmt=con.createStatement();
        status=stmt.executeUpdate("insert into appointment_T  values(Convert(Date,'"+date+"',0),cast('"+time+"' as Time),'"+patient.getPassport_id()+"',"+doctor.getId()+")");
        disconnect();
        return status;
    }
    protected ArrayList<Appointment> getappointments() throws SQLException{
        connect();
        ArrayList<Appointment> appointment_array = new ArrayList<>();
        stmt=con.createStatement();
        try{
        rs=stmt.executeQuery("Select p.Name,p.Surname,Date ,cast(Time as nvarchar(5)) as Time ,d.Name,d.Surname ,c.name from  dbo.appointment_T a, dbo.patient_T p,dbo.doctor_T d,clinic_T c where a.Patient_id=p.Personal_id and a.Doctor_id=d.Id and d.Clinic_id=c.Id");
        while(rs.next()){
            String patient=rs.getString(1)+" "+rs.getString(2);
            String doctor=rs.getString(5)+" "+rs.getString(6);
            Appointment appointment =new Appointment(patient,rs.getString("Date") ,rs.getString("Time") ,doctor, rs.getString("name"));
            appointment_array.add(appointment);
        }
        }catch (Exception e){
            System.out.println(e);
        }
        disconnect();
        return appointment_array;
    }
}

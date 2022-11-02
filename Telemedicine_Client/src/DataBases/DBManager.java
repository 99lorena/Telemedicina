/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import Client.*;
import java.io.IOException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class DBManager implements DBManagerInterface{
    
    private Connection c;
    private PatientManager patient;
    private UserManager user;
    
    
    public DBManager() {
        super();
    }
    
     //PARA ABRIR LA CONEXION
    @Override
        public void connect() {
        try {
            String url = "jdbc:sqlite:lib/db.db";
            c = DriverManager.getConnection(url);

            c.createStatement().execute("PRAGMA foreign_keys=ON");

            patient = new PatientManager(c);
            user = new UserManager(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    
    public void setC(Connection c) {
        this.c = c;
    }
    
    //PARA DESCONECTARSE
    @Override
    public void disconnect() {
        try {
            // Close database connection
            c.close();
            // System.out.println("Database connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void Tables(){
        try{
            System.out.println("Database connection opened.");
            connect(); //para abrir la conexion
            
            
            //----- TABLA DE USUARIOS
            Statement stmt1 = c.createStatement();
            String sql1 = "CREATE TABLE Users "
                    + "(patient_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "PATIENT_DNI TEXT,"
                    + "PASSWORD TEXT)";

            stmt1.executeUpdate(sql1);
            stmt1.close();
            //---------------------
            
            //----TABLA DE PACIENTES
            Statement stmt2 = c.createStatement();
            String sql2 = "CREATE TABLE Patients "
                    + " (patient_id	INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NAME TEXT,"
                    + "SURNAME TEXT,"
                    + "DNI TEXT,"
                    + "TELEPHONE TEXT,"
                    + "DOB DATE,"
                    + "GENDER TEXT,";
                   

            stmt2.executeUpdate(sql2);
            stmt2.close();
           //----------------------------------------
            
           System.out.println("Tables created.");
           
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public UserManager getUserManager() {
        return user;
    }

  
    @Override
    public PatientManagerInterface getPatientManager() {
        return patient;
    }
}

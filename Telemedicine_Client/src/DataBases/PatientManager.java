/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Client.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.*;
import java.util.*;
import DataBases.PatientManagerInterface;

/**
 *
 * @author Usuario
 */
public class PatientManager implements PatientManagerInterface {
    
        private Connection c;
	
	public PatientManager(Connection connection) {
		this.c=connection;
	}

        
        @Override
        public void addpatientbyRegister(Patient pat) {
            try {

                String sql = "INSERT INTO Patients (name, surname, dni, telephone, dob, gender)"
                                + " VALUES (?,?,?,?,?,?,?)";
                PreparedStatement prep = c.prepareStatement(sql);
                prep.setString(1, pat.getName());
                prep.setString(2, pat.getSurname());
                prep.setString(3, pat.getDni());
                prep.setString(4, pat.getTelephone());
                prep.setDate(5, (java.sql.Date) pat.getDob());
                prep.setString(6, pat.getGender());
                prep.executeUpdate();
                prep.close();
                }
            catch(Exception e) {
                e.printStackTrace();
            }
    }
}

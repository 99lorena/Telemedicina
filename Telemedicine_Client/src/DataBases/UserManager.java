/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Client.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DataBases.UserManagerInterface;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UserManager implements UserManagerInterface {
    
        private static final String URL = "jdbc:sqlite:lib/db.db";
        private Connection c;
	
        
        public UserManager(Connection con){
            this.c=con;
        }
        
        
        @Override
        public void connect() {
            try {
                c = DriverManager.getConnection(URL);
                c.createStatement().execute("PRAGMA foreign_keys=ON");

            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
        public void createUserRegister(User newuser){
           try{
                String sql = "INSERT INTO Users (patient_dni, password) VALUES (?,?)";
                PreparedStatement prep = c.prepareStatement(sql);
                prep.setString(1, newuser.getUser());
                prep.setString(2, newuser.getPassword());
                prep.executeUpdate();
                prep.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

}

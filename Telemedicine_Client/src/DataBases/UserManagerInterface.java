/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import Client.*;

/**
 *
 * @author Usuario
 */
public interface UserManagerInterface {
    
        public void connect();

        public void disconnect();
        
        public void createUserRegister(User newuser);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

/**
 *
 * @author Usuario
 */
public interface DBManagerInterface {
        public void connect();
	public void disconnect();
	public void Tables();
        public UserManager getUserManager();
	public PatientManagerInterface getPatientManager();
}

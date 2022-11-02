/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class Patient implements Serializable{
    
    Integer id;
    String name;
    String surname;
    String dni;
    String telephone;
    Date dob;
    String gender;

    public Patient() {
        super();
    }

    
    public Patient(Integer id, String name, String surname, String dni, String telephone, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.telephone = telephone;
        this.dob = dob;
        this.gender = gender;
    }

    public Patient(String name, String surname, String dni, String telephone, Date dob, String gender) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.telephone = telephone;
        this.dob = dob;
        this.gender = gender;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.surname);
        hash = 71 * hash + Objects.hashCode(this.dni);
        hash = 71 * hash + Objects.hashCode(this.telephone);
        hash = 71 * hash + Objects.hashCode(this.dob);
        hash = 71 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", telephone=" + telephone + ", dob=" + dob + ", gender=" + gender + '}';
    }

   

   

    
    
    
        
}

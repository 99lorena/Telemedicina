/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.Scanner;
import Client.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import DataBases.*;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class Menu {
    
    public static String ipAddress;
    private static BufferedReader br;
    private static InetAddress ip;
    private static boolean registrado;
    private static boolean v1;
    
   //variables de bases de datos
    private Connection c;
    private static UserManagerInterface umi;
    private static PatientManagerInterface pmi;
    private  PatientManager pm;
    private static DataBases.DBManagerInterface dbman;
    
    public static void main (String args[]) throws IOException, ParseException, Exception{
        dbman = new DBManager();
        dbman.connect();
        //dbman.Tables();
        pmi = dbman.getPatientManager();
        umi=dbman.getUserManager();
        umi.connect();
        
        
        int num;
        registrado= false;
        v1=false;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in); //para leer tipo escaner
        
        System.out.println("---------- WELCOME TO EPILEPSY CONTROL -----------\n");
        System.out.println("Please introduce the ip you are connected\n");
        ipAddress=sc.next(); //lee la entrada del usuario hasta que se encuentre un espacio
        ip=InetAddress.getByName(ipAddress); //transformamos la ip tipo string en una tipo address, 
        //significado en el javadoc: Determines the IP address of a host, given the host's name.
        
        while (true){
          System.out.println("What do you want to do?\n");
            System.out.println("0. Exit \n");
            System.out.println("1. Sing in");
            System.out.println("2. Log in");
            num=2;
          int numero = Integer.parseInt(br.readLine());
          
          //PARA COMPROBAR QUE INTRODUCE UNA DE LAS OPCIONES CORRECTAS
          while(numero>2 || numero<0){
              System.out.println("Incorret opción, please insert it again \n");
              numero= Integer.parseInt(br.readLine());
            } 
          
          if(registrado){//si registrado pasa a ser true, se mete aquí
              System.out.println("What do you want to do?");
              System.out.println("3. Log out");
              System.out.println("4. Record your EEG");
              System.out.println("5. Connection with the server");
              num=5;
              
          numero = Integer.parseInt(br.readLine());
          //PARA COMPROBAR QUE INTRODUCE UNA DE LAS OPCIONES CORRECTAS
          while(numero>5 || numero<3){
              System.out.println("Incorret opción, please insert it again \n");
              numero= Integer.parseInt(br.readLine());
            } 
          }
          
          v1=true;
          while(v1){
              switch(numero){
                  case 0: //Exit
                        v1=false;
                        registrado=false;
                        System.exit(0);
                      break;
                  case 1: //Sign in
                       if(registrado) { //si ya se ha registrado
                            System.out.println("You are already logged");
                            break;
                        }
                        Register(); //para registrarse
                        break;
            
                  case 2: //Log in
                       if(registrado) { //si ya se ha registrado
                            System.out.println("You are already logged");
                            break;
                        }
                       //login();
                      break;
                  case 3:
                      break;
                  case 4:
                      break;
                  case 5:
                      break;
                     
                      
                      
                      
              }
                   
          }
          
          
          
          
          
         
        }
        
    }
    
    
    //FUNCIONES USADAS EN EL MENU
    
    //Para registrarse 
    public static void Register() throws IOException, ParseException{
        try{
            Patient p= null;
            
            //----NOMBRE
            System.out.println("Type your name: "); //añadimos el nombre
            String name = br.readLine();
            
            //----APELLIDO
            System.out.println("Type your surname: "); //añadimos el apellido
            String surname = br.readLine();
            
            //----DNI
            System.out.println("Type your dni (only numeric, 8 numbers)"); //añadimos el dni
            String dni= br.readLine();
             while(dni.length() != 8){
                System.out.println("Incorrect dni number, please inserted again");
                dni= br.readLine(); 
            }
             
            //-----TELEFONO
            System.out.println("Type your telephone (only 9 numbers): "); //añadimos el numero de telefono
            String telephone= br.readLine();
            //si escribimos mal el numero de telefono
            while(telephone.length() != 9){
                System.out.println("Incorrect telephone number, please inserted again");
                telephone= br.readLine(); 
            }
            
            //---FECHA DE NACIMIENTO
            System.out.println("Type your date of birth. It must be written in this format yyyy/MM/dd");
            Scanner sc = new Scanner(System.in);
            String fecha = sc.nextLine();
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date testDate = null;
            String date = fecha;
            try{
                testDate = df.parse(date);
                System.out.println("A date type object was created:  "+testDate);
                System.out.println("Now let´s see if it's a valid date...");
            } catch (Exception e){ System.out.println("invalid format");}

            //Si ponemos la fecha mal
            /*
            while(!df.format(testDate).equals(date)){
                System.out.println("PLEASE INSERT IT AGAIN");
                fecha = sc.nextLine();
                testDate = null;
                date = fecha;
            try{
                testDate = df.parse(date);
                System.out.println("A date type object was created: "+testDate);
                System.out.println("Now let´s see if it's a valid date...");
            } catch (Exception e){ System.out.println("invalid format");}
            }
            */
            
            //Cuando la fecha se ha puesto bien
            System.out.println("valid date");
            
            //----GENERO
            System.out.println("Type your gender (F -> female, M -> male, O -> other) ");
            String gender= br.readLine();
            for(int i=0; i<1000; i++){
                if(gender.equals("F")|| gender.equals("M") || gender.equals("O")){
                    break;
                }
                System.out.println("Incorret type please insert it again");
                gender= br.readLine();
                i++;
            }
            
            //creamos el nuevo paciente
            p= new Patient(name, surname, dni, telephone, testDate, gender);
            
            System.out.println("Now introduce the password ");
            String password= br.readLine();
            User newuser= new User(dni, password);
            umi.createUserRegister(newuser); //llamamos a umi para añadir ese user a la base de datos
            System.out.println("Information: " +p+ "\n");
            pmi.addpatientbyRegister(p); //llamamos a pmi para añadir ese paciente a la base de datos
     
            
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}

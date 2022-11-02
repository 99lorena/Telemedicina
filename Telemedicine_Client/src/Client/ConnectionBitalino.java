/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Client;

import java.io.*;
import java.net.InetAddress;

/**
 *
 * @author loredanaabalo
 */
public class ConnectionBitalino {
    private static BufferedReader bufferReader;
    public static void main(String[] args) throws IOException {
        
    }
    public static String getMacAddress(InetAddress ip) throws IOException{
        String macAddress;
        bufferReader = new BufferedReader(new InputStreamReader(System.in));
        macAddress = bufferReader.readLine();
        return macAddress;
    }
 
}

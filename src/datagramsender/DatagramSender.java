/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hampu
 */
public class DatagramSender {

    
    public static void main(String[] args) throws UnknownHostException,SocketException, IOException,InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      
        InetAddress toAdr= InetAddress.getByName("172.20.201.77");
        int toPort= 55555;
        DatagramSocket socket = new DatagramSocket();
        String message;
        List<String> citatLista = new ArrayList<String>();
        citatLista.add("Carpe Diem");
        citatLista.add("Även en blind höna kan få tut i trumpeten");
        citatLista.add("Fredrik Stoltz är en klok gosse, även fast han växte upp på lidingö.");
        citatLista.add("Hattja dojorna gör även den klokaste i rätt läge.");
        citatLista.add("Pingis är som livet, ibland vinner man och ibland förlorar man....");
        
        
        
      
        while(true){
            for(int i =0; i<citatLista.size(); i++){
                
                message= citatLista.get(i);
                byte[] data = message.getBytes();
                DatagramPacket packet = new DatagramPacket(data,data.length, toAdr,toPort);
                socket.send(packet);
                System.out.println(message);
                Thread.sleep(3000);
            }
            
        }
            
        
        
         
    }
    
}

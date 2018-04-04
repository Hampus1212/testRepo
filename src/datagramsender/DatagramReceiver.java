/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author hampu
 */
public class DatagramReceiver {
    public static void main(String[] args) throws SocketException,IOException{
        int minPort= 55555;
        DatagramSocket socket =  new DatagramSocket(minPort);
        byte[] data = new byte[256];
        
        while(true){
            DatagramPacket packet = new DatagramPacket(data,data.length);
            socket.receive(packet);
            System.out.println("Meddelande från: "+ packet.getAddress().getHostAddress());
            String message = new String(packet.getData(),0,packet.getLength());
            System.out.println(message);
            
        }
        
        
    }
}

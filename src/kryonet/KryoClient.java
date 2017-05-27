/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoClient {
    private static int    timeout = 5000;
    private static int    portSocket = 8070;
    private static String ipAdress = "localhost";
    
    public static void main(String[] args) throws IOException{
        
        //1. create Client
        Client client = new Client();
        //2. create Client Listener
        KryoClientListener listener = new KryoClientListener();
        //3. add listener to client
        client.addListener(listener);
        //4. register classes for sending
        Kryo kryo = client.getKryo();
        kryo.register(Packet.Packet01Message.class);
        //5. start client
        client.start();
        //6. connect to server
        client.connect(timeout, ipAdress, portSocket);
        //7. input from console
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String msg = scanner.nextLine();
            client.sendTCP(msg);
        }
        
            
    }
}

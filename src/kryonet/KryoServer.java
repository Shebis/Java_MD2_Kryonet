/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoServer {
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
         // TODO code application logic here
        
        //1. create Server
        Server server = new Server();
        //2. create Listener
        KryoServerListener listener = new KryoServerListener(server);
        //3. add Listener to server
        server.addListener(listener);
        //4. register class type
        Kryo kryo = server.getKryo();
        kryo.register(String.class);
        //5. bind server
        server.bind(8070);
        //6. start server
        server.start();
        System.out.println("Server is starting! ");
        
    }
}

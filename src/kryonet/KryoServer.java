/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import kryonet.Packet.Packet01Message;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoServer {
    private static final int portSocket = 8070;
    
    Server server;
    KryoServerListener listener;
    
    public KryoServer(){
        //1. create Server
        server = new Server();
        //2. create Listener
        listener = new KryoServerListener(server);
        //3. add Listener to server
        server.addListener(listener);
        //5. bind server
        try {
            server.bind(portSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //4. register class type
        registerPackets();
        
        //6. start server
        server.start();    
    }
    
    public static void main(String[] args) throws IOException{  
        System.out.println("Server is starting! ");
        System.out.println("Server is running! \n");
        new KryoServer();
    }
    
    private void registerPackets(){
        //4. register class type
        Kryo kryo = server.getKryo();
        kryo.register(Packet01Message.class);
        kryo.register(Packet02Variation.class);
        kryo.register(Variation.class);
        kryo.register(ClientApp.class);
        kryo.register(java.util.ArrayList.class);
        kryo.register(KryoClient.class);
        kryo.register(KryoClientListener.class);
        kryo.register(KryoServerListener.class);
        
    }
}

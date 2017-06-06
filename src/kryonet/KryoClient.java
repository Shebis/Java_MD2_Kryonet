/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import java.io.IOException;
import kryonet.Packet.Packet01Message;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public final class KryoClient {

    private static final int timeout = 5000;
    private static final int portSocket = 8070;
    private static final String ipAdress = "localhost";

    public Client client;
    private KryoClientListener listener;


    public KryoClient() {
        //1. create Client
        client = new Client();
        //2. create Client Listener
        listener = new KryoClientListener();
        listener.init(client);
        registerPacket();
        //3. add listener to client
        client.addListener(listener);
        //5. start client
        client.start();
        //6. connect to server
        try {
            client.connect(timeout, ipAdress, portSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) throws IOException {
        new KryoClient();
        while(true){}
        
    }

    public void registerPacket() {
        //4. register classes for sending
        Kryo kryo = client.getKryo();
        kryo.register(Packet01Message.class);
        kryo.register(Packet02Variation.class);
        kryo.register(Variation.class);
        kryo.register(ClientApp.class);
        kryo.register(java.util.ArrayList.class);
        kryo.register(KryoClientListener.class);
        kryo.register(KryoServer.class);
        kryo.register(KryoServerListener.class);
    }
}

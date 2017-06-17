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

    private Server server;
    private KryoServerListener kslistener;
    private ActionWithDB database;

    public KryoServer() throws IOException {
        configureAndStartServer();
    }

    /**
     * Server configuration
     *
     * @throws IOException
     */
    public void configureAndStartServer() throws IOException {
        //1. create Server
        server = new Server();
        //2. create Listener
        kslistener = new KryoServerListener();
        database = new ActionWithDB();
        //3. add Listener to server
        server.addListener(kslistener);
        //5. bind server
        server.bind(portSocket);
        //4. register class type
        registerPackets();
        //6. start server
        server.start();
        System.out.println("Server is starting! ");
        System.out.println("Server is running! \n");
        database.createClientTable();
    }

    /**
     * Register all used packets
     */
    private void registerPackets() {
        //4. register class type
        Kryo kryo = server.getKryo();
        kryo.register(Packet01Message.class);
        kryo.register(Packet02Variation.class);
        kryo.register(Variation.class);
        kryo.register(java.util.ArrayList.class);
        kryo.register(java.util.Date.class);
        kryo.register(String[].class);
        kryo.register(Integer[].class);
    }
}

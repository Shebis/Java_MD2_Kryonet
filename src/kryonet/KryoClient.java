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
    private KryoClientListener kclistener;

    /**
     * Kryonet Client Constructor
     * @param packet02Variation
     * @throws java.io.IOException
     */
    public KryoClient(Packet02Variation packet02Variation) throws IOException {
        //1. create a new Client
        client = new Client();
        //2. create Client Listener
        kclistener = new KryoClientListener();
        //3. add listener to client
        client.addListener(kclistener);
        // Register all the possible packets sent
        registerPacket();
        //5. Start the client
        client.start();

        client.connect(timeout, ipAdress, portSocket);

        sendVariation(packet02Variation);
        
        Packet01Message pm = new Packet01Message();
        pm.message = "Random Message to send away...";
        client.sendTCP(pm);
        System.out.println("sent..");
        while (true) {
        }
    }

    /**
     * Function for Packet registration
     */
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
        kryo.register(java.util.Date.class);
    }

    /**
     *
     * @param variation - packet of class Packet02Variation
     */
    public void sendVariation(Packet02Variation variation) {
        client.sendTCP(variation);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryonet.*;
import kryonet.Packet.Packet01Message;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoClientListener extends Listener {

    private Client client;
    //private KryoClient kryoClient = new KryoClient();
    //private final ClientApp clientApp = new ClientApp();

    /**
     * Kryonet Client Listener Constructor
     *
     * @param client
     */
    public void KryoClientListener(Client client) {
        this.client = client;
    }

    /**
     *
     * @param con
     */
    @Override
    public void connected(Connection con) {
        System.out.println("You Are Connected!\n");

//        // Prepare and Send a Message to Server
//        Packet.Packet01Message firstMessage = new Packet.Packet01Message();
//        ClientApp clientapp = new ClientApp();
//        firstMessage.message = variation.getList().toString();
////        firstMessage.message = "Hello!";
//        client.sendTCP(firstMessage);
        System.out.println("Object of class Packet02Variation was sent...");
    }

    /**
     *
     * @param con
     */
    public void disconected(Connection con) {
        System.out.println("You Are Disconnected!");
        System.exit(0);
    }

    /**
     *
     * @param con
     * @param obj
     */
    @Override
    public void received(Connection con, Object obj) {
        if (obj instanceof Packet01Message) {
            Packet01Message pm = (Packet01Message) obj;
            System.out.println("Server >>>> " + pm.message);
        }
    }

//    @Override
//    public String toString(){
//        return null;
//    }  
}

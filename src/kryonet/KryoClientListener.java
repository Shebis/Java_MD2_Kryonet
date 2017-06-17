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
    private ActionWithDB database = new ActionWithDB();

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
    }

    /**
     *
     * @param con
     */
    public void disconected(Connection con) {
        System.out.println("You Are Disconnected!");
    }

    /**
     *
     * @param con
     * @param obj
     */
    @Override
    public void received(Connection con, Object obj) {
        System.out.println("Received " + obj);
        if (obj instanceof Packet02Variation) {
            System.out.println("Packet02Variation received");
            System.out.println(((Packet02Variation) obj).variation.toString());
            database.insertIntoClientTable();
        }
    }

}

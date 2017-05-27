/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryonet.*;


/**
 *
 * @author Roberts Staskevics
 */
public class KryoClientListener extends Listener{
    private Client client;
    
    /**
     * 
     * @param client 
     */
    public void init(Client client){
        this.client = client;
    }
    
    /**
     * 
     * @param con 
     */
   @Override
    public void connected(Connection con)
    {
        System.out.println("You Are Connected!\n");
        
        // Prepare and Send a Message to Server
        Packet.Packet01Message firstMessage = new Packet.Packet01Message();
        firstMessage.message = "Hello, I am Your message!";
        client.sendTCP(firstMessage);
    }
    
    /**
     * 
     * @param con 
     */
    public void disconected(Connection con)
    {
        System.out.println("You Are Disconnected!");
    }
    
    /**
     * 
     * @param con
     * @param obj 
     */
    @Override
    public void received(Connection con, Object obj)
    {
        if (obj instanceof Packet.Packet01Message) {
            Packet.Packet01Message pm = (Packet.Packet01Message) obj;
            System.out.println("Server >>>> " + pm.message);
        }
    } 
}

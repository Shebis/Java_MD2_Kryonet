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
public class KryoClientListener extends Listener{
    private Client client;
    //private KryoClient kryoClient = new KryoClient();
    private final ClientApp clientApp = new ClientApp();
    private final Variation variation = new Variation();
    private final Packet02Variation packet = new Packet02Variation();
    
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
        
//        // Prepare and Send a Message to Server
//        Packet.Packet01Message firstMessage = new Packet.Packet01Message();
//        ClientApp clientapp = new ClientApp();
//        firstMessage.message = variation.getList().toString();
////        firstMessage.message = "Hello!";
//        client.sendTCP(firstMessage);

        clientApp.askHowManyOptions();
        clientApp.askWhichVariantsToFill();
        for(int i = 0; i < clientApp.getUserInputOptionsVariants(); i++){
            clientApp.userFillVariant();
            variation.setVariationNr(clientApp.getUserInputOptionsVariants()+1);
        }
        for(int j = 0; j < variation.getList().size(); j++){
                variation.getList().get(j);
            }
        clientApp.randomFillVariant();
        
        packet.variation = variation;
        sendVariation(packet);
    }
    
    /**
     * 
     * @param con 
     */
    public void disconected(Connection con)
    {
        System.out.println("You Are Disconnected!");
        System.exit(0);
    }
    
    /**
     * 
     * @param con
     * @param obj 
     */
    @Override
    public void received(Connection con, Object obj)
    {
        if (obj instanceof Packet01Message) {
            Packet01Message pm = (Packet01Message) obj;
            System.out.println("Server >>>> " + pm.message);
        }
    } 
    
//    @Override
//    public String toString(){
//        return null;
//    }
    
    public void sendVariation(Packet02Variation variation) {
        client.sendTCP(variation);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.io.IOException;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public class MainServer {
    private static ClientApp clientApp = new ClientApp();
    private static Packet02Variation packet = new Packet02Variation();
    private static Variation variation = new Variation();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {        
        //user interface
        clientApp.askHowManyOptions();
        clientApp.askWhichVariantsToFill();
        for(int i = 0; i < clientApp.getUserInputOptionsVariants(); i++){
            clientApp.userFillVariant();
            //variation.setVariationNr(clientApp.getUserInputOptionsVariants()+1);
        }
        for(int j = 0; j < variation.getList().size(); j++){
            System.out.println("suudi " + variation.getList().get(j));
        }
        clientApp.randomFillVariant();
        
        //System.out.println("ArrayList from MainServer: " + variation.getList());
        //start server
        KryoServer.main(args);
        
        //start client
        KryoClient.main(args);
    }

}

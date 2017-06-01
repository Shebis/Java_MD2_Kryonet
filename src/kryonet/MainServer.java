/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.io.IOException;

/**
 *
 * @author Roberts Staskevics
 */
public class MainServer {
    private static ClientApp clientApp = new ClientApp();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        //user interface
        clientApp.askHowManyOptions();
        clientApp.askWhichVariantsToFill();
        clientApp.userFillVariant();
        
        //start server
        KryoServer.main(args);
        
        //start client
        KryoClient.main(args);
    }

}

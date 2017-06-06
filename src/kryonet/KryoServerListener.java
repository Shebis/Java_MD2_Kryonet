/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryonet.*;
import java.util.ArrayList;
import kryonet.Packet.Packet01Message;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoServerListener extends Listener {

    Server server;
    ClientApp clientapp;
    private ArrayList<Integer> winningNumbers;
    private int randomNumb;
    private Variation var = new Variation();

    public KryoServerListener(Server server) {
        super();
        this.server = server;
        clientapp = new ClientApp();

        winningNumbers = new ArrayList<>();

        randomNumb = 0;
        for (int i = 0; i < 5; i++) {
            randomNumb = clientapp.randInt(1, 35);
            winningNumbers.add(randomNumb);
        }
    }

    @Override
    public void connected(Connection con) {
        System.out.println("User has connected!\n");

        System.out.println("Winning Numbers:");
        for (int i = 0; i < winningNumbers.size(); i++) {
            if(i == 0)
                System.out.print("[ " + winningNumbers.get(i));
            else if (i == winningNumbers.size()-1)
                System.out.print(" , " + winningNumbers.get(i) + " ]\n");
            else
                System.out.print(" , " + winningNumbers.get(i));
        }
        System.out.println("\n");
    }

    public void disconected(Connection con) {
        System.out.println("User has disconnected!\n");
        System.exit(0);
    }

    @Override
    public void received(Connection con, Object obj) {
        System.out.println("received " + obj);
        if (obj instanceof Packet01Message) {
            Packet01Message pm = (Packet01Message) obj;
            System.out.println("Client >>>> " + pm.message);
        }
        
        if (obj instanceof Packet02Variation){
            Packet02Variation vm = (Packet02Variation) obj;
            System.out.println("Client <===> " + vm.variation);
        
        }
    }

    public void sendMSGToAll(String message) {
        Connection[] allClients = server.getConnections();
        for (Connection con : allClients) {
            con.sendTCP(message);
        }
    }
    
    @Override
    public String toString(){
        return "Nr. " + var.getVariationNr() 
                + "User Numbers: " + var.getList()
                + "User Email: " + var.getClientEmail();
    }
}

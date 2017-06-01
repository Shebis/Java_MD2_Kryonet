/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryonet.*;
import java.util.ArrayList;

/**
 *
 * @author Roberts Staskevics
 */
public class KryoServerListener extends Listener {

    Server server;
    ClientApp clientapp;
    private ArrayList<Integer> winningNumbers;
    private int randomNumb;

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
    }

    @Override
    public void received(Connection con, Object obj) {
        if (obj instanceof Packet.Packet01Message) {
            Packet.Packet01Message pm = (Packet.Packet01Message) obj;
            System.out.println("Client >>>> " + pm.message);
        }
    }

    public void sendMSGToAll(String message) {
        Connection[] allClients = server.getConnections();
        for (Connection con : allClients) {
            con.sendTCP(message);
        }
    }
}

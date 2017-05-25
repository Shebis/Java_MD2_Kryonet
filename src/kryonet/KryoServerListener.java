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
    int randomNumb;

    
    public KryoServerListener(Server server)
    {
        super();
        this.server = server;
        
        winningNumbers = new ArrayList<>();
        
        randomNumb = 0;
        for(int i = 0; i < 5; i++){
            randomNumb = clientapp.randInt(1, 35);
            winningNumbers.add(randomNumb);
        }
    }
    
    @Override
    public void connected(Connection con)
    {
        System.out.println("User has connected!");
        System.out.println("Winning Numbers:");
        for(int i = 0; i < winningNumbers.size(); i++){
            System.out.println(" [ " + winningNumbers.get(i) + ", ");
        }
        System.out.println(" ]");
    }
    
    public void disconected(Connection con)
    {
        System.out.println("User has disconnected!");
    }
    
    @Override
    public void received(Connection con, Object obj)
    {
        if(obj instanceof String)
        {
            System.out.println("User: " + con.getID() + " >>>>> " + (String)obj);
            sendMSGToAll((String)obj);
        }
    }
    public void sendMSGToAll(String message)
    {
        Connection[] allClients = server.getConnections();
        for(Connection con: allClients)
            con.sendTCP(message);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import com.esotericsoftware.kryonet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    //private Variation var = new Variation();
    //private Packet02Variation pack = new Packet02Variation();

    public KryoServerListener(Server server) {
//        super();
        this.server = server;
        clientapp = new ClientApp();

        winningNumbers = new ArrayList<>();

        /**
         * Generate five winning Numbers
         * Add to winningNumbers array
         */
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
            if (i == 0) {
                System.out.print("[ " + winningNumbers.get(i));
            } else if (i == winningNumbers.size() - 1) {
                System.out.print(" , " + winningNumbers.get(i) + " ]\n");
            } else {
                System.out.print(" , " + winningNumbers.get(i));
            }
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
        //System.out.println("ArrayList from ServerListener: " + var.getList());
        if (obj instanceof Packet01Message) {
            //Packet01Message pm = (Packet01Message) obj;
            System.out.println("Packet01Message received");
            System.out.println(((Packet01Message) obj).message);
        }

        if (obj instanceof Packet02Variation) {
            System.out.println("Packet02Variation received");
            System.out.println(((Packet02Variation) obj).variation.toString());
        }
    }

    /**
     * Function to check if array elements match
     *
     * @param list1 - auto generated array with winning numbers
     * @param list2 - user input array
     */
    public static void checkArrayElements(ArrayList<Integer> list1, List<Integer> list2) {
        int same = 0;
        for (int i = 0; i <= list1.size() - 1; i++) {
            for (int j = 0; j <= list2.size() - 1; j++) {
                if (Objects.equals(list1.get(i), list2.get(j))) {
                    System.out.println("Matching number: " + list2.get(j));
                    same++;
                    break;
                }
            }
        }
        System.out.println(same);
    }
}

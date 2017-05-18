/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberts Staskevics
 */
public class Variation {

    private int variationNr;
    private int correctNumbers = 0;
    private ArrayList<Integer> selectedNumbers;
    private String clientEmail;
//    private Datetime dateTime;

    public Variation() {
        selectedNumbers = new ArrayList<>();
    }

    public List<Integer> getList() {
        return selectedNumbers;
    }

    public void insertIntoArrayList(int element) {
        selectedNumbers.add(element);
    }
}

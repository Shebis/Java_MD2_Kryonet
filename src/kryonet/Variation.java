/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roberts Staskevics
 */
public class Variation {

    private int variationNr;
    private int correctNumbers;
    private ArrayList<Integer> selectedNumbers;
    private String clientEmail;
    private Date date;

    public Variation() {
        selectedNumbers = new ArrayList<>();
        variationNr = 0;
        correctNumbers = 0;
        clientEmail = "";
    }

    public int getVariationNr() {
        return variationNr;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public Date getDate() {
        return date;
    }
    
    public List<Integer> getList() {
        return selectedNumbers;
    }

    public void setVariationNr(int variationNr) {
        this.variationNr = variationNr;
    }

    public void setCorrectNumbers(int correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void insertIntoArrayList(int element) {
        selectedNumbers.add(element);
    }
}

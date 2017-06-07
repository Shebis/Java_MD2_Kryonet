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
    private ArrayList<Integer> selectedNumbers = new ArrayList<>();
    private String clientEmail;
    private Date date;

    /**
     * Variation constructor without parameters
     */
    public Variation() {
        System.out.println("Selected Numbers List in Variation constructor: " + getList());
    }

    /**
     * Variation constructor with parameters
     *
     * @param variationNr
     * @param correctNumbers
     * @param selectedNumbers
     * @param clientEmail
     * @param date
     */
    public Variation(int variationNr, int correctNumbers, ArrayList<Integer> selectedNumbers, String clientEmail, Date date) {
        selectedNumbers = new ArrayList<>();
        variationNr = 1;
        correctNumbers = 0;
        clientEmail = "";
    }

    /**
     * Function to get/return Variation Number
     *
     * @return variationNr
     */
    public int getVariationNr() {
        return variationNr;
    }

    /**
     * Function to get/return Variation correct Numbers
     *
     * @return correctNumbers
     */
    public int getCorrectNumbers() {
        return correctNumbers;
    }

    /**
     * Function to get/return Variation client email
     *
     * @return clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Function to get/return Variation Date and Time
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Function to get/return Variation array with user input Integers
     *
     * @return selectedNumbers
     */
    public List<Integer> getList() {
        return selectedNumbers;
    }

    /**
     *
     * @param variationNr
     */
    public void setVariationNr(int variationNr) {
        this.variationNr = variationNr;
    }

    /**
     *
     * @param correctNumbers
     */
    public void setCorrectNumbers(int correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    /**
     *
     * @param clientEmail
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param element add element (Integer) to array
     */
    public void insertIntoArrayList(int element) {
        selectedNumbers.add(element);
    }
}

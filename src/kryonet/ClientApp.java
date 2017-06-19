/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import kryonet.Packet.Packet02Variation;

/**
 *
 * @author Roberts Staskevics
 */
public class ClientApp {

    private static ClientApp clientApp = new ClientApp();
    
    //private static Variation variation = new Variation(0, 0, selectedNumbers, clientEmail, date);
    private static int userInputOptions;
    private static int userInputOptionsVariants;
    private static String userEmail;
    private static ArrayList<Integer> arrayOfVariationNumbers = new ArrayList<>();
    private static ArrayList<Integer> arrayRandom;

    /**
     *
     */
    public ClientApp() {
        userInputOptions = 0;
        userInputOptionsVariants = 0;
        userEmail = "";
//        arrayOfVariationNumbers = new ArrayList<>();
        arrayRandom = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {

        clientApp.askHowManyOptions(); //2 - userInputOptions
        clientApp.askWhichVariantsToFill(); //2 - userInputOptionsVariants
        clientApp.userEmailFill(); //fasf

        
//        for(int i = 1; i <= userInputOptionsVariants; i++){
        clientApp.userFillVariant(arrayOfVariationNumbers);
        
        System.out.println("Your entered List of Integers - " + arrayOfVariationNumbers);

        Variation variation = new Variation(userInputOptions, arrayOfVariationNumbers, userEmail);
        Packet02Variation packet02Variation = new Packet02Variation();
        packet02Variation.variation = variation;
        KryoClient kryoClient = new KryoClient(packet02Variation);

//        }
        clientApp.randomFillVariant(arrayRandom);

        System.out.println("Array of random integers - " + arrayRandom);

    }

    /**
     * Function for asking user how many Variations he wants choose between 1
     * and 5
     */
    public void askHowManyOptions() {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(null, errorMessage
                    + "Enter number (1-5):", "Input number...");
            try {
                userInputOptions = Integer.parseInt(stringInput);
                //variation.setVariationNr(userInputOptions);
                //System.out.println("userInputOptions: " + userInputOptions);
                if (userInputOptions <= 0 || userInputOptions >= 6) {
                    errorMessage = "That number is not within the \n" + "allowed range!\n";
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you! You inserted "
                            + userInputOptions + " options!",
                            "User Input", JOptionPane.INFORMATION_MESSAGE);
                    errorMessage = ""; // no more error
                }
            } catch (NumberFormatException ex) {
                // The typed text was not an integer
                errorMessage = "The text you typed is not a number.\n";
            }
        } while (!errorMessage.isEmpty());
    }

    /**
     * Function for User to ask which Variations to fill by hand other
     * Variations will fill automatically, with function randomFillVariant()
     */
    public void askWhichVariantsToFill() {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(null, errorMessage
                    + "How many variants you want to fill by hand? \n"
                    + "You can choose: " + userInputOptions + " or less.",
                    "Input number of variants...");
            try {
                userInputOptionsVariants = Integer.parseInt(stringInput);
                if (userInputOptionsVariants < 0 || userInputOptionsVariants > userInputOptions) {
                    errorMessage = "That number is not within the \n" + "allowed range!\n";
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you! You inserted "
                            + userInputOptionsVariants + " options! "
                            + "\nOther variants will fill in automaticaly!",
                            "User Input", JOptionPane.INFORMATION_MESSAGE);
                    errorMessage = ""; // no more error
                }
            } catch (NumberFormatException ex) {
                // The typed text was not an integer
                errorMessage = "The text you typed is not a number.\n";
            }
        } while (!errorMessage.isEmpty());
    }

    /**
     * Function that allows User to enter five (5) numbers per Variation
     *
     * @param list
     * @return
     */
    public ArrayList<Integer> userFillVariant(ArrayList<Integer> list) {
        int userInputNumber;
        String errorMessage = "";
        int index = 1;
        for (int i = 0; i < 5; i++) {
            do {
                // Show input dialog with current error message, if any
                String stringInput = JOptionPane.showInputDialog(null, errorMessage
                        + "Enter number Nr. " + index + " number in range (1-35):",
                        "Enter number...");
                try {
                    userInputNumber = Integer.parseInt(stringInput);
                    if (userInputNumber <= 0 || userInputNumber > 35) {
                        errorMessage = "That number is not within the \n" + "allowed range!\n";
                    } else if (list.contains(userInputNumber)) {
                        errorMessage = "Number '" + userInputNumber + "' already exists!\n";
                    } else {
                        //insert number into array selectedNumbers
                        list.add(userInputNumber);
                        System.out.println("ArrayList from ClientApp after insert from JOptionPane: " + list);
                        JOptionPane.showMessageDialog(null, "Thank you! You inserted number Nr. "
                                + index + " !",
                                "User Input", JOptionPane.INFORMATION_MESSAGE);
                        errorMessage = ""; // no more error
                        index++;
                    }
                } catch (NumberFormatException ex) {
                    // The typed text was not an integer
                    errorMessage = "The text you typed is not a number.\n";
                }
            } while (!errorMessage.isEmpty());
        }
        return list;
    }

    /**
     * Function for Variation automatic filling
     *
     * @param list
     * @return list of integers
     */
    public ArrayList<Integer> randomFillVariant(ArrayList<Integer> list) {
        int random;
        for (int j = 0; j < userInputOptions - userInputOptionsVariants; j++) {
            for (int i = 0; i < 5; i++) {
                random = randInt(1, 35);
                list.add(random);
            }
        }
        return list;
    }

    /**
     * Function for user email entering
     */
    public void userEmailFill() {
        userEmail = JOptionPane.showInputDialog(null, "Enter Email!",
                "Enter email...");
    }

    /**
     * Function that generates Integer in range between min and max
     *
     * @param min - smallest Integer value
     * @param max - largest Integer value
     * @return randomNum - Integer between (included) min and max value
     */
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Function that returns how many Variations fill by hand
     *
     * @return userInputOptionsVariants - Integer value
     */
    public int getUserInputOptionsVariants() {
        return userInputOptionsVariants;
    }
}

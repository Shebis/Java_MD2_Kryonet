/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kryonet;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberts Staskevics
 */
public class ClientApp {

    private static Variation variation;
    private static int userInputOptions;
    private static int userInputOptionsVariants;

    public ClientApp() {
        variation = new Variation();
        //List<Integer> selectedNumbers = variation.getList();
        userInputOptions = 0;
        userInputOptionsVariants = 0;
    }

    public void askHowManyOptions() {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(null, errorMessage + "Enter number (1-5):", "Input number...");
            try {
                userInputOptions = Integer.parseInt(stringInput);
                System.out.println("userInputOptions: " + userInputOptions);
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
                //System.out.println("userInputOptions: " + userInputOptions);
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

    public void userFillVariant() {
        int userInputNumber;
        int index = 1;
        String errorMessage = "";
        for (int i = 0; i < 5; i++) {
            do {
                // Show input dialog with current error message, if any
                String stringInput = JOptionPane.showInputDialog(null, errorMessage
                        + "Enter number Nr. " + index + " number in range (1-35):",
                        "Enter number...");
                try {
                    userInputNumber = Integer.parseInt(stringInput);
                    variation.insertIntoArrayList(userInputNumber);
                    //System.out.println("userInputOptions: " + userInputOptions);
                    if (userInputNumber <= 0 || userInputNumber > 35) {
                        errorMessage = "That number is not within the \n" + "allowed range!\n";
                    } else {
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
        // array output
        int indexForArray = 1;
        for (int j = 0; j < variation.getList().size(); j++) {
            System.out.println("Nr. " + indexForArray + ": " + variation.getList().get(j));
            indexForArray++;
        }
    }

    public void randomFillVariant() {
        randInt(1, 35);
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}

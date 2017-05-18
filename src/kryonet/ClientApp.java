/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        List<Integer> selectedNumbers = variation.getList();
    }

    public static void main(String[] args) {
    }

    public void askHowManyOptions() {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter number (1-5):");
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
            String stringInput = JOptionPane.showInputDialog(errorMessage
                    + "How many variants you want to fill by hand? \n"
                    + "You can choose: " + userInputOptions + " or less.");
            try {
                userInputOptionsVariants = Integer.parseInt(stringInput);
                //System.out.println("userInputOptions: " + userInputOptions);
                if (userInputOptionsVariants <= 0 || userInputOptionsVariants == userInputOptions || userInputOptionsVariants > userInputOptions) {
                    errorMessage = "That number is not within the \n" + "allowed range!\n";
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you! You inserted "
                            + userInputOptionsVariants + " options! "
                            + "Other variants will fill in automaticaly!",
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number in range (1-35): ");
            try {
                do {
                    userInputNumber = Integer.parseInt(br.readLine());
                    variation.insertIntoArrayList(userInputNumber);
                } while (userInputNumber > 0 || userInputNumber < 36);

            } catch (IOException ex) {
                System.err.println("Invalid Format!");
            }
        }
        int index = 1;
        for (int j = 0; j < variation.getList().size(); j++) {
            System.out.println("Nr. " + index + ": " + variation.getList().get(j));
            index++;
        }

    }

    public void randomFillVariant() {

    }

}

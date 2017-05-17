/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet;

import javax.swing.JOptionPane;

/**
 *
 * @author Roberts Staskevics
 */
public class ClientApp {
    Variation variation = new Variation();
    private static int userInputOptions;
    private static int userInputOptionsVariants;
    
    public static void main(String [] args)
    {
        
        askHowManyOptions();
        askWhichVariantsToFill();
        
    }
    
    public static void askHowManyOptions()
    {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter number (1-5):");
            try 
            {
                userInputOptions = Integer.parseInt(stringInput);
                System.out.println("userInputOptions: " + userInputOptions);
                if (userInputOptions <= 0 || userInputOptions >= 6) 
                {
                    errorMessage = "That number is not within the \n" + "allowed range!\n";
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Thank you! You inserted " + 
                                userInputOptions + " options!",
                                "User Input", JOptionPane.INFORMATION_MESSAGE);
                    errorMessage = ""; // no more error
                }
            } 
            catch (NumberFormatException ex) 
            {
                // The typed text was not an integer
                errorMessage = "The text you typed is not a number.\n";
            }
        } while (!errorMessage.isEmpty());
    }
    
    public static void askWhichVariantsToFill()
    {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(errorMessage + 
                    "How many variants you want to fill by hand? \n"
                        + "You can choose: " + userInputOptions + " or less.");
            try 
            {
                userInputOptionsVariants = Integer.parseInt(stringInput);
                //System.out.println("userInputOptions: " + userInputOptions);
                if (userInputOptionsVariants <= 0 || userInputOptionsVariants >= 6) 
                {
                    errorMessage = "That number is not within the \n" + "allowed range!\n";
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Thank you! You inserted " + 
                                userInputOptionsVariants + " options! "
                                + "Other variants will fill in automaticaly!",
                                "User Input", JOptionPane.INFORMATION_MESSAGE);
                    errorMessage = ""; // no more error
                }
            } 
            catch (NumberFormatException ex) 
            {
                // The typed text was not an integer
                errorMessage = "The text you typed is not a number.\n";
            }
        } while (!errorMessage.isEmpty());       
    }
    
    public static void userFillVariant()
    {
        
    }
    
    public static void randomFillVariant()
    {
        
    }

}

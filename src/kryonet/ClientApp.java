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
    private static int userInputOptions;
    
    public static void main(String [] args)
    {
        
        askHowManyOptions();
        
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
        
    }
//        int g = -1;
//        while( g < 0 )
//        {
//            String userInput = (JOptionPane.showInputDialog("Enter how many variants you want(1-5): "));
//            if(userInputOptions > 0 && userInputOptions < 6)
//            {
//                g++;
//                JOptionPane.showMessageDialog(null, "Thank you! You inserted " + userInputOptions + " options!", 
//                                                "Display Message", JOptionPane.INFORMATION_MESSAGE);
//                System.out.println("Thank you! You inserted " + userInputOptions + " options!");
//            }
//            else
//            {
//                String msg = "<html>You did not enter correct! \n <b> Try Again!!</b></html>";
//                JLabel label = new JLabel(msg);
//                label.setFont(new Font("serif", Font.PLAIN, 18));
//                JOptionPane.showMessageDialog(null, label, "Error!", JOptionPane.INFORMATION_MESSAGE);  
//            }   
//        }
    
}

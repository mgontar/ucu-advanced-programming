package lab2;

import javax.swing.*;

public class Lab2Main {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        boolean letsPlay = true;
        do {
                String input = JOptionPane.showInputDialog("Lets play guess game! Set natural number up to 1000:");

                //Cancel pressed
                if(null == input)
                {
                    break;
                }
                else {
                    try {
                        int max = Integer.parseInt(input);
                        if (max > 0 && max <= 1000) {
                            game.play(max);
                            game.printBestScores();
                            letsPlay = false;
                            int choice = JOptionPane.showConfirmDialog(null, "Lets play again?", null,
                                    JOptionPane.YES_NO_OPTION);
                            letsPlay = (JOptionPane.YES_OPTION == choice);
                        }
                    } catch (NumberFormatException ex) {
                        //Not integer in input field
                        int choice = JOptionPane.showConfirmDialog(null, "We need a number from 0 up to 1000, try again?", null,
                                JOptionPane.YES_NO_OPTION);
                        letsPlay = (JOptionPane.YES_OPTION == choice);
                    }
                }
        } while(letsPlay);
    }
}

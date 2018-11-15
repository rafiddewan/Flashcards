package com.company;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Client class for the multiplication flashcards
 */
public class MultiplicationFlashCardApplication {

    /**
     * Client code for multiplication flashcards
     * @param args
     */
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        int multiplier = 0;
        int[] multipliers;
        MultiplicationFlashCards multiplicationFlashCards;
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        String str = input.nextLine();
        if(str.length() == 1){
            multiplier = Integer.parseInt(str); //parsing a single multiplier
            if(multiplier > 12 || multiplier < 1) throw new IllegalArgumentException("Should be between 1 and 12");
            multiplicationFlashCards = new MultiplicationFlashCards(multiplier);
        }
        else{
            String [] strNum = str.split(" "); //split the array of the null spaces of the array of numbers
            multipliers = new int[strNum.length];
            for(int i = 0; i < strNum.length; i++) {
                multipliers[i] = Integer.parseInt(strNum[i]); //parsing multiple multipliers
                if(multipliers[i] > 12 || multipliers[i] < 1) throw new  IllegalArgumentException("Should be between 1 and 12");
            }
                multiplicationFlashCards = new MultiplicationFlashCards(multipliers);
        }
        boolean check = multiplicationFlashCards.hasNext();
        while(check)
        {
            check = multiplicationFlashCards.nextCard();
            System.out.println("Score = " + multiplicationFlashCards.getScore());
            if (!check)  break;
            boolean proceedOrExit = false;
            System.out.println("Next? (Y or N)");
            do {
                String status = input.nextLine().toUpperCase();
                if(status.equals("Y")) proceedOrExit = true;
                else if(status.equals("N"))
                {
                    check = false;
                    proceedOrExit = true;
                    System.out.println("You've got " + multiplicationFlashCards.getScore() +  " so far");
                }
            } while(!proceedOrExit);
        }
    }
}

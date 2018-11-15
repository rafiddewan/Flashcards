package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Client class for the language flashcards
 */
public class LanguageFlashCardApplication
{
    /**
     * Client code for language flashcards
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        String filename = input.nextLine(); //
        LanguageFlashCards languageFlashCards = null; //Create languages flashcards
        try {
            languageFlashCards = new LanguageFlashCards(filename); //read the file
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        boolean check = languageFlashCards.hasNext(); //should return since there should be unanswered cards
        while(check)
        {
            check = languageFlashCards.nextCard(); //Flips to the next flashcard if there are no flashcards it will return false
            System.out.println("Score = " + languageFlashCards.getScore());
            if (!check)  break; //Checks if the player quit or won
            boolean proceedOrExit = false; //Variable to get actual inputs, Y for yes or N for no
            System.out.println("Next? (Y or N)");
            do {
                String status = input.nextLine().toUpperCase();
                if(status.equals("Y")) proceedOrExit = true;
                else if(status.equals("N"))
                {
                    check = false;
                    proceedOrExit = true;
                    System.out.println("You've got " + languageFlashCards.getScore() +  " so far");
                }
            } while(!proceedOrExit);// Checks to see if the player has either put  Y or N as the inputs
        }
    }
}

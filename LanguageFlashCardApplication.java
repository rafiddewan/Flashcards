package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LanguageFlashCardApplication
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        String filename = input.nextLine();
        LanguageFlashCards languageFlashCards = null;
        try {
            languageFlashCards = new LanguageFlashCards(filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        boolean check = languageFlashCards.hasNext();
        while(check)
        {
            check = languageFlashCards.nextCard();
            System.out.println("Score = " + languageFlashCards.getScore());
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
                    System.out.println("You've got " + languageFlashCards.getScore() +  " so far");
                }
            } while(!proceedOrExit);
        }
    }
}

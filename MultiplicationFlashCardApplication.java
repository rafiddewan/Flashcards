package com.company;
import java.io.InputStream;
import java.util.Scanner;

public class MultiplicationFlashCardApplication {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int mulitiplier = 0;
        int[] multipliers = null;
        MultiplicationFlashCards multiplicationFlashCards;
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        String str = input.nextLine();
        if(str.length() == 1){
            mulitiplier = Integer.parseInt(str);
            multiplicationFlashCards = new MultiplicationFlashCards(mulitiplier);
        }
        else{
            multipliers = new int[str.length()];
            Scanner scan = new Scanner(str);
            int i = 0;
            while(scan.hasNextInt()) {
                multipliers[i] = scan.nextInt();
                i++;
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
                }
            } while(!proceedOrExit);
        }
    }
}

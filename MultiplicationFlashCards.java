package com.company;

/**
 * MultiplicationFlashCards Class
 */
public class MultiplicationFlashCards extends AbstractFlashCards
{
    /**
     * Constructor creating multiple flashcards for one times table
     * @param multiplier
     */
    public MultiplicationFlashCards(int multiplier)
    {
        String question, answer;
        for(int i = 1; i <= 12; i++)
        {
            question = i + "x" + multiplier;
            answer = Integer.toString(multiplier * i);
            addCard(question, answer);
        }
    }

    /**
     * Constructor creating multiplier flashcards for multiple time tables
     * @param multiplier
     */
    public MultiplicationFlashCards(int[] multiplier)
    {
        String question, answer;
        for(int i = 0; i < multiplier.length; i++)
        {
            for(int j = 1; j <= 12; j++)
            {
                question = j + "x" + multiplier[i];
                answer = Integer.toString(multiplier[i] * j);
                addCard(question, answer);
            }
        }
    }
}


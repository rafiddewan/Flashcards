package com.company;

import java.util.*;

public abstract class AbstractFlashCards
{
    private HashMap <String, String> flashcards;
    private ArrayList <String> unansweredCards;
    private int score;
    private Scanner scanner;
    private Random random;

    /**
     *
     */
    public AbstractFlashCards()
    {
        this.flashcards = new HashMap<>();
        this.unansweredCards = new ArrayList<>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.score = 0;
    }

    /**
     * Adds a flashcard
     * @param question
     * @param answer
     */
    protected void addCard(String question, String answer)
    {
        flashcards.put(question, answer);
        reset();
    }

    /**
     * Resets the deck of unanswered questions
     */
    public void reset()
    {
        //if(!unansweredCards.isEmpty())
        unansweredCards.clear();
        String[] array = flashcards.keySet().toArray(new String[flashcards.keySet().size()]);
        ArrayList <String> arrayList = new ArrayList<>(Arrays.asList(array));
        for(int i = arrayList.size(); i > 0; i--)
        {
            unansweredCards.add(0, arrayList.remove(random.nextInt(i)));
        }
    }

    /**
     *
     * @return boolean
     */
    public boolean hasNext()
    {
        return !unansweredCards.isEmpty();
    }

    /**
     *
     * @return boolean
     */
    public boolean nextCard()
    {
        System.out.println(Arrays.toString(unansweredCards.toArray()));
        System.out.println(unansweredCards.get(0));
        String userAnswer = scanner.nextLine();
        if(flashcards.containsValue(userAnswer))
        {
            System.out.println("You're Correct!");
            unansweredCards.remove(0);
            score++;
        }
        else
            {
                System.out.println("Sorry, please try again");
                String temp = unansweredCards.remove(0);
                unansweredCards.add(random.nextInt(unansweredCards.size()), temp);
            }
        return hasNext();
    }

    /**
     * Returns the score of the player
     * @return int
     */
    public int getScore()
    {
        return score;
    }
}
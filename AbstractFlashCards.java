package com.company;

import java.util.*;

/**
 * Abstract class of flashcards
 */
public abstract class AbstractFlashCards
{
    private HashMap <String, String> flashcards; //Key of the HashMap represents the question, and the value of the HashMap represents the answer
    private ArrayList <String> unansweredCards; //List containing the unanswered questions of the flashcards
    private int score; //Score of the player
    private Scanner scanner; //Input for user
    private Random random; //Random numbers

    /**
     * Initialize all the instance variables in the constructor
     * Score is set to 0 at the beginning of the of the game when the flashcards are created
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
     * Resets and randomizes the deck of unanswered questions
     */
    public void reset()
    {
        unansweredCards.clear(); //removes are the unanswered flashcards
        String[] array = flashcards.keySet().toArray(new String[flashcards.keySet().size()]); //Used to store the keys of the flashcards to the array
        ArrayList <String> arrayList = new ArrayList<>(Arrays.asList(array)); //Created an array list to store
        for(int i = arrayList.size(); i > 0; i--)
        {
            unansweredCards.add(0, arrayList.remove(random.nextInt(i))); //Creates a randomized set of unanswered questions
        }
    }

    /**
     * Checks to see if the unanswered cards
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
        System.out.println(Arrays.toString(unansweredCards.toArray())); //Print the array of flashcards
        System.out.println(unansweredCards.get(0)); //Print the first unanswered flashcard
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

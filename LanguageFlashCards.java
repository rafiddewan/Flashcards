package com.company;

import java.io.*;
import java.util.concurrent.ConcurrentMap;

public class LanguageFlashCards extends AbstractFlashCards
{
    private static final String COMMA_DELIMTER = ","; //Used to remove the comma in the csv file
    private String filename; //Name of the file

    /**
     * Creates the flash cards from the csv  file
     * @param filename
     * @throws IOException
     */
    public LanguageFlashCards(String filename) throws IOException
    {
        this.filename = filename;
        BufferedReader reader = new BufferedReader(new FileReader(this.filename)); //Reads the file
        String line = reader.readLine(); //Reads the line for that file
        while(line != null)
        {
            String[] cards = line.split(COMMA_DELIMTER);
            addCard(cards[0], cards[1]); //Add the question and the answer as a flashcard
            line = reader.readLine(); // read the next line
        }
    }
}


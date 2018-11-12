package com.company;

import java.io.*;
import java.util.concurrent.ConcurrentMap;

public class LanguageFlashCards extends AbstractFlashCards
{
    private static final String COMMA_DELIMTER = ",";
    private String filename;

    /**
     * Creates the flash cards from the csv  file
     * @param filename
     * @throws IOException
     */
    public LanguageFlashCards(String filename) throws IOException
    {
        this.filename = filename;
        BufferedReader reader = new BufferedReader(new FileReader(this.filename));
        String line = reader.readLine();
        while(line != null)
        {
            String[] cards = line.split(COMMA_DELIMTER);
            addCard(cards[0], cards[1]);
            line = reader.readLine();
        }

    }
}

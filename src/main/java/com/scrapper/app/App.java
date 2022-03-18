package com.scrapper.app;

import com.scrapper.tokopedia.TokopediaScrap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scrapping scrapper = new TokopediaScrap();
        scrapper.execute();
    }
}

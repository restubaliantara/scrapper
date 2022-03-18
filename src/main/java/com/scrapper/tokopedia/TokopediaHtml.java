package com.scrapper.tokopedia;

import org.jsoup.nodes.Document;

import java.io.IOException;

import com.scrapper.app.GetHtml;

import org.jsoup.Jsoup;

public class TokopediaHtml implements GetHtml {

    private static final String TOKOPEDIA_BASE_URL = "https://www.tokopedia.com/";
    

    

    @Override
    public Document getHtmlToDocument() throws IOException {
        
        return Jsoup.connect(getUrl()).get();
    }

    public String getUrl(){
        
        return TOKOPEDIA_BASE_URL.concat("p/handphone-tablet/handphone?ob=60&page=1");
         
    }
    
}

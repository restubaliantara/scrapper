package com.scrapper.app;

import java.io.IOException;

import org.jsoup.nodes.Document;

public interface GetHtml {
    
    /**
     * Fungsi untuk mengubah HTML menjadi document agar bisa 
     * di parsing dalam bentuk object
     */
    public Document getHtmlToDocument() throws IOException;
}

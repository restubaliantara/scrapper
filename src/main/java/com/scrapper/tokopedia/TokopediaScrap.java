package com.scrapper.tokopedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import com.scrapper.app.GetHtml;
import com.scrapper.app.Scrapping;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class TokopediaScrap implements Scrapping {

    @Override
    public void execute() {
        GetHtml html = new TokopediaHtml();
        List<TokopediaBean> listBean = new ArrayList<>();
        try {

            final Document document = html.getHtmlToDocument();
            for (Element row : document.select("div.css-16vw0vn")){
                TokopediaBean bean = new TokopediaBean(row);
                listBean.add(bean);
            }
            writeToCSV(listBean);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void writeToCSV(List<TokopediaBean> listBean) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("scrapper.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Product Name,Link Image,Price,Rating,Product Desc, Merchant Name");
            for (TokopediaBean bean : listBean) {
                printWriter.println(bean.toString());
            }
            
            printWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        
    }
    
    
    
    
}

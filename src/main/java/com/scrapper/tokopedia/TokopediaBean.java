package com.scrapper.tokopedia;

import org.jsoup.nodes.Element;

public class TokopediaBean {
    
    private String productName;
    private String productDesc;
    private String price;
    private String imageLink;
    private String rating;
    private String merchantName;

    public TokopediaBean(Element e){
        setImageLink(e);
        setPrice(e);
        setMerchantName(e);
        setProductDesc(e);
        setRating(e);
        setProductName(e);
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(Element e) {
        this.productName = e.select("div.css-11s9vse span.css-1bjwylw").text();
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(Element e) {
        this.productDesc = e.select("div.css-11s9vse span.css-1bjwylw").text();
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(Element e) {
        this.price = e.select("div.css-11s9vse div.css-4u82jy span.css-o5uqvq").text();
    }
    public String getImageLink() {
        return imageLink;
    }
    public void setImageLink(Element e) {
        this.imageLink = e.select("div.css-79elbk div.css-nzbstz img").attr("src");
    }
    public String getRating() {
        return rating;
    }

    public void setRating(Element e) {
        int i = 0;

        for (Element rate : e.select("div.css-11s9vse div.css-153qjw7 div img")) {
            if (rate.tagName().equals("img")) {
                i++;
            }

        }
        this.rating = String.valueOf(i);
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(Element e) {
        this.merchantName = e.select("div.css-11s9vse div.css-tpww51 div.css-vbihp9 span.css-1kr22w3").get(1).text();
    }


    @Override
    public String toString()
    {
        return productName+","+imageLink+","+price+","+rating+","+productDesc+","+merchantName;
    }

    

}

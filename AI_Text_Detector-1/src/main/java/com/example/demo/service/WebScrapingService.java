package com.example.demo.service;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class WebScrapingService {

    public String getWebsite(String text) {
        try {
            Document doc = Jsoup.connect(text).get();
            String title = doc.title();
            String description = doc.select("meta[name=description]").attr("content");

            return "Title: " + title + ", Description: " + description;
        } catch (Exception e) {
            return "Website not found or not accessible.";
        }
    }
}




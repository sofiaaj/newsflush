package com.example.newsflush_cs147;

import java.util.ArrayList;

public class News {
    private String mHeadline;
    private String mSummary;
    private String mCategory;
    private String mArticle;
    private String mTime;

    public News(String headline, String summary, String category, String article, String time){
        mHeadline = headline;
        mSummary = summary;
        mCategory = category;
        mArticle = article;
        mTime = time;
    }

    public String getHeadline(){
        return mHeadline;
    }

    public String getSummary(){
        return mSummary;
    }

    public String getCategory(){
        return mCategory;
    }

    public String getArticle(){
        return mArticle;
    }

    public String getTime(){
        return mTime;
    }


    public static ArrayList<News> createNewsList() {
        ArrayList<News> newsList = new ArrayList<News>();
        for (int i = 1; i <= 10; i++) {
            newsList.add(new News("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Local", "Lorem Ipsum", "10 min"));
        }
        return newsList;
    }

}

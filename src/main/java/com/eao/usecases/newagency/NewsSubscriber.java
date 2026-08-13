package com.eao.usecases.newagency;

public class NewsSubscriber implements Subscriber {

    private String news;
    private String subName;

    public NewsSubscriber(String subName) {
        this.subName = subName;
    }

    @Override
    public void update(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}

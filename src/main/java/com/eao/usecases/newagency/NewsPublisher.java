package com.eao.usecases.newagency;

import java.util.ArrayList;
import java.util.List;

public class NewsPublisher {

    private String news;

    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String news) {
        subscribers.forEach(s -> s.update(news));
    }
}

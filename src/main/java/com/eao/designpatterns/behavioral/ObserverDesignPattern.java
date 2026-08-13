package com.eao.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber("kishor");
        Subscriber subscriber1 = new Subscriber("rahul");
        Subscriber subscriber2 = new Subscriber("hemant");
        YoutubeChannel channel = new YoutubeChannel();
        channel.subscribe(subscriber);
        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.uploadVideo("iPhone unbox");

        channel.unsubscribe(subscriber1);

        channel.uploadVideo("MacBook unbox");

    }
}

class Subscriber {
    private String name;
    public Subscriber(String name) {
        this.name = name;
    }
    void updateNotification(String message){
        System.out.println("Hi "+ name + " "+message);
    }
}

class YoutubeChannel {

    List<String> videos = new ArrayList<>();
    List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void uploadVideo(String video) {
        videos.add(video);
        notify(video);
    }

    public void notify(String video) {
        subscribers.forEach(e-> e.updateNotification(video+" uploaded"));
    }
}

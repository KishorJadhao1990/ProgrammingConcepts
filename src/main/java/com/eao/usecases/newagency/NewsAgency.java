package com.eao.usecases.newagency;

public class NewsAgency {
    public static void main(String[] args) {
        NewsSubscriber subscriber1 = new NewsSubscriber("abhijit");
        NewsSubscriber subscriber2 = new NewsSubscriber("Anand");
        NewsSubscriber subscriber3 = new NewsSubscriber("Namita");

        NewsPublisher newsPublisher = new NewsPublisher();
        newsPublisher.subscribe(subscriber1);
        newsPublisher.subscribe(subscriber2);
        newsPublisher.subscribe(subscriber3);

        System.out.println("Subscriber1 News: "+subscriber1.getNews());
        System.out.println("Subscriber2 News: "+subscriber2.getNews());
        System.out.println("Subscriber3 News: "+subscriber3.getNews());

        newsPublisher.publishNews("This morning is cool!!!");

        System.out.println("After publishing news");

        System.out.println("Subscriber1 News: "+subscriber1.getNews());
        System.out.println("Subscriber2 News: "+subscriber2.getNews());
        System.out.println("Subscriber3 News: "+subscriber3.getNews());

        newsPublisher.unsubscribe(subscriber2);

        newsPublisher.publishNews("No, This morning is hot!!!");

        System.out.println("Subscriber1 News: "+subscriber1.getNews());
        System.out.println("Subscriber2 News: "+subscriber2.getNews());
        System.out.println("Subscriber3 News: "+subscriber3.getNews());
    }
}

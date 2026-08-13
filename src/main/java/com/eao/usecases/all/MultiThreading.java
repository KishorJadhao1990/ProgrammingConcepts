package com.eao.usecases.all;


public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            System.out.println("Thread started ::: " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread ended ::: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(runnable, "1");
        Thread thread2 = new Thread(runnable, "2");
        Thread thread3 = new Thread(runnable, "3");
        Thread thread4 = new Thread(runnable, "4");

        thread1.start();
        thread2.start();
        thread3.start();

        thread2.join();  // finished both threads and then start 4th
        thread3.join();

        thread4.start();

        /*
        thread2.join();  // finished both threads and then start 4th

        thread1.join(2000); // start next thread after 2 second late first finished

        thread1.wait(); // state transfer from running to waiting/blocked
        thread1.wait(2000); // 2 sec maximum time to wait

        thread1.notify(); // notify thread (waiting/blocked) to runnable and then scheduler assign cpu
        thread1.notify(); // notify to all threads (waiting/blocked)

        Thread.yield(); // current thread willing to give way the CPU, notified to waiting threads
        */
    }
}

package com.eao.usecases.all;

import java.io.*;

public class Singleton implements Serializable {

    public static void main(String[] args) throws IOException {
//        System.out.println(new Singleton().hashCode());
//        System.out.println(new Singleton().hashCode());
//        System.out.println(new Singleton().hashCode());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(""));
        objectOutputStream.writeObject(Singleton.getInstance());

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
//        objectInputStream.readObject();

        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
    }

    private String name;
    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance(){
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

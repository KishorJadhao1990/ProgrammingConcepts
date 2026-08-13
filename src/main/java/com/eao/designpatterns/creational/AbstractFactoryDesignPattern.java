package com.eao.designpatterns.creational;

public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        CloudFactory cloudFactory = new AWSCloudFactory();
        cloudFactory.createCompute().create();
        cloudFactory.createStorage().store();

        CloudFactory cloudFactory1 = new AzureCloudFactory();
        cloudFactory1.createCompute().create();
        cloudFactory1.createStorage().store();
    }
}


interface CloudFactory {
    Compute createCompute();
    Storage createStorage();
}

class AWSCloudFactory implements CloudFactory {

    @Override
    public Compute createCompute() {
        return new AWSCompute();
    }

    @Override
    public Storage createStorage() {
        return new AWSStorage();
    }
}

class AzureCloudFactory implements CloudFactory {

    @Override
    public Compute createCompute() {
        return new AzureCompute();
    }

    @Override
    public Storage createStorage() {
        return new AzureStorage();
    }
}


interface Compute {
    void create();
}

interface Storage {
    void store();
}

class AWSCompute implements Compute {

    @Override
    public void create() {
        System.out.println("AWS compute service created");
    }
}

class AWSStorage implements Storage {

    @Override
    public void store() {
        System.out.println("AWS storage service created");
    }
}

class AzureCompute implements Compute {

    @Override
    public void create() {
        System.out.println("Azure compute service created");
    }
}

class AzureStorage implements Storage {

    @Override
    public void store() {
        System.out.println("Azure storage service created");
    }
}




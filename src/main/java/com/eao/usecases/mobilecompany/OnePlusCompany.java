package com.eao.usecases.mobilecompany;

public class OnePlusCompany implements PhoneCompany {

    private final Phone phone;

    OnePlusCompany() {
        phone = new Phone();
    }
    @Override
    public void buildMotherBoard() {
        phone.setCPU("Intel");
        phone.setMemory(4096L);
        phone.setGPU("Snapdragon");
    }
    @Override
    public void buildCameraAssembly() {
        phone.setCamera("14MP");
    }
    @Override
    public void buildDisplayModule() {
        phone.setTouchDisplay(false);
    }
    @Override
    public void buildPhoneAssembly() {
        phone.setBattery(4000);
    }
    @Override
    public void installOS() {

    }
    @Override
    public Phone getPhone() {
        return phone;
    }
}

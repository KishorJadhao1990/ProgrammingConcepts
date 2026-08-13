package com.eao.usecases.mobilecompany;

public class MotorolaCompany implements PhoneCompany {

    private final Phone phone;

    MotorolaCompany() {
        phone = new Phone();
    }
    @Override
    public void buildMotherBoard() {
        phone.setCPU("Intel");
        phone.setMemory(8096L);
        phone.setGPU("Snapdragon");
    }
    @Override
    public void buildCameraAssembly() {
        phone.setCamera("34MP");
    }
    @Override
    public void buildDisplayModule() {
        phone.setTouchDisplay(true);
    }
    @Override
    public void buildPhoneAssembly() {
        phone.setBattery(5000);
    }
    @Override
    public void installOS() {
        phone.setOS("Android");
    }
    @Override
    public Phone getPhone() {
        return phone;
    }
}

package com.eao.usecases.mobilecompany;

public class AppleCompany implements PhoneCompany {

    private final Phone phone;

    AppleCompany() {
        phone = new Phone();
    }
    @Override
    public void buildMotherBoard() {
        phone.setCPU("M1");
        phone.setMemory(8000L);
        phone.setGPU("SilChip");
    }
    @Override
    public void buildCameraAssembly() {
        phone.setCamera("40MP");
    }
    @Override
    public void buildDisplayModule() {
        phone.setTouchDisplay(true);
    }
    @Override
    public void buildPhoneAssembly() {
        phone.setBattery(3900);

    }
    @Override
    public void installOS() {
        phone.setOS("IOS");
    }
    @Override
    public Phone getPhone() {
        return phone;
    }
}

package com.eao.usecases.mobilecompany;

public class DesignEngineer {

    private final PhoneCompany phoneCompany;

    DesignEngineer(PhoneCompany phoneCompany) {
        this.phoneCompany = phoneCompany;
    }
    public void makePhone() {
        this.phoneCompany.buildCameraAssembly();
        this.phoneCompany.buildMotherBoard();
        this.phoneCompany.buildCameraAssembly();
        this.phoneCompany.buildDisplayModule();
        this.phoneCompany.buildPhoneAssembly();
        this.phoneCompany.installOS();
    }
    public Phone getPhone(){
        return this.phoneCompany.getPhone();
    }
}

package com.eao.usecases.mobilecompany;

public class PhoneManufacturer {

    public static void main(String[] args) {
        DesignEngineer designEngineer = new DesignEngineer(new AppleCompany());
        designEngineer.makePhone();
        System.out.println(designEngineer.getPhone());
    }
}

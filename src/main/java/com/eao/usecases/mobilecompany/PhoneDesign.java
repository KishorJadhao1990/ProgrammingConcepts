package com.eao.usecases.mobilecompany;

public interface PhoneDesign {
    void setMemory(Long memory);
    void setGPU(String gpu);
    void setCPU(String cpu);
    void setBattery(Integer battery);
    void setCamera(String camera);
    void setTouchDisplay(Boolean isTouchDis);
    void setOS(String os);
}

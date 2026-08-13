package com.eao.usecases.mobilecompany;

public class Phone implements PhoneDesign {
    private Long memory;
    private String gpu;
    private String cpu;
    private Integer battery;
    private String camera;
    private Boolean touchDisplay;
    private String os;

    @Override
    public void setMemory(Long memory) {
        this.memory = memory;
    }
    @Override
    public void setGPU(String gpu) {
        this.gpu = gpu;
    }
    @Override
    public void setCPU(String cpu) {
        this.cpu = cpu;
    }
    @Override
    public void setBattery(Integer battery) {
        this.battery = battery;
    }
    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }
    @Override
    public void setTouchDisplay(Boolean isTouchDis) {
        this.touchDisplay = isTouchDis;
    }
    @Override
    public void setOS(String os) {
        this.os = os;
    }
}

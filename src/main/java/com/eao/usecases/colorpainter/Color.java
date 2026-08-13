package com.eao.usecases.colorpainter;

public abstract class Color implements Cloneable {

    private String colorName;
    abstract void addColor(); // color functionalities
    @Override
    public Color clone() {
        try {
            return (Color) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

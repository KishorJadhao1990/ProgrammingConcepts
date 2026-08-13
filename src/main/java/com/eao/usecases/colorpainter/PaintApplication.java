package com.eao.usecases.colorpainter;

public class PaintApplication {

    public static void main(String[] args) {
        Color color1 = ColorStore.getColor("RED");
        Color color2 = ColorStore.getColor("BLUE");
        Color color3 = ColorStore.getColor("GREEN");
        Color color4 = ColorStore.getColor("RED");

        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);
        System.out.println(color4);
        // color1 and color4 are RED but new copy is created for it
        color1.addColor();
        color2.addColor();
        color3.addColor();
        color4.addColor();

    }
}

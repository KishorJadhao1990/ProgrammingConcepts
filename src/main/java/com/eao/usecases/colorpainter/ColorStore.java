package com.eao.usecases.colorpainter;


import java.util.HashMap;
import java.util.Map;

public class ColorStore {

    //Store will have collection of Colors
    private static final Map<String, Color> colorMap = new HashMap<>();
    //Stored Prototypes
    static {
        colorMap.put("red", new RedColor());
        colorMap.put("blue", new BlueColor());
        colorMap.put("green", new GreenColor());
    }
    // Will give clone copy of color
    public static Color getColor(String color) {
        return colorMap.get(color).clone();
    }
}

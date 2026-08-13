package com.eao.designpatterns.creational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Design pattern to create same object with same properties whenever requested
public class PrototypeDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        GameWarrier gameWarrier = new GameWarrier();
        gameWarrier.setWapean("sword");
        gameWarrier.setStreagth(80);
        gameWarrier.setPower(100);
        gameWarrier.setSkills("Fast Move");
        System.out.println(gameWarrier.getPower());

        GameWarrier gameWarrier1 = gameWarrier.clone();
        System.out.println(gameWarrier1.getSkills());
        gameWarrier1.setPower(90);

        System.out.println(gameWarrier.getPower());
        System.out.println(gameWarrier1.getPower());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class GameWarrier implements Cloneable {
    private String wapean;
    private Integer streagth;
    private Integer power;
    private String skills;

    @Override
    protected GameWarrier clone() throws CloneNotSupportedException {
        return (GameWarrier) super.clone();
    }
}



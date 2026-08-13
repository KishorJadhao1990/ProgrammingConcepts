package com.eao.designpatterns.creational;

import lombok.ToString;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Coffee coffee = Coffee.builder().water(12).coffee(34).milk(0).build();
        System.out.println(coffee);
    }
}

@ToString
class Coffee {
    private Integer water;
    private Integer coffee;
    private Integer milk;

    public Coffee(Builder builder) {
        this.water = builder.water;
        this.milk = builder.milk;
        this.coffee = builder.coffee;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer water;
        private Integer coffee;
        private Integer milk;

        public Builder water(Integer water) {
            this.water = water;
            return this;
        }

        public Builder coffee(Integer coffee) {
            this.coffee = coffee;
            return this;
        }

        public Builder milk(Integer milk) {
            this.milk = milk;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}

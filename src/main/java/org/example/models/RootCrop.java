package org.example.models;

import java.io.Serializable;

public class RootCrop implements Serializable {
    private String type;
    private double weight;
    private String color;

    RootCrop(RootCropBuilder rootCropBuilder) {
        this.type = rootCropBuilder.type;
        this.weight = rootCropBuilder.weight;
        this.color = rootCropBuilder.color;
    }

    public String getType() {
        return type;
    }
    public Double getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Корнеплод: Тип: %s, Вес: %d, Цвет: %s", getType(), getWeight(), getColor());
    }

    public static class RootCropBuilder {
        private String type;
        private double weight;
        private String color;

        public RootCropBuilder setType(String type){
            this.type = type;
            return this;
        }
        public RootCropBuilder setWeight(double weight){
            this.weight = weight;
            return this;
        }
        public RootCropBuilder setYear(String color){
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }
}

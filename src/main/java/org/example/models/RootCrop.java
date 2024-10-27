package org.example.models;

import java.io.Serializable;
import java.util.Objects;

public class RootCrop implements Serializable {
    private String type;
    private int weight;
    private String color;

    RootCrop(RootCropBuilder rootCropBuilder) {
        this.type = rootCropBuilder.type;
        this.weight = rootCropBuilder.weight;
        this.color = rootCropBuilder.color;
    }

    public String getType() {
        return type;
    }
    public Integer getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootCrop rootCrop = (RootCrop) o;
        return Double.compare(rootCrop.weight, weight) == 0 && Objects.equals(type, rootCrop.type) && Objects.equals(color, rootCrop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    @Override
    public String toString() {
        return String.format("Корнеплод: Тип: %s, Вес: %d, Цвет: %s", getType(), getWeight(), getColor());
    }

    public static class RootCropBuilder {
        private String type;
        private int weight;
        private String color;

        public RootCropBuilder setType(String type){
            this.type = type;
            return this;
        }
        public RootCropBuilder setWeight(int weight){
            this.weight = weight;
            return this;
        }
        public RootCropBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }
}

package ProjectAston;

public class Root_Crop {
    private String nameOfRoot_crop;
    private Double weight;
    private String color;

    public String getNameOfRoot_crop() {
        return nameOfRoot_crop;
    }

    public Double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Root_Crop{" +
                "nameOfRoot_crop='" + nameOfRoot_crop + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder {
        private Root_Crop rootCrop;
        public Builder() {
            rootCrop = new Root_Crop();
        }
        public Builder nameOfRoot_crop(String nameOfRoot_crop) {
            rootCrop.nameOfRoot_crop = nameOfRoot_crop;
            return this;
        }
        public Builder weight(Double weight) {
            rootCrop.weight = weight;
            return this;
        }
        public Builder color(String color) {
            rootCrop.color = color;
            return this;
        }
        public Root_Crop build() {
            return rootCrop;
        }
    }
}

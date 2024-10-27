package ProjectAston;

public class Car {
    private Double power;
    private String model;
    private Integer yearOfProduction;

    public Double getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                " power=" + power +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    public static class Builder {
        private Car car;
        public Builder() {
            car = new Car();
        }
        public Builder power(Double power){
            car.power = power;
            return this;
        }
        public Builder model(String model){
            car.model = model;
            return this;
        }
        public Builder yearOfProduction(Integer yearOfProduction){
            car.yearOfProduction = yearOfProduction;
            return this;
        }
        public Car build(){
            return car;
        }
    }
}

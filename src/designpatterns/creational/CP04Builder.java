package designpatterns.creational;

public class CP04Builder {
    public static void main(String[] args) {
        Car car = new Car.Builder("V8", 4)
                .airbags(6)
                .sunroof(true)
                .color("red")
                .build();

        System.out.println(car);
    }

    // Step 2: Use the Builder to create a Car object

    // Step 1: Create the Car class with its Builder as a static inner class
    public static class Car {
        // Required parameters
        private final String engine;
        private final int wheels;

        // Optional parameters
        private final int airbags;
        private final boolean sunroof;
        private final String color;

        // Private constructor
        private Car(Builder builder) {
            this.engine = builder.engine;
            this.wheels = builder.wheels;
            this.airbags = builder.airbags;
            this.sunroof = builder.sunroof;
            this.color = builder.color;
        }

        // Getters (only getters, no setters for immutability)
        public String getEngine() {
            return engine;
        }

        public int getWheels() {
            return wheels;
        }

        public int getAirbags() {
            return airbags;
        }

        public boolean hasSunroof() {
            return sunroof;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "engine='" + engine + '\'' +
                    ", wheels=" + wheels +
                    ", airbags=" + airbags +
                    ", sunroof=" + sunroof +
                    ", color='" + color + '\'' +
                    '}';
        }

        // Static inner Builder class
        public static class Builder {
            // Required parameters
            private final String engine;
            private final int wheels;

            // Optional parameters initialized to default values
            private int airbags = 0;
            private boolean sunroof = false;
            private String color = "black";

            // Builder constructor with required parameters
            public Builder(String engine, int wheels) {
                this.engine = engine;
                this.wheels = wheels;
            }

            // Methods to set optional parameters and return the builder
            public Builder airbags(int val) {
                airbags = val;
                return this;
            }

            public Builder sunroof(boolean val) {
                sunroof = val;
                return this;
            }

            public Builder color(String val) {
                color = val;
                return this;
            }

            // Build method that creates a new Car instance
            public Car build() {
                return new Car(this);
            }
        }
    }


}

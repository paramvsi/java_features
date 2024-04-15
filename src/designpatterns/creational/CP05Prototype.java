package designpatterns.creational;

public class CP05Prototype {
    public static void main(String[] args) {
        Car car1 = (Car) PrototypeFactory.getPrototype("basicCar");
        System.out.println(car1);

        // Modifying the cloned object
        car1.setModel("Advanced Model");
        car1.setHorsepower(200);
        System.out.println("Modified cloned car: " + car1);

        // Creating another clone
        Car car2 = (Car) PrototypeFactory.getPrototype("basicCar");
        System.out.println(car2);
    }

    // Step 1: Create a Cloneable interface if necessary (or use the built-in Cloneable in Java)
    public interface PrototypeCapable extends Cloneable {
        PrototypeCapable clone() throws CloneNotSupportedException;
    }

    // Step 2: Implement the prototype capable class
    public static class Car implements PrototypeCapable {
        private String model;
        private int horsepower;

        // Constructor
        public Car(String model, int horsepower) {
            this.model = model;
            this.horsepower = horsepower;
        }

        // Getters and Setters
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }

        // Overriding the clone method from the PrototypeCapable interface
        @Override
        public Car clone() throws CloneNotSupportedException {
            System.out.println("Cloning Car object..");
            return (Car) super.clone();
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", horsepower=" + horsepower +
                    '}';
        }
    }

    // Step 4: Usage of the PrototypeFactory

    // Step 3: Prototype Factory to manage prototypes
    public class PrototypeFactory {
        private static java.util.Map<String, PrototypeCapable> prototypes = new java.util.HashMap<>();

        static {
            prototypes.put("basicCar", new Car("Basic Model", 100));
        }

        public static PrototypeCapable getPrototype(String type) {
            try {
                return prototypes.get(type).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}

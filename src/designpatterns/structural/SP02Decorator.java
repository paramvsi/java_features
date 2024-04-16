package designpatterns.structural;

public class SP02Decorator {
    public static void main(String[] args) {
        Coffee myCoffee = new BasicCoffee();
        System.out.println(myCoffee.getDescription() + " Cost: " + myCoffee.getCost());

        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " Cost: " + myCoffee.getCost());

        myCoffee = new SugarDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " Cost: " + myCoffee.getCost());
    }

    interface Coffee {
        String getDescription();

        double getCost();
    }

    static class BasicCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Basic Coffee";
        }

        @Override
        public double getCost() {
            return 20;
        }
    }

    abstract static class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        public String getDescription() {
            return decoratedCoffee.getDescription();
        }

        public double getCost() {
            return decoratedCoffee.getCost();
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Milk";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 5;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 2;
        }
    }


}

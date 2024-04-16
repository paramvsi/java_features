package designpatterns.structural;

public class SP01Adaptor {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        temperature.setTemperature(30);
        TemperatureInfo tempInfo = new TemperatureAdapter(temperature);

        System.out.println("Temp in C: " + tempInfo.getTemperatureInC());
        System.out.println("Temp in F: " + tempInfo.getTemperatureInF());

        tempInfo.setTemperatureInF(86);
        System.out.println("Temp in C after new setting: " + tempInfo.getTemperatureInC());
        System.out.println("Temp in F: " + tempInfo.getTemperatureInF());
    }

    interface TemperatureInfo {
        double getTemperatureInF();

        void setTemperatureInF(double temperatureInF);

        double getTemperatureInC();

        void setTemperatureInC(double temperatureInC);
    }

    static class Temperature {
        private double temperatureInC;

        public double getTemperature() {
            return temperatureInC;
        }

        public void setTemperature(double temperatureInC) {
            this.temperatureInC = temperatureInC;
        }
    }

    static class TemperatureAdapter implements TemperatureInfo {
        private Temperature temperature;

        public TemperatureAdapter(Temperature temperature) {
            this.temperature = temperature;
        }

        @Override
        public double getTemperatureInF() {
            return cToF(temperature.getTemperature());
        }

        @Override
        public void setTemperatureInF(double temperatureInF) {
            temperature.setTemperature(fToC(temperatureInF));
        }

        @Override
        public double getTemperatureInC() {
            return temperature.getTemperature();
        }

        @Override
        public void setTemperatureInC(double temperatureInC) {
            temperature.setTemperature(temperatureInC);
        }

        private double cToF(double c) {
            return c * 9 / 5 + 32;
        }

        private double fToC(double f) {
            return (f - 32) * 5 / 9;
        }
    }
}

package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class BP01Observer {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    public interface Observer {
        void update(float temperature, float humidity, float pressure);
    }

    public interface Subject {
        void registerObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObservers();
    }

    public static class CurrentConditionsDisplay implements Observer {
        private float temperature;
        private float humidity;

        @Override
        public void update(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            display();
        }

        public void display() {
            System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
        }
    }

    public static class StatisticsDisplay implements Observer {
        private float maxTemp = 0.0f;
        private float minTemp = 200;
        private float tempSum = 0.0f;
        private int numReadings;

        @Override
        public void update(float temperature, float humidity, float pressure) {
            tempSum += temperature;
            numReadings++;

            if (temperature > maxTemp) {
                maxTemp = temperature;
            }

            if (temperature < minTemp) {
                minTemp = temperature;
            }

            display();
        }

        public void display() {
            System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
        }
    }

    public static class WeatherData implements Subject {
        private List<Observer> observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherData() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            int i = observers.indexOf(o);
            if (i >= 0) {
                observers.remove(i);
            }
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(temperature, humidity, pressure);
            }
        }

        public void measurementsChanged() {
            notifyObservers();
        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            measurementsChanged();
        }
    }


}

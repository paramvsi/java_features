package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Th07CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> flightFuture = CompletableFuture.supplyAsync(Th07CompletableFutureExample::getFlightDetails);
        CompletableFuture<String> hotelFuture = CompletableFuture.supplyAsync(Th07CompletableFutureExample::getHotelDetails);
        CompletableFuture<String> carRentalFuture = CompletableFuture.supplyAsync(Th07CompletableFutureExample::getCarRentalDetails);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(flightFuture, hotelFuture, carRentalFuture);

        combinedFuture.thenRun(() -> {
            try {
                String flightDetails = flightFuture.get();
                String hotelDetails = hotelFuture.get();
                String carRentalDetails = carRentalFuture.get();

                System.out.println("Travel Package Details:");
                System.out.println(flightDetails);
                System.out.println(hotelDetails);
                System.out.println(carRentalDetails);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        combinedFuture.join(); // Wait for all futures to complete
    }

    static String getFlightDetails() {
        // Simulate an API call to fetch flight details
        return "Flight: ABC Airlines, Departure: 10:00 AM";
    }

    static String getHotelDetails() {
        // Simulate an API call to fetch hotel details
        return "Hotel: Grand Hotel, Check-in: 2:00 PM";
    }

    static String getCarRentalDetails() {
        // Simulate an API call to fetch car rental details
        return "Car Rental: XYZ Cars, Pickup: 12:00 PM";
    }
}


import java.util.ArrayList;
import java.util.Scanner;

class TripDestination {
    String locationName;
    String travelDate;
    String travelPreferences;
    double estimatedBudget;

    public TripDestination(String locationName, String travelDate, String travelPreferences, double estimatedBudget) {
        this.locationName = locationName;
        this.travelDate = travelDate;
        this.travelPreferences = travelPreferences;
        this.estimatedBudget = estimatedBudget;
    }

    @Override
    public String toString() {
        return "Destination: " + locationName + "\n" +
                "Date: " + travelDate + "\n" +
                "Preferences: " + travelPreferences + "\n" +
                "Budget: ₹" + estimatedBudget;
    }
}

public class Task_2 {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<TripDestination> travelItinerary = new ArrayList<>();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    addTripDestination(inputScanner, travelItinerary);
                    break;
                case 2:
                    displayItinerary(travelItinerary);
                    break;
                case 3:
                    computeTotalBudget(travelItinerary);
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    inputScanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void addTripDestination(Scanner inputScanner, ArrayList<TripDestination> travelItinerary) {
        System.out.print("\nEnter the destination name: ");
        String locationName = inputScanner.nextLine();
        System.out.print("Enter the travel date (e.g., YYYY-MM-DD): ");
        String travelDate = inputScanner.nextLine();
        System.out.print("Enter your preferences (e.g., sightseeing, relaxation, adventure): ");
        String travelPreferences = inputScanner.nextLine();
        System.out.print("Enter the budget for this destination: ");
        double estimatedBudget = inputScanner.nextDouble();
        inputScanner.nextLine(); // Consume newline

        TripDestination newDestination = new TripDestination(locationName, travelDate, travelPreferences, estimatedBudget);
        travelItinerary.add(newDestination);
        System.out.println("Destination added successfully!\n");
    }

    private static void displayItinerary(ArrayList<TripDestination> travelItinerary) {
        if (travelItinerary.isEmpty()) {
            System.out.println("\nYour itinerary is empty. Add some destinations first.\n");
        } else {
            System.out.println("\n===== Your Travel Itinerary =====");
            for (int i = 0; i < travelItinerary.size(); i++) {
                System.out.println("\nDestination " + (i + 1) + ":");
                System.out.println(travelItinerary.get(i));
            }
        }
    }

    private static void computeTotalBudget(ArrayList<TripDestination> travelItinerary) {
        if (travelItinerary.isEmpty()) {
            System.out.println("\nYour itinerary is empty. Add some destinations first.\n");
        } else {
            double totalEstimatedBudget = 0;
            for (TripDestination destination : travelItinerary) {
                totalEstimatedBudget += destination.estimatedBudget;
            }
            System.out.println("\nTotal Budget for your trip: ₹" + totalEstimatedBudget + "\n");
        }
    }
}

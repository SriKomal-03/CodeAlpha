import java.util.ArrayList;
import java.util.Scanner;

class HotelRoom {
    int roomId;
    String roomType;
    boolean availability;
    double roomPrice;

    public HotelRoom(int roomId, String roomType, boolean availability, double roomPrice) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.availability = availability;
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId + " | Type: " + roomType + " | Price: ₹" + roomPrice + " | Available: " + (availability ? "Yes" : "No");
    }
}

class GuestReservation {
    String guestName;
    int reservedRoomId;
    double totalPayment;

    public GuestReservation(String guestName, int reservedRoomId, double totalPayment) {
        this.guestName = guestName;
        this.reservedRoomId = reservedRoomId;
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Guest Name: " + guestName + " | Room ID: " + reservedRoomId + " | Payment: ₹" + totalPayment;
    }
}

public class Task_3 {

    static ArrayList<HotelRoom> hotelRooms = new ArrayList<>();
    static ArrayList<GuestReservation> bookingList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        initializeHotelRooms();

        System.out.println("Welcome to the Hotel Booking System!");

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    displayAvailableRooms();
                    break;
                case 2:
                    createReservation(inputScanner);
                    break;
                case 3:
                    displayReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Booking System. Goodbye!");
                    inputScanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void initializeHotelRooms() {
        hotelRooms.add(new HotelRoom(101, "Single", true, 50.0));
        hotelRooms.add(new HotelRoom(102, "Single", true, 50.0));
        hotelRooms.add(new HotelRoom(201, "Double", true, 100.0));
        hotelRooms.add(new HotelRoom(202, "Double", true, 100.0));
        hotelRooms.add(new HotelRoom(301, "Suite", true, 200.0));
    }

    private static void displayAvailableRooms() {
        System.out.println("\n===== Available Rooms =====");
        for (HotelRoom room : hotelRooms) {
            if (room.availability) {
                System.out.println(room);
            }
        }
    }

    private static void createReservation(Scanner inputScanner) {
        System.out.println("\n===== Make a Reservation =====");
        System.out.print("Enter your name: ");
        String guestFullName = inputScanner.nextLine();
        System.out.print("Enter room ID to reserve: ");
        int selectedRoomId = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline

        for (HotelRoom room : hotelRooms) {
            if (room.roomId == selectedRoomId && room.availability) {
                room.availability = false;
                bookingList.add(new GuestReservation(guestFullName, selectedRoomId, room.roomPrice));
                System.out.println("Reservation successful!\n");
                return;
            }
        }
        System.out.println("Room not available or invalid room ID.\n");
    }

    private static void displayReservations() {
        System.out.println("\n===== Reservations =====");
        if (bookingList.isEmpty()) {
            System.out.println("No reservations found.\n");
        } else {
            for (GuestReservation reservation : bookingList) {
                System.out.println(reservation);
            }
        }
    }
}

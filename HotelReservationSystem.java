import java.util.*;

class Room {

    private int roomNo;
    private String type;
    private double price;
    private boolean available;

    public Room(int roomNo,
                String type,
                double price) {

        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.available = true;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(
            boolean available) {

        this.available = available;
    }

    @Override
    public String toString() {

        return roomNo
                + " "
                + type
                + " ₹"
                + price
                + " "
                + (available
                ? "Available"
                : "Booked");
    }
}

class Customer {

    private int id;
    private String name;

    public Customer(
            int id,
            String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {

    private int bookingId;
    private Customer customer;
    private Room room;
    private int days;
    private double amount;

    public Reservation(
            int bookingId,
            Customer customer,
            Room room,
            int days) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.days = days;
        this.amount =
                room.getPrice() * days;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {

        return "\nBooking ID : "
                + bookingId
                + "\nCustomer : "
                + customer.getName()
                + "\nRoom : "
                + room.getRoomNo()
                + " ("
                + room.getType()
                + ")"
                + "\nDays : "
                + days
                + "\nAmount : ₹"
                + amount;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms =
            new ArrayList<>();

    static ArrayList<Reservation>
            bookings =
            new ArrayList<>();

    static Scanner sc =
            new Scanner(System.in);

    static int bookingId = 1000;

    public static void main(
            String[] args) {

        rooms.add(
                new Room(
                        101,
                        "Standard",
                        1000));

        rooms.add(
                new Room(
                        102,
                        "Standard",
                        1000));

        rooms.add(
                new Room(
                        201,
                        "Deluxe",
                        2500));

        rooms.add(
                new Room(
                        202,
                        "Deluxe",
                        2500));

        rooms.add(
                new Room(
                        301,
                        "Suite",
                        5000));

        while (true) {

            System.out.println(
                    "\n====== HOTEL ======");

            System.out.println(
                    "1.Search Rooms");

            System.out.println(
                    "2.Book Room");

            System.out.println(
                    "3.Cancel Booking");

            System.out.println(
                    "4.View Booking");

            System.out.println(
                    "5.Exit");

            int choice =
                    sc.nextInt();

            switch (choice) {

                case 1:
                    showRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

    static void showRooms() {

        System.out.println(
                "\nAvailable Rooms");

        for (Room r : rooms)
            System.out.println(r);
    }

    static void bookRoom() {

        System.out.print(
                "Customer ID: ");

        int id =
                sc.nextInt();

        sc.nextLine();

        System.out.print(
                "Customer Name: ");

        String name =
                sc.nextLine();

        System.out.print(
                "Room Number: ");

        int roomNo =
                sc.nextInt();

        System.out.print(
                "Days: ");

        int days =
                sc.nextInt();

        for (Room r : rooms) {

            if (r.getRoomNo()
                    == roomNo
                    &&
                    r.isAvailable()) {

                double payment =
                        r.getPrice()
                                * days;

                System.out.println(
                        "Payment Amount ₹"
                                + payment);

                System.out.print(
                        "Pay? (Y/N): ");

                char pay =
                        sc.next()
                                .charAt(0);

                if (pay == 'Y'
                        || pay == 'y') {

                    r.setAvailable(
                            false);

                    Reservation res =
                            new Reservation(
                                    ++bookingId,
                                    new Customer(
                                            id,
                                            name),
                                    r,
                                    days);

                    bookings.add(
                            res);

                    System.out.println(
                            "Booked Successfully");

                    System.out.println(
                            "Booking ID: "
                                    + bookingId);

                    return;
                }
            }
        }

        System.out.println(
                "Room unavailable");
    }

    static void cancelBooking() {

        System.out.print(
                "Booking ID: ");

        int id =
                sc.nextInt();

        Iterator<Reservation>
                it =
                bookings.iterator();

        while (it.hasNext()) {

            Reservation r =
                    it.next();

            if (r.getBookingId()
                    == id) {

                r.getRoom()
                        .setAvailable(
                                true);

                it.remove();

                System.out.println(
                        "Booking Cancelled");

                return;
            }
        }

        System.out.println(
                "Booking not found");
    }

    static void viewBookings() {

        for (Reservation r
                : bookings) {

            System.out.println(r);
        }
    }
}
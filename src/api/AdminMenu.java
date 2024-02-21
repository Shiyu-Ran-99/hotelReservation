package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void main() {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            try {
                System.out.println("------------------------------");
                System.out.println("1. See all Customers");
                System.out.println("2. See all Rooms");
                System.out.println("3. See all Reservations");
                System.out.println("4. Add a Room");
                System.out.println("5. Back to Main Menu");
                System.out.println("------------------------------");
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput == 1) {
                    Collection<Customer> seeAllCustomers = AdminResource.getALlCustomers();
                    for (Customer customer: seeAllCustomers) {
                        System.out.println(customer.toString());
                    }
                    System.out.println("\n");
                }

                if (userInput == 2) {
                    Collection<IRoom> allRooms = AdminResource.getAllRooms();
                    for (IRoom room: allRooms) {
                        room.toString();
                    }
                    System.out.println("\n");
                }

                if (userInput == 3) {
                    AdminResource.displayAllReservations();
                    System.out.println("\n");
                }

                if (userInput == 4) {
                    Scanner newRoomInput = new Scanner(System.in);
                    System.out.println("Enter new room number: ");
                    String roomNumber = newRoomInput.nextLine();
                    System.out.println("Enter room price: ");
                    Double roomPrice = Double.parseDouble(newRoomInput.nextLine());
                    System.out.println("Enter room type (SINGLE / DOUBLE): ");
                    RoomType roomType = RoomType.valueOf(newRoomInput.nextLine());

                    List<IRoom> roomAddList = new ArrayList<>();
                    IRoom newRoom = new Room(roomNumber, roomPrice, roomType);
                    roomAddList.add(newRoom);
                    AdminResource.addRoom(roomAddList);

                    System.out.println("\n");
                }

                if (userInput == 5) {
                    keepRunning = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1 to 5. \n");
            }
        }
    }
}
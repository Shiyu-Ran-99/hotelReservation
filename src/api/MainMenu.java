package api;

import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            try {
                System.out.println("------------------------------");
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservation");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("------------------------------");
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput == 1) {
                    Scanner inputDate = new Scanner(System.in);

                    System.out.println("Enter check in date: yyyy-MM-dd");
                    String date1 = inputDate.nextLine();
                    Date checkIn = null;
                    try {
                        checkIn = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter check out date: yyyy-MM-dd");
                    String date2 = scanner.nextLine();
                    Date checkOut = null;
                    try {
                        checkOut = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    HotelResource.findARoom(checkIn, checkOut);
                    System.out.println("Do you want to make the reservation? (y/n) ");
                    String makeReservation = scanner.nextLine();

                    if (makeReservation.equals("y")) {
                        System.out.println("Please enter a room number from the list: ");
                        String roomNum = scanner.nextLine();
                        System.out.println("Please enter your email: ");
                        String reservationEmail = scanner.nextLine();
                        ReservationService.reserveARoom(HotelResource.getCustomer(reservationEmail), ReservationService.getARoom(roomNum), checkIn, checkOut);
                        System.out.println("Your reservation is completed");
                        System.out.println(ReservationService.getCustomersReservation(HotelResource.getCustomer(reservationEmail)));
                    } else {
                        mainMenu();
                    }
                    continue;
                }
                if (userInput == 2) {
                    Scanner inputEmail = new Scanner(System.in);
                    System.out.println("Enter your email:");
                    String email = inputEmail.nextLine();
                    System.out.println(ReservationService.getCustomersReservation(HotelResource.getCustomer(email)));
                }

                if (userInput == 3) {
                    Scanner inputAcc = new Scanner(System.in);
                    System.out.println("Enter your email:");
                    String email = inputAcc.nextLine();
                    System.out.println("Enter your first name:");
                    String firstname = inputAcc.nextLine();
                    System.out.println("Enter your last name:");
                    String lastname = inputAcc.nextLine();
                    HotelResource.createACustomer(email, firstname, lastname);
                    mainMenu();
                }

                if (userInput == 4) {
                    AdminMenu.main();
                    continue;
                }

                if (userInput == 5) {
                    keepRunning = false;
                }
            }
            catch (Exception ex) {
                System.out.println("\nInvalid input. Please enter 1 to 5.\n");
            }
        }
    }
}
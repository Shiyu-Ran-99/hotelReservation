package service;

import model.*;

import java.util.*;

public class ReservationService {
    static Map<String, IRoom> rooms = new HashMap<String, IRoom>();
    static Collection<Reservation> reservationList = new HashSet<>();

    public static void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public static IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate,checkOutDate);
        reservationList.add(reservation);
        return reservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> rooms = getAllRooms();

        for (Reservation reservation : reservationList) {
            if (checkInDate.before(reservation.getCheckOutDate()) || checkOutDate.after(reservation.getCheckInDate())) {
                rooms.remove(reservation.getRoom());
            }
        }

        return rooms.stream().toList();

    }

    public static Collection<Reservation> getCustomersReservation (Customer customer) {
        Collection<Reservation> reservationCollection = new ArrayList<Reservation>();
        for (Reservation reservation: reservationList) {
            if (reservation.getCustomer() == customer) {
                reservationCollection.add(reservation);
            }
        }
        return reservationCollection;
    }

    public static void printAllReservation(){
            System.out.println(reservationList);
    }

    public static Collection<IRoom> getAllRooms(){
        System.out.println(rooms.values());
        return rooms.values();
    }
}
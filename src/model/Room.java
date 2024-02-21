package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private final RoomType enumeration;
    private Boolean reserved;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.reserved = reserved;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return reserved;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " Price: " + price + " Room Type: " + enumeration + "\n" ;
    }
}
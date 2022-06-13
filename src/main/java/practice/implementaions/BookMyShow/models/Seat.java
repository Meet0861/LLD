package practice.implementaions.BookMyShow.models;

import practice.implementaions.BookMyShow.Enum.SeatStatus;
import practice.implementaions.BookMyShow.Enum.SeatType;

public class Seat {
    private int id;
    private int row;
    private int col;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private double price;
}

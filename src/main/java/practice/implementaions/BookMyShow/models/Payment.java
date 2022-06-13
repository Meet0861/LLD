package practice.implementaions.BookMyShow.models;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.BookMyShow.Enum.PaymentStatus;

@Getter
@Setter
public class Payment {
    private int id;
    private String transactionID;
    private double amount;
    private PaymentStatus paymentStatus;
}

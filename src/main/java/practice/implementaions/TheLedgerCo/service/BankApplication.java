package practice.implementaions.TheLedgerCo.service;

import com.example.geektrust.exceptions.InvalidInputException;

/**
 * Bank Application
 *
 * @author manmeetkaur
 */
public interface BankApplication {

    void getLoan(String bankName, String borrowerName, double principleAmount, int noOfYears, int rateOfInterest);

    void submitPayment(String bankName, String borrowerName, double lumpSum, int emiNo);

    double getRemainingBalance(String bankName, String borrowerName, int emiNo) throws InvalidInputException;

    double getAmountPaid(String bankName, String borrowerName, int emiNo) throws InvalidInputException;

    int getRemainingEMIs(String bankName, String borrowerName, int emiNo) throws InvalidInputException;
}

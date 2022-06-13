package practice.implementaions.TheLedgerCo.service;

import com.example.geektrust.enums.CommandType;
import com.example.geektrust.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Bank factory.
 */
public class BankFactory {


    /**
     * Process file data.
     *
     * @param commands the input commands to execute
     */
    public static void processFileData(ArrayList<String> commands) {
        BankApplication bankApplication = new BankApplicationImpl();
        String bankName;
        String borrowerName;
        for (String command : commands) {
            List<String> values = Arrays.asList(command.split(" "));
            CommandType commandType = CommandType.valueOf(values.get(0));
            try {
                switch (commandType) {
                    case LOAN:
                        bankName = values.get(1);
                        borrowerName = values.get(2);
                        double principle = Double.parseDouble(values.get(3));
                        int noOfYears = Integer.parseInt(values.get(4));
                        int rateOfInterest = Integer.parseInt(values.get(5));
                        bankApplication.getLoan(bankName, borrowerName, principle, noOfYears, rateOfInterest);
                        break;

                    case PAYMENT:
                        bankName = values.get(1);
                        borrowerName = values.get(2);
                        double lumpSum = Double.parseDouble(values.get(3));
                        int emiNo = Integer.parseInt(values.get(4));
                        bankApplication.submitPayment(bankName, borrowerName, lumpSum, emiNo);
                        break;

                    case BALANCE:
                        bankName = values.get(1);
                        borrowerName = values.get(2);
                        int emiNo2 = Integer.parseInt(values.get(3));
                        System.out.println(
                                        bankName + " " +
                                        borrowerName + " " +
                                        bankApplication.getAmountPaid(bankName, borrowerName, emiNo2) + " " +
                                        bankApplication.getRemainingEMIs(bankName, borrowerName, emiNo2)
                        );
                        break;
                }
            } catch (InvalidInputException ex) {
                System.err.println("invalid input for user : " + commandType);
            }
        }
    }
}

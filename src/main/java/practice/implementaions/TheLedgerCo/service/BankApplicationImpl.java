package practice.implementaions.TheLedgerCo.service;


import practice.implementaions.TheLedgerCo.enums.LoanType;
import practice.implementaions.TheLedgerCo.exceptions.InvalidInputException;
import practice.implementaions.TheLedgerCo.models.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * The type Bank application.
 *
 * @author manmeetkaur
 */
public class BankApplicationImpl implements BankApplication {

    /**
     * The User loan map.
     */
    private static Map<String, List<Loan>> userLoanMap;
    /**
     * The User payment map.
     */
    private static Map<String, List<Payment>> userPaymentMap;


    /**
     * Instantiates a new Bank application.
     */
    public BankApplicationImpl() {
        userLoanMap = new HashMap<>();
        userPaymentMap = new HashMap<>();
    }


    /**
     * Gets loan.
     *
     * @param bankName        the bank name
     * @param borrower        the borrower
     * @param principleAmount the principle amount
     * @param noOfYears       the no of years
     * @param rateOfInterest  the rate of interest
     */
    @Override
    public void getLoan(String bankName, String borrower, double principleAmount, int noOfYears, int rateOfInterest) {
        Interest interest = new Interest(rateOfInterest, noOfYears, principleAmount);
        Bank bank = new Bank(bankName);
        int monthlyInstallmentAfterCalculation = getMonthlyInstallmentAfterCalculation(principleAmount, noOfYears, rateOfInterest);
        int totalNoOfInstallments = getTotalInstallments(monthlyInstallmentAfterCalculation, interest.getInterest(), principleAmount);
        EMI emi = new EMI(0, monthlyInstallmentAfterCalculation, totalNoOfInstallments, 0);
        /* As we are not getting loan type , so setting it as default as PERSONAL */
        Loan loan = new Loan(bank, borrower, principleAmount, interest, noOfYears, LoanType.PERSONAL, emi, rateOfInterest);
        if (userLoanMap.containsKey(borrower)) {
            userLoanMap.get(borrower).add(loan);
        } else {
            userLoanMap.put(borrower, new ArrayList<>(Collections.singletonList(loan)));
        }
    }


    /**
     * Submit payment.
     *
     * @param bankName the bank name
     * @param user     the user
     * @param lumpSum  the lump sum
     * @param emiNo    the emi no
     */
    @Override
    public void submitPayment(String bankName, String user, double lumpSum, int emiNo) {
        Payment payment = new Payment(bankName, user, userLoanMap.get(user).get(0), lumpSum, emiNo);
        if (userPaymentMap.containsKey(user)) {
            userPaymentMap.get(user).add(payment);
        } else {
            userPaymentMap.put(user, new ArrayList<>(Collections.singletonList(payment)));
        }
        userLoanMap.get(user).get(0).getEmi().setEmiNo(emiNo);
        userLoanMap.get(user).get(0).getEmi().setNoOfInstallmentsDone(emiNo);
        userLoanMap.get(user).get(0).getEmi().setNoOfInstallments(getTotalInstallments(
                getMonthlyInstallmentAfterCalculation(payment.getLoan().getPrincipal(), payment.getLoan().getNoOfYears(), payment.getLoan().getRateOfInterest()),
                payment.getLoan().getInterest().getInterest(),
                payment.getLoan().getPrincipal() - lumpSum)
        );
    }

    /**
     * Gets remaining balance.
     *
     * @param bankName     the bank name
     * @param borrowerName the borrower name
     * @param emiNo        the emi no
     * @return the remaining balance
     * @throws InvalidInputException the invalid input exception
     */
    @Override
    public double getRemainingBalance(String bankName, String borrowerName, int emiNo) throws InvalidInputException {
        if (userLoanMap.containsKey(borrowerName)) {
            List<Loan> loans = userLoanMap.get(borrowerName);
            if (!loans.isEmpty()) {
                /* this is a list, but as per the question we don't have any identification(id) for the loan and
                considering one loan per customer so taking 1st entry only */
                Loan loan = loans.get(0);
                double principle = loan.getPrincipal();
                return principle - getAmountPaid(bankName, borrowerName, emiNo);
            }
        } else {
            throw new InvalidInputException("USER DOESN'T HAS ANY LOAN :", borrowerName);
        }
        return -1;
    }

    /**
     * Gets amount paid.
     *
     * @param bankName     the bank name
     * @param borrowerName the borrower name
     * @param emiNo        the emi no
     * @return the amount paid
     * @throws InvalidInputException the invalid input exception
     */
    @Override
    public double getAmountPaid(String bankName, String borrowerName, int emiNo) throws InvalidInputException {
        if (userLoanMap.containsKey(borrowerName)) {
            List<Loan> loans = userLoanMap.get(borrowerName);
            if (!loans.isEmpty()) {
                /* this is a list, but as per the question we dont have any identification(id) for the loan and
                considering one loan per customer so taking 1st entry only */
                Loan loan = loans.get(0);
                if (userPaymentMap.containsKey(borrowerName)) {
                    List<Payment> paymentList = userPaymentMap.get(borrowerName)
                                                                .stream()
                                                                .filter(payment -> payment.getLoan().equals(loan))
                                                                .collect(Collectors.toList());
                    return (paymentList.stream()
                                        .filter(payment -> payment.getEmiNo()<=emiNo)
                                        .mapToDouble(Payment::getLumpSumAmount)
                                        .sum() +
                            (emiNo * loans.get(0).getEmi().getMonthlyInstallment()));
                } else {
                    return (emiNo * loans.get(0).getEmi().getMonthlyInstallment());
                }
            }
        } else {
            throw new InvalidInputException("USER DOESN'T HAS ANY LOAN :", borrowerName);
        }
        return 0;
    }

    /**
     * Gets remaining em is.
     *
     * @param bankName     the bank name
     * @param borrowerName the borrower name
     * @param emiNo        the emi no
     * @return the remaining em is
     * @throws InvalidInputException the invalid input exception
     */
    @Override
    public int getRemainingEMIs(String bankName, String borrowerName, int emiNo) throws InvalidInputException {
        if(userLoanMap.containsKey(borrowerName)){
            Loan loan = userLoanMap.get(borrowerName).get(0);
            double remainingBal = getRemainingBalance(bankName, borrowerName, emiNo);
            return getTotalInstallments(loan.getEmi().getMonthlyInstallment(),
                                        loan.getInterest().getInterest(),
                                        remainingBal
            );
        }
        else {
            throw new InvalidInputException("USER DOESN'T HAS ANY LOAN :", borrowerName);
        }
    }

    /**
     * Gets total installments.
     *
     * @param monthlyInstallmentAfterCalculation the monthly installment after calculation
     * @param interest                           the interest
     * @param principleAmount                    the principle amount
     * @return the total installments
     */
    private int getTotalInstallments(double monthlyInstallmentAfterCalculation, double interest, double principleAmount) {
        return (int)(Math.ceil((principleAmount + interest) / monthlyInstallmentAfterCalculation));
    }

    /**
     * Gets monthly installment after calculation.
     *
     * @param principleAmount the principle amount
     * @param noOfYears       the no of years
     * @param rateOfInterest  the rate of interest
     * @return the monthly installment after calculation
     */
    private int getMonthlyInstallmentAfterCalculation(double principleAmount, int noOfYears, int rateOfInterest) {
        float emi;
        float monthlyInterest = (float) rateOfInterest;
        float months = (float) noOfYears;
        float principle = (float) principleAmount;
        monthlyInterest = monthlyInterest / (12 * 100); // one month interest
        months = months * 12; // one month period
        emi = ((principle * monthlyInterest * months) + principle )/months;

        return (int)(Math.ceil(emi));
    }

}

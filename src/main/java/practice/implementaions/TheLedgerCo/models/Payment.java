package practice.implementaions.TheLedgerCo.models;

import lombok.Getter;

@Getter
public class Payment {
    private String bankName;
    private String borrower;
    private Loan loan;
    private double lumpSumAmount;
    private int emiNo;

    public Payment(String bankName, String borrower, Loan loan, double lumpSumAmount, int emiNo) {
        this.bankName = bankName;
        this.borrower = borrower;
        this.loan = loan;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getLumpSumAmount() {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(double lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }
}

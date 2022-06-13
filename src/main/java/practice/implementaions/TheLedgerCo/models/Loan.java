package practice.implementaions.TheLedgerCo.models;


import lombok.Getter;
import lombok.Setter;
import practice.implementaions.TheLedgerCo.enums.LoanType;

@Getter
@Setter
public class Loan {
    private static int id = 0;
    private Bank bank;
    private String borrower;
    private double principal;
    private Interest interest;
    private int noOfYears;
    private LoanType loanType;
    private EMI emi;
    private int rateOfInterest;

    public Loan(Bank bankName, String borrower, double principal, Interest interest, int noOfYears, LoanType loanType, EMI emi, int rateOfInterest) {
        this.interest = interest;
        this.loanType = loanType;
        this.emi = emi;
        id = ++id;
        this.bank = bankName;
        this.borrower = borrower;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    //this was added to handle multiple loans per customer,
    //but as there is no use case of this in this ques so not using it
    public int getId() {
        return id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public EMI getEmi() {
        return emi;
    }

    public void setEmi(EMI emi) {
        this.emi = emi;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }
}

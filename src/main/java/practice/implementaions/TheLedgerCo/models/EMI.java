package practice.implementaions.TheLedgerCo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EMI {
    private int emiNo;
    private int monthlyInstallment;
    private int noOfInstallments;
    private int noOfInstallmentsDone;


    public EMI(int emiNo, int monthlyInstallment, int noOfInstallments, int noOfInstallmentsDone) {
        this.emiNo = emiNo;
        this.monthlyInstallment = monthlyInstallment;
        this.noOfInstallments = noOfInstallments;
        this.noOfInstallmentsDone = noOfInstallmentsDone;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }

    public int getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(int monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public int getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(int noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    public int getNoOfInstallmentsDone() {
        return noOfInstallmentsDone;
    }

    public void setNoOfInstallmentsDone(int noOfInstallmentsDone) {
        this.noOfInstallmentsDone = noOfInstallmentsDone;
    }
}

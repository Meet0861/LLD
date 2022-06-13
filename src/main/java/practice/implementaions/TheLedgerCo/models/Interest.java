package practice.implementaions.TheLedgerCo.models;

public class Interest {
    private int rate;
    private int noOfYears;
    private double principal;

    public Interest(int rate, int noOfYears, double principal) {
        this.rate = rate;
        this.noOfYears = noOfYears;
        this.principal = principal;
    }

    public double getInterest(){
        return ((rate*principal) /100)*noOfYears;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }
}

package practice.implementaions.CallCenter;

public class Call {
    public Caller getCaller() {
        return caller;
    }

    private Caller caller;
    private Rank rank;
    private Employee employee;
    private CallFlow callStatus = CallFlow.NOT_STARTED;


    public Call(Caller caller, Rank rank) {
        this.caller = caller;
        this.rank = rank;
    }

    public void setHandler(Employee employee){
        this.employee = employee;
        this.callStatus = CallFlow.STARTED;
    }

    public Employee getHandler(){
        return employee;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank r){
        this.rank = r;
    }

    public void disconnect(){
        System.out.println("Thanks for calling..."+ caller.getName());
        this.callStatus = CallFlow.ENDED;
    }

    public CallFlow getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(CallFlow callStatus) {
        this.callStatus = callStatus;
    }

    public Rank incrementRank(){
        if(this.rank ==Rank.RESPONDANT)
            this.rank = Rank.MANAGER;
        else if(this.rank == Rank.MANAGER)
            this.rank = Rank.DIRECTOR;
        return rank;
    }

}

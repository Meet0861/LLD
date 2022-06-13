package practice.implementaions.CallCenter;

public abstract class Employee {

    protected int id;
    private String name;
    private boolean isAvailable = true;

    public Rank getRank() {
        return rank;
    }

    private Rank rank;
    private Call currentCall;

    protected abstract boolean attendOrEscalateCall(Call call);

    protected Employee(int id, String name, Rank rank){
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public void receiveCall(Call call){
        setUnavailable();
        this.currentCall = call;
        call.setCallStatus(CallFlow.STARTED);
        call.setHandler(this);
    }

    public void callCompleted(){
        if(currentCall!=null){
            currentCall.disconnect();
            currentCall.setCallStatus(CallFlow.ENDED);
            currentCall = null;
            setAvailable();
        }
    }


    public void setUnavailable(){
        isAvailable = false;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(){
        isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

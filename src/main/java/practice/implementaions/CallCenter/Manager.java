package practice.implementaions.CallCenter;

public class Manager extends Employee {

    private Employee director;
    public Manager(int id, String name, Employee director) {
        super(id, name, Rank.MANAGER);
        this.director = director;
    }

    @Override
    protected boolean attendOrEscalateCall(Call call) {
        if (this.isAvailable() && call.getCallStatus() == CallFlow.NOT_STARTED) {
            this.receiveCall(call);
            return true;
        } else {
            call.incrementRank();
            return false;
        }
    }
}

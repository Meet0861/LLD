package practice.implementaions.CallCenter;

public class Director extends Employee {

    public Director(int id, String name) {
        super(id, name, Rank.DIRECTOR);
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

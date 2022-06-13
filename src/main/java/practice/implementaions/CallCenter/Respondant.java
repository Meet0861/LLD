package practice.implementaions.CallCenter;

public class Respondant extends Employee {
    private Employee manager;

    public Respondant(int id, String name, Employee manager) {
        super(id, name, Rank.RESPONDANT);
        this.manager = manager;
    }


    @Override
    protected boolean attendOrEscalateCall(Call call) {
        if (this.isAvailable() && call.getCallStatus() == CallFlow.NOT_STARTED) {
            System.out.println("receiving call....call status changed to "+ CallFlow.STARTED);
            this.receiveCall(call);
            return true;
        } else {
            call.incrementRank();
            return false;
        }
    }


}

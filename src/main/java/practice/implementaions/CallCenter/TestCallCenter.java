package practice.implementaions.CallCenter;

public class TestCallCenter {

    public static void main(String[] args) {
        CallCenterService callCenterService = new callCenter();
        Employee director = new Director(1, "D1");
        Employee manager = new Manager(1, "M1", director);
        Employee respondant1 = new Respondant(1, "R1", manager);
        Employee respondant2 = new Respondant(2, "R2", manager);
        callCenterService.addEmployee(director);
        callCenterService.addEmployee(manager);
        callCenterService.addEmployee(respondant1);
        callCenterService.addEmployee(respondant2);

        Caller caller1 = new Caller(1, "Meet");
        Caller caller2 = new Caller(2, "Ahuja");
        Caller caller3 = new Caller(2, "C1");
        Caller caller4 = new Caller(2, "C2");
        Caller caller5 = new Caller(2, "C3");
        Caller caller6 = new Caller(2, "C4");
        Rank rank = Rank.RESPONDANT;
        Call call1 = new Call(caller1, rank);
        Call call2 = new Call(caller2, rank);
        Call call3 = new Call(caller3, rank);
        Call call4 = new Call(caller4, rank);
        Call call5 = new Call(caller5, rank);
        Call call6 = new Call(caller6, rank);
        callCenterService.dispatchCall(call1);
        callCenterService.dispatchCall(call2);
        callCenterService.dispatchCall(call3);
        callCenterService.dispatchCall(call4);
        callCenterService.dispatchCall(call5);
        callCenterService.dispatchCall(call6);
        callCenterService.disconnectCall(call1);

    }
}

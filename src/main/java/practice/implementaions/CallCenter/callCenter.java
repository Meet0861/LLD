package practice.implementaions.CallCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class callCenter implements CallCenterService {
    private static Map<Rank, List<Employee>> employeesByRanksMap = new HashMap<>();
    private static Map<Employee, List<Call>> callsAttendedByEmployee = new HashMap<>();
    private static List<Call> callQueue = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        Rank rank = employee.getRank();
        if (employeesByRanksMap.containsKey(rank)) {
            employeesByRanksMap.get(rank).add(employee);
        } else {
            List<Employee> employees = new ArrayList<>();
            employees.add(employee);
            employeesByRanksMap.put(rank, employees);
        }
    }

    @Override
    public void dispatchCall(Call call) {
        System.out.println(call.getCaller().getName() + "...Please wait...we are connecting you to a customer care person...");
        boolean callAttended = false;
        if(call.getCallStatus()==CallFlow.ENDED) {
            System.out.println("CALL Already ended...");
            return;
        }
        for(Employee employees : employeesByRanksMap.get(call.getRank())){
            if(employees.isAvailable()){
                System.out.println("We are connecting you to "+ employees.getName());
                callAttended = employees.attendOrEscalateCall(call);
                break;
            }
        }
        if(!callAttended){
            if(call.getRank() == Rank.DIRECTOR){
                callQueue.add(call);
                return;
            }
            call.incrementRank();
            dispatchCall(call);
        }
    }

    @Override
    public void disconnectCall(Call call) {
        call.getHandler().callCompleted();
        Call callPending = callQueue.get(0);
        callPending.setRank(Rank.RESPONDANT);
        dispatchCall(callPending);
        callQueue.remove(callPending);
    }
}

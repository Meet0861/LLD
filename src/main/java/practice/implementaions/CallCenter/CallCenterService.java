package practice.implementaions.CallCenter;

public interface CallCenterService {
    void addEmployee(Employee employee);
    void dispatchCall(Call call);
    void disconnectCall(Call call);
}

package practice.implementaions.CallCenter;

public class Caller {
    private int userId;
    private String name;

    public Caller(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

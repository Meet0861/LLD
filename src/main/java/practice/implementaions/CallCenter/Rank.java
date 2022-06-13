package practice.implementaions.CallCenter;

public enum Rank {
    RESPONDANT(0),
    MANAGER(1),
    DIRECTOR(2);

    private int value;

    private Rank(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

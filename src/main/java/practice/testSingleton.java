package practice;

class Singleton {
    private static Singleton instance = null;

    private Singleton(){
        System.out.println("Singleton constructor");
    }

    public static Singleton getInstance(){
        if(instance==null)
            instance = new Singleton();
        return instance;
    }
}

public class testSingleton {
    public static void main(String args[]){
        Singleton instance = Singleton.getInstance();
    }
}

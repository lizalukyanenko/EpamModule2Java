package collections.mainTask.candy;

public class Helper {
    private static Helper instance;

    public static Helper getInstance() {
        if(instance == null){
            synchronized (Helper.class){
                if(instance == null){
                    instance = new Helper();
                }
            }
        }
        return instance;
    }

    private Helper() {
    }
}

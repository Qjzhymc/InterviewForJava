package Algorithm4th;

public class singleInstance {
    private static singleInstance INSTANCE;

    private singleInstance() {

    }


    singleInstance getInstance() {
        if (INSTANCE == null) {  //Double check lock
            synchronized (singleInstance.class) {
                if (INSTANCE == null) {
                    INSTANCE = new singleInstance();
                }
            }
        }
        return INSTANCE;
    }
}

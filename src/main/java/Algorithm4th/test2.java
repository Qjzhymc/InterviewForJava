package Algorithm4th;

public class test2 {
    static class A implements Runnable {
        Thread b = new Thread(new B());
        @Override
        public void run() {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class B implements Runnable {
        Thread a = new Thread(new A());
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        Thread x = new Thread(a);
        Thread y = new Thread(new B());
        x.start();
        y.start();
    }
}

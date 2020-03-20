package Threads;

public class Demo1 {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "First");
        MyThread t2 = new MyThread(d, "Second");
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();
        th2.start();

    }
}

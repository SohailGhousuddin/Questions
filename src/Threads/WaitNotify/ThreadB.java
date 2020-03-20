package Threads.WaitNotify;

public class ThreadB extends Thread {
    int total;
    public void run()
    {
       synchronized (this) {
           for (int i = 1; i <= 100; i++) {
               total = total + i;
           }
           this.notify();
           System.out.println(total);
       }
    }
}

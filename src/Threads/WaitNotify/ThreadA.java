package Threads.WaitNotify;

import java.util.HashSet;

public class ThreadA {
    public static void main(String[] args) throws InterruptedException
    {
    ThreadB b = new ThreadB();
    Thread b1 = new Thread(b);
        HashSet<Integer> hs = new HashSet<>();
        b1.start();
        //b1.join(); // it will wait for b1.run to complete , disadv: waits till end of method
        synchronized (b1) { // need this to call wait since wait can all be called form sync block
            b1.wait(1000);
            // Thread.sleep(0,1 );

            System.out.println(b.total);
        }
        System.out.println("After sync block main");
    }
}

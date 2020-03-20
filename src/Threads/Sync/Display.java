package Threads;

public class Display {
    public void wish(String name)
    {
        System.out.println("before sync block: " +name);
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                System.out.println("From sync block " + name);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("After sync block: " + name);
    }
}

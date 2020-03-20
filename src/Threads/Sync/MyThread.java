package Threads;

 class MyThread implements Runnable {
    public String name;
    public Display d;
    public MyThread(Display d, String name)
    {
        this.name=name;
        this.d = d;
    }
    public void run()
    {
        d.wish(name);
    }
}

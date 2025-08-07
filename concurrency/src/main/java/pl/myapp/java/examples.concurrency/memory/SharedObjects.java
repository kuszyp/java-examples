package pl.myapp.java.examples.concurrency.memory;

public class SharedObjects {
    public static void main(String[] args) {

        MyObject mySharedObject = new MyObject();

        // 1. we have one runnable and both threads is accessing it; the count variable is shared between threads
        Runnable runnable = new MyRunnable(mySharedObject);

        // 1. each thread creates myObject in its own thread stack
        // 2. we only have one runnable and both threads are sharing the same MyObject instance mySharedObject
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}

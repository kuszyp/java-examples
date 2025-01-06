package pl.myapp.java.concurrency.memory;

public final class SeparateObjects {

  public static void main(String[] args) {

    // even there are two different runnables
    // they both internally refer to the same instance of MyObject in the heap
    MyObject mySharedObject = new MyObject();

    // there will be one count field in each runnable in the heap
    Runnable runnable1 = new MyRunnable(mySharedObject);
    Runnable runnable2 = new MyRunnable(mySharedObject);

    // we have two different runnables and each thread creates myObject in its own thread stack
    Thread thread1 = new Thread(runnable1, "Thread 1");
    Thread thread2 = new Thread(runnable2, "Thread 2");

    thread1.start();
    thread2.start();
  }
}

package pl.myapp.java.concurrency.memory;

public class MyRunnable implements Runnable {

  private int count = 0; // there will be one count in each runnable
  private MyObject mySharedObject = null;

  public MyRunnable() {}

  public MyRunnable(MyObject myObject) {
    this.mySharedObject = myObject;
  }

  @Override
  public void run() {

    MyObject myObject = new MyObject();
    System.out.println("Thread stack object: " + myObject);
    System.out.println("Shared object: " + this.mySharedObject);

    for (int i = 0; i < 1_000_000; i++) { // each thread will have its copy of i in thread stack
      this.count++; // this variable will be in a heap, not in a thread scope
    }
    System.out.println(Thread.currentThread().getName() + " : " + this.count);
  }
}

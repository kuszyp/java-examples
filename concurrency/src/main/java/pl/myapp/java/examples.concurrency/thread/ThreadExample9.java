package pl.myapp.java.examples.concurrency.thread;

public class ThreadExample9 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
          while(true) {
              sleep(1000);
              System.out.println("running");
          }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3100);
        System.out.println(Thread.currentThread().getName() + " thread terminated");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

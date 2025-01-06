package pl.myapp.java.concurrency.virtualthread;

public class VirtualThreadExample1 {
    public static void main(String[] args) {

        // Example 1: Create runnable. Create and start virtual thread.
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("running " + i);
            }
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable);

        // Example 2: Create but not start virtual thread
        Thread vThread2 = Thread.ofVirtual().unstarted(runnable);
        vThread2.start();

        // Example 3: How to join virtual thread
        try {
            vThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

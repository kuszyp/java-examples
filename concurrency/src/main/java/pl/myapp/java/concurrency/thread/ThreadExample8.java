package pl.myapp.java.concurrency.thread;

public class ThreadExample8 {
    public static class StoppableRunnable implements Runnable {
        private boolean stopRequested = false;

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");

            while (!isStopRequested()) {
                sleep(1000);
                System.out.println(threadName + " is working");
            }

            System.out.println(threadName + " finished");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName() + " start");

        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "StoppableRunnable");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
        System.out.println("Main thread: " + Thread.currentThread().getName() + " stop");
    }

}

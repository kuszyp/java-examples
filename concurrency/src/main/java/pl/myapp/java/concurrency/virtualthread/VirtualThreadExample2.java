package pl.myapp.java.concurrency.virtualthread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample2 {
    public static void main(String[] args) {
        List<Thread> vThreads = new ArrayList<>();
        int vThreadsCount = 100_000;
        for (int i = 0; i < vThreadsCount; i++) {
            int vThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println("Result[" + vThreadIndex + "]: " + result);
            });

            vThreads.add(vThread);
        }

        for (int i = 0; i < vThreadsCount; i++) {
            try {
                vThreads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

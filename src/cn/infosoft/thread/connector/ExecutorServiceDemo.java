package cn.infosoft.thread.connector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService接口是Executor接口的子接口，
 * 并添加了功能来管理生命周期，这两个单独的任务和执行器本身。
 */
public class ExecutorServiceDemo {
    public static void main(final String[] arguments) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.submit(new Task());
            System.out.println("Shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    static class Task implements Runnable {
        public void run() {
            try {
                Long duration = (long) (Math.random() * 20);
                System.out.println("Running Task!");
                TimeUnit.SECONDS.sleep(duration);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

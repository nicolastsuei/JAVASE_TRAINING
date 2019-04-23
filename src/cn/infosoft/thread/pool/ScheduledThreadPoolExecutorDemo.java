package cn.infosoft.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 是ThreadPoolExecutor的子类，并且可以额外地调度在给定延迟之后运行的命令，或定期执行。
 */
public class ScheduledThreadPoolExecutorDemo {
    public static void main(final String[] arguments)  {
        final ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);

        final ScheduledFuture<?> beepHandler =
                scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beepHandler.cancel(true);
                scheduler.shutdown();
            }
        }, 10, TimeUnit.SECONDS);
    }

    static class BeepTask implements Runnable {
        public void run() {
            System.out.println("beep");
        }
    }
}

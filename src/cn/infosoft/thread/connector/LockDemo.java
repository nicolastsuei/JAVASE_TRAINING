package cn.infosoft.thread.connector;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock接口用作线程同步机制，类似于同步块。
 * 新的锁定机制更灵活，提供比同步块更多的选项。锁和同步块之间的主要区别如下：
 *
 * 序列的保证 - 同步块不提供对等待线程进行访问的序列的任何保证，但Lock接口处理它。
 * 无超时，如果未授予锁，则同步块没有超时选项。Lock接口提供了这样的选项。
 * 单一方法同步块必须完全包含在单个方法中，而Lock接口的方法lock()和unlock()可以以不同的方式调用。
 */
public class LockDemo {
    public static void main(String args[]) {
        PrintDemo PD = new PrintDemo();

        ThreadDemo t1 = new ThreadDemo( "Thread - 1 ", PD );
        ThreadDemo t2 = new ThreadDemo( "Thread - 2 ", PD );
        ThreadDemo t3 = new ThreadDemo( "Thread - 3 ", PD );
        ThreadDemo t4 = new ThreadDemo( "Thread - 4 ", PD );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class PrintDemo {

    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName()
                    + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}

class ThreadDemo extends Thread {
    PrintDemo  printDemo;

    ThreadDemo( String name,  PrintDemo printDemo) {
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
        printDemo.print();
    }
}


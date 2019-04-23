package cn.infosoft.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * java.util.concurrent.atomic.AtomicReference类提供了可以原子读取和写入的底层对象引用的操作，还包含高级原子操作。
 * AtomicReference支持对底层对象引用变量的原子操作。 它具有获取和设置方法，如在易变的变量上的读取和写入。
 * 也就是说，一个集合与同一变量上的任何后续get相关联。 原子compareAndSet方法也具有这些内存一致性功能。
 */
public class AtomicReferenceDemo {
    private static String message = "hello";
    private static AtomicReference<String> atomicReference;

    public static void main(final String[] arguments) throws InterruptedException {
        atomicReference = new AtomicReference<String>(message);
        new Thread("Thread 1") {
            public void run() {
                atomicReference.compareAndSet(message, "Thread 1");
                message = message.concat("-Thread 1!");
            };
        }.start();

        System.out.println("Message is: " + message);
        System.out.println("Atomic Reference of Message is: " + atomicReference.get());
    }
}

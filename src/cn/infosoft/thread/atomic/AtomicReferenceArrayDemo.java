package cn.infosoft.thread.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * AtomicReferenceArray支持对底层引用数组变量的原子操作。
 * 它具有获取和设置方法，如在变量上的读取和写入。
 * 也就是说，一个集合与同一变量上的任何后续获取相关联。
 * 原子compareAndSet方法也具有这些内存一致性功能。
 */
public class AtomicReferenceArrayDemo {
    private static String[] source = new String[10];
    private static AtomicReferenceArray<String> atomicReferenceArray
            = new AtomicReferenceArray<String>(source);

    public static void main(final String[] arguments) throws InterruptedException {
        for (int i=0; i<atomicReferenceArray.length(); i++) {
            atomicReferenceArray.set(i, "item-2");
        }

        Thread t1 = new Thread(new Increment());
        Thread t2 = new Thread(new Compare());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    static class Increment implements Runnable {
        public void run() {
            for(int i=0; i<atomicReferenceArray.length(); i++) {
                String add = atomicReferenceArray.getAndSet(i,"item-"+ (i+1));
                System.out.println("Thread " + Thread.currentThread().getId()
                        + ", index " +i + ", value: "+ add);
            }
        }
    }

    static class Compare implements Runnable {
        public void run() {
            for(int i=0; i<atomicReferenceArray.length(); i++) {
                System.out.println("Thread " + Thread.currentThread().getId()
                        + ", index " +i + ", value: "+ atomicReferenceArray.get(i));
                boolean swapped = atomicReferenceArray.compareAndSet(i, "item-2", "updated-item-2");
                System.out.println("Item swapped: " + swapped);
                if(swapped){
                    System.out.println("Thread " + Thread.currentThread().getId()
                            + ", index " +i + ", updated-item-2");
                }
            }
        }
    }
}

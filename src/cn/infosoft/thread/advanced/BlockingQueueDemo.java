package cn.infosoft.thread.advanced;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue接口是Queue接口的子接口，
 * 另外还支持诸如在检索元素之前等待队列变为非空的操作，
 * 并在存储元素之前等待队列中的空间变得可用 。
 */
public class BlockingQueueDemo {
    public static void main(final String[] arguments) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }


    static class Producer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            Random random = new Random();

            try {
                int result = random.nextInt(100);
                Thread.sleep(1000);
                queue.put(result);
                System.out.println("Added: " + result);
                result = random.nextInt(100);
                Thread.sleep(1000);
                queue.put(result);
                System.out.println("Added: " + result);
                result = random.nextInt(100);
                Thread.sleep(1000);
                queue.put(result);
                System.out.println("Added: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

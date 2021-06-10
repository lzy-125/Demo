package Org;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

//使用BlockingQueue改写当前的生产者消费者模型
public class ProducerAndConsumer {

    public static int COUNT = 0;

    public static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    class Producer implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    queue.put(COUNT);
                    System.out.println("生产元素："+(++COUNT));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    int res = queue.take();
                    System.out.println("消费元素：" + res);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) {
        ProducerAndConsumer queueTest = new ProducerAndConsumer();

        new Thread(queueTest.new Producer()).start();
        new Thread(queueTest.new Consumer()).start();

    }
}

package Org;

import java.util.concurrent.CountDownLatch;

public class TenThread extends Thread {

    //    public static int result = 0;
//
    private static int results[] = new int[10];
    static int j = 0;
    static CountDownLatch countDownLatch = new CountDownLatch(10);
//
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(++result);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            TenThread thread = new TenThread();
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    public static class SubClass extends Thread {

        int sum = 0;
        int flag = 0;

        public SubClass(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                sum += i + flag * 10;

            }
            results[j++] = sum;

            System.out.println(getName() + "---->" + sum);
            
            countDownLatch.countDown();
        }

    }

    //把当前这个程序改成多线程并发计算，得到最终结果（使用CountDownLatch）
    public static void main(String[] args) throws InterruptedException {

        int result = 0;
        for (int i = 0; i < 10; i++) {
            SubClass subClass = new SubClass(i);
            subClass.start();
//            subClass.join();

        }
        countDownLatch.await();

        for (int r : results) {
            result += r;
        }
        System.out.println(result);
    }
}

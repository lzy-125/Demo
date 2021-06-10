package Org;

public class print {
    private static int flag = 0;

    public synchronized void add1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {

            while (flag != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName());
            flag = 1;
            notifyAll();
        }
    }

    public synchronized void add2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {

            while (flag != 1) {
                wait();
            }
            System.out.println(Thread.currentThread().getName());
            flag = 2;
            notifyAll();
        }
    }

    public synchronized void add3() throws InterruptedException {
        for (int i = 0; i < 5; i++) {

            while (flag != 2) {
                wait();
            }
            System.out.println(Thread.currentThread().getName());
            flag = 0;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        print print = new print();
       new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.add1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.add1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.add3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}



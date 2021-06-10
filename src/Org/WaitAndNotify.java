package Org;

import jdk.nashorn.internal.ir.WhileNode;

public class WaitAndNotify {
    private static boolean flag ;
    private static int count = 0;
//    String arr[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public synchronized void add1() throws InterruptedException {
        for (int i = 0; i < 26; i++) {
            while (flag) {
                wait();
            }
            System.out.println( (++count));
            System.out.println( (++count));
            flag = !flag;
            notify();
        }
    }

    public synchronized void add2() throws InterruptedException {
        for (int i = 0; i < 26; i++) {
            while (!flag) {
                wait();
            }
            System.out.println((char)(65+i));
            flag = !flag;
            notify();
        }
    }


    public static void main(String[] args) {
        WaitAndNotify wn = new WaitAndNotify();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.add1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.add2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

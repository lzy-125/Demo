package Org;

import java.io.*;

public class Work {
    static final Object obj = new Object();

    public static class Write_1 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                String str = "哈哈哈哈哈哈哈哈哈哈";
                File file = new File("/home/andilylzy/xx.txt");
                OutputStream fos = null;
                try {
                    System.out.println("---------写入文件1----------");
                    fos = new FileOutputStream(file);
                    fos.write(str.getBytes());
                    fos.flush();
                    System.out.println("----------写入完成1-----------");
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Write_2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                try {

                    String str = "啦啦啦啦啦啦啦啦啦啦啦啦啦啦";
                    File file = new File("/home/andilylzy/xx.txt");
                    OutputStream fos = null;
                    System.out.println("---------写入文件2----------");
                    fos = new FileOutputStream(file, true);
                    fos.write(str.getBytes());
                    fos.flush();
                    fos.close();
                    System.out.println("-------写入完成2--------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Write_1 w1 = new Write_1();
        Write_2 w2 = new Write_2();
        w1.start();
        w2.start();
    }
}

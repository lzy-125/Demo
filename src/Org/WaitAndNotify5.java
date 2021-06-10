package Org;

public class WaitAndNotify5 {

    private boolean flag;
    private int count = 0;


    public synchronized void subRun() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count>=10){
                break;
            }
            System.out.println("sub run");
        }
        count++;
        flag = !flag;
        notify();

    }


    public synchronized void mainRun() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count>=10){
                break;
            }
            System.out.println("main run");
        }
        count++;
        flag = !flag;
        notify();
    }

    public static void main(String[] args) {
        WaitAndNotify5 task = new WaitAndNotify5();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                        task.subRun();
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            task.mainRun();
        }

    }
}

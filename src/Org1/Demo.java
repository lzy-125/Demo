package Org1;



//锁对象的死锁demo
class X {
    public synchronized void xxx(Y y) {
        System.out.println("aaaaaaa");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        y.kkk();
    }

    public synchronized void yyy() {
        System.out.println("bbbbbbb");
    }
}

class Y {
    public synchronized void zzz(X x){
        System.out.println("cccccccc");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x.yyy();
    }

    public synchronized void kkk(){
        System.out.println("dddddddd");
    }
}

public class Demo {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.xxx(y);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.zzz(x);
            }
        });

        t1.start();
        t2.start();
    }
}

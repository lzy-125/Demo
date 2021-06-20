package Org1;

class A {
    public void xxx(B b) {
        synchronized (A.class) {
            System.out.println("aaaaaaa");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.kkk();
        }
    }

    public void yyy() {
        synchronized (A.class) {
            System.out.println("bbbbbbb");
        }
    }
}

class B {
    public void zzz(A a) {
        synchronized (B.class) {
            System.out.println("cccccccc");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.yyy();
        }
    }

    public void kkk() {
        synchronized (B.class) {
            System.out.println("dddddddd");
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t11 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.xxx(b);
            }
        });

        Thread t22 = new Thread(new Runnable() {
            @Override
            public void run() {
                b.zzz(a);
            }
        });

        t11.start();
        t22.start();
    }
}

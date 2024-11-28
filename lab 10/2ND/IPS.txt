package Lab2;

class A {
    synchronized void foo(Lab2.B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);  // This can throw InterruptedException
        } catch (InterruptedException e) {
            System.out.println("A Interrupted");
        }

        System.out.println(name + " trying to call B.last()");
        b.last();
    }

    void last() {
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void bar(Lab2.A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");

        try {
            Thread.sleep(1000);  // This can throw InterruptedException
        } catch (InterruptedException e) {
            System.out.println("B Interrupted");
        }

        System.out.println(name + " trying to call A.last()");
        a.last();
    }

    void last() {
        System.out.println("Inside B.last");
    }
}

public class IPS implements Runnable {
    Lab2.A a = new Lab2.A();
    Lab2.B b = new Lab2.B();

    IPS() {
        // Set up the main thread and start the new thread
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        // Main thread acquires lock on object a and calls foo
        a.foo(b);

        System.out.println("Back in main thread");
    }

    @Override
    public void run() {
        // This method will be run in the RacingThread
        b.bar(a);
    }

    public static void main(String[] args) {
        // The main method will create an instance of IPS and trigger the deadlock
        new IPS();
    }
}



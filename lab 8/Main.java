public class Main {

    static class BMSPrinter extends Thread {
        public void run() {
            while (true) {
                System.out.println("BMS College of Engineering");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    static class CSEPrinter extends Thread {
        public void run() {
            while (true) {
                System.out.println("CSE");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        BMSPrinter thread1 = new BMSPrinter();
        CSEPrinter thread2 = new CSEPrinter();

        thread1.start();
        thread2.start();
    }
}

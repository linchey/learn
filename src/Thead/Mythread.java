package Thead;

public class Mythread extends Thread {
    @Override
    public void run() {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  synchronized  void test() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("111111111");
    }
}

class Test{
    public static void main(String[] args) {
        Mythread mythread=new Mythread();
        mythread.start();
        Mythread mythread1=new Mythread();
        mythread1.start();
    }
}
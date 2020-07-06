package synchronizsd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintPrime {

    public static void main(String[] args) throws InterruptedException {
        PrintPrime printPrime = new PrintPrime();

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                printPrime.printPrime1();
            }
        };
        Thread t1= new Thread(  r1,"线程1");
        Runnable r2=new Runnable() {
            @Override
            public void run() {
                printPrime.printPrime2();
            }
        };
        Thread t2= new Thread(  r2,"线程2");
        Runnable r3=new Runnable() {
            @Override
            public void run() {
                printPrime.printPrime3();
            }
        };
        Thread t3= new Thread(  r3,"线程3");
        t1.start();
        t2.start();
        t3.start();
    }
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
     int i = 2;
     int count = 1;
    private void printPrime1() {
        lock.lock();

        try {
        for (; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt( i ); j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
            }
         if (flag) {
             while(count!=1){
             condition1.await();
             }

                PrintPrime.this.count=2;
                if(i<100){
                    System.out.println( Thread.currentThread().getName() + ":" + i);
                    condition2.signal();
                }

            }

        }

        } catch (Exception e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
    }

  private void printPrime2() {
        lock.lock();
        try {

        for (; i <=100;i++) {
            boolean flag = true;
                for (int j = 2; j <= Math.sqrt( i ); j++) {
                    if (i % j == 0) {
                        flag = false;
                            break;
                    }
                }
            if (flag) {
                while(count!=2){
                condition2.await();
                }

                PrintPrime.this.count=3;
                if(i<100){
                    System.out.println( Thread.currentThread().getName() + ":" + i );
                    condition3.signal();
                }
            }
        }

        } catch (Exception e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
    }

    private void printPrime3() { lock.lock();  try {
        for (; i <= 100; i++) {
            boolean flag = true;
                for (int j = 2; j <= Math.sqrt( i ); j++) {
                    if (i % j == 0) {
                            flag = false;
                            break;
                    }
                }

            if (flag) {
                while(count!=3){
                condition3.await();
            }
                PrintPrime.this.count=1;
                if(i<100){
                    System.out.println( Thread.currentThread().getName() + ":" + i );
                    condition1.signal();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
    }
}



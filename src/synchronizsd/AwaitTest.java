package synchronizsd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Condition condition1=lock.newCondition();
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("线程开始运行");
                    System.out.println(Thread.currentThread().getName());
                    condition.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }finally
                {
                    lock.unlock();
                }
            }
        };
        Runnable runnable2=new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    condition1.await();
                    System.out.println("线程开始运行");
                    System.out.println(Thread.currentThread().getName());
                    //condition1.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                }finally
                {
                    lock.unlock();
                }
            }
        };
        Runnable runnable3=new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    condition.signal();
                    System.out.println("线程开始运行");
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally
                {
                    lock.unlock();
                }
            }
        };
        Thread thread=new Thread(runnable1,"线程1");
        Thread thread1=new Thread(runnable2,"线程2");
        Thread thread3=new Thread(runnable3,"线程3");
        thread.start();
        thread1.start();
        thread3.start();
        Thread.sleep(1000);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"线程4").start();
    }

}

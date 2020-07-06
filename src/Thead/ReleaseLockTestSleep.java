package Thead;

/**
 * 证明 Thread.sleep 方法导致当前线程进入 阻塞状态 ( TIMED_WAITING ) ，并不会释放当前线程持有的同步锁
 */
public class ReleaseLockTestSleep {

    public static void main(String[] args) throws InterruptedException {

        final Object lock = new Object();

        Runnable a = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("开始等待....");
                    try {  lock.wait();  } catch (InterruptedException e) {  e.printStackTrace(); }
                    System.out.println( "结束等待" );
                }
            }
        };

        Thread t1 = new Thread( a , "T1" );
        t1.start();

        Runnable b = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println( t1 + " : " + t1.getState() );
                    System.out.println(   "t2 : " + Thread.currentThread().getState() );
                    // notifyAll()和 notify() 并不会释放 同步锁
                    lock.notifyAll(); // 唤醒在此 "对象监视器" ( 同步锁 ) 上等待的所有线程，被唤醒的线程进入锁池
                    try {
                       Thread.sleep( 5000 );  } catch (InterruptedException e) {  e.printStackTrace();  }
                }
            }
        };

        Thread t2 = new Thread( b , "T2" );
        t2.start();
        try { Thread.sleep( 1000 );  } catch (InterruptedException e) {  e.printStackTrace(); }
        System.out.println("t2持有锁时的状态");
        System.out.println( t1 + " : " + t1.getState() );
        System.out.println( t2 + " : " + t2.getState() );

    }

}

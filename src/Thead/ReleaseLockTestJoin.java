package Thead;
/*调用join方法会导致当前的调用线程释放锁*/
public class ReleaseLockTestJoin {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        Runnable a=new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"得到锁了！！！");

                }
            }
        };
        Thread t1=new Thread(a,"线程1");
        Runnable b=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始运行。。。。");
                synchronized (lock){
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getState());
                    System.out.println("线程2执行完");
                }
            }
        };
        Thread t2=new Thread(b,"线程2");
        t2.start();
        t1.start();
        Thread.sleep(10);
        //t2调用join后的状态
        System.out.println(t2.getState());
    }

}

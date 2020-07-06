package Thead;

/*
* 证明：wait会释放锁，调用后进入waiting状态
* */
public class ReleaseLockTestWait {
    public static void main(String[] args) throws InterruptedException {
       final Object lock=new Object();
        Runnable a=new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    System.out.println("线程1执行中");
                    System.out.println(Thread.currentThread().getName()+"当前状态："+Thread.currentThread().getState());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1=new Thread(a,"线程1");
        t1.start();
        Runnable b=new Runnable() {
            @Override
            public void run() {
                synchronized (lock){

                    System.out.println("线程2执行中");
                    System.out.println(Thread.currentThread().getName()+"当前状态："+Thread.currentThread().getState());

                    System.out.println("线程1的状态:"+t1.getState());
                }
            }
        };


        Thread t2=new Thread(b,"线程2");
        t2.start();
        //t2.join();

    }
}

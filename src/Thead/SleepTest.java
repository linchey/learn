package Thead;

public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable a=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程t1运行中........");
                try {
                    System.out.println("启动后t1的线程状态");
                    System.out.println(Thread.currentThread().getState());//启动后t1的线程状态
                    Thread.sleep(10000);//让当前线程睡眠
                    System.out.println("睡眠后的线程状态");
                    System.out.println(Thread.currentThread().getState());//睡眠后的线程状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1=new Thread(a);
        System.out.println("t1的线程状态");
        System.out.println(t1.getState());//t1的线程状态
        t1.start();//main线程调用t1的start让他启动
        System.out.println("睡眠时t1的状态:"+t1.getState());
        t1.join();//让主线程等到t1线程运行完再继续运行
    }
}

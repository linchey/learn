package Thead;

/**
 * 线程睡眠
 */
public class ThreadStateTest2 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread current = Thread.currentThread() ; // 获得当前线程引用

                try {
                    System.out.println( current.getName() + "要睡觉了"); // 运行状态

                    Thread.sleep( 10000 ); // 导致 当前线程睡眠 ，当前线程进入到 阻塞状态
                    System.out.println( current.getName() + "睡醒了" ); // 先进入 就绪状态 ，如果获得CPU使用权，则进入运行状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        Thread t = new Thread( r , "hello" ) ; // 新建状态

        t.start(); // 就绪状态

        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

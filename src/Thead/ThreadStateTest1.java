package Thead;

/**
 * 内部枚举 Thread.State 中定义的 枚举常量 并不能 与 线程状态 完全对应
 */
public class ThreadStateTest1 {

    static class FifthThread extends Thread {

        @Override
        public void run() {
            // try {  Thread.sleep( 100 );  } catch (InterruptedException e) {  e.printStackTrace();    }
            Thread current = Thread.currentThread() ;
            System.out.println( "正在执行的线程状态是 运行状态 ( Running ) 。");
            System.out.println( "因为 Thread.State 类中没有 RUNNING 状态，因此通过 getState 方法返回的正在执行的线程状态依然是: " + current.getState() );
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new FifthThread();
        System.out.println( "调用 start 方法之前: " + t.getState() );
        t.start();
        System.out.println( "调用 start 方法之后: " + t.getState() );
        //让线程t执行完再执行main线程
        //try {  Thread.sleep( 1000 );  } catch (InterruptedException e) {  e.printStackTrace();    }
        t.join();
        System.out.println( "等到 fifth thread 执行结束后: " + t.getState() );

    }

}

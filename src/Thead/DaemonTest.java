package Thead;

import java.time.LocalDateTime;

public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        System.out.println(  "main is daemon : " + main.isDaemon() );

        Thread t = new Thread() {
            @Override
            public void run() {
                while( true ){
                    System.out.println( LocalDateTime.now() );
                }
            }
        };

        t.setDaemon( true );
        t.start();

        Thread.sleep( 100 );
        System.out.println( main.getName() +  "睡醒了" );

    }

}

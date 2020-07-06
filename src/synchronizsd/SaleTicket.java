package synchronizsd;

import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++) ticket.sale();

            }
        },"1号窗口");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)ticket.sale();

            }
        },"2号窗口");
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)ticket.sale();
            }
        },"3号窗口");
        t1.start();
        t2.start();
        t3.start();
        new Thread(()->{for(int i=1;i<=100;i++)ticket.sale();},"4号窗口").start();
    }
}

class  Ticket{
    private  int number=100;
    ReentrantLock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第"+number+"张票");
                number--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}
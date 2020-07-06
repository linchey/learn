package synchronizsd;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrenlockTest {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{for(int i=1;i<=100;i++) ticket.sale();},"线程1").start();
        new Thread(()->{for(int i=1;i<=100;i++)ticket.sale();},"线程2").start();
        new Thread(()->{for(int i=1;i<=100;i++)ticket.sale();},"线程3").start();

    }

    static class  Ticket1{
        private  int number=100;
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
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
}

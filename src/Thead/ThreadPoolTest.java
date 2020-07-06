package Thead;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableThreads implements Callable<Double> {
    private int a;
    private int b;
    public CallableThreads(int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public Double call() throws Exception {
        return Math.pow(a,b);
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        ExecutorService es= Executors.newFixedThreadPool(2);
        List<Future<Double>> l=new ArrayList<>();
        for(int i=0;i<5;i++){
            CallableThreads c=new CallableThreads(2,i);
            Future<Double> f=es.submit(c);
            l.add(f);
        }
        for(Future<Double> f:l){
            System.out.println(f.get());
        }
        es.shutdown();
    }
}

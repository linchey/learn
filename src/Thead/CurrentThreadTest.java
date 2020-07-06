package Thead;

public class CurrentThreadTest {

    public static void main(String[] args) {

        // 通过 java.lang.Thread  类中类方法来获取当前线程
        Thread current = Thread.currentThread(); // 这样代码在哪里执行，就获得哪里的线程对象
        System.out.println( current ); // toString

        // Thread 类中定义了获取 线程名称 的 实例方法
        System.out.println( current.getName() ); // 线程名称
        // Thread 类中定义了获取 线程优先级 的 实例方法
        System.out.println( current.getPriority() ); // 线程优先级

        ThreadGroup group = current.getThreadGroup(); // 获得当前线程所在的线程组
        System.out.println( group ); // toString

        System.out.println( group.getName() ); // 线程组的组名
        System.out.println( group.getMaxPriority() ); // 最高优先级

    }

}

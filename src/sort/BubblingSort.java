package sort;

import java.util.Arrays;

/*冒泡排序
 * 基本原理：两两之间进行比较，若前者比后者大，交换(从小到大排序)
 * 第一轮：10和20比较，20和70比较，...
 * 比较结果：10,20,10,70,90,100
 * 第二轮：10和20比较，20和10比较，...
 * 比较结果：10,10,20,70,90,100
 * 第三轮：10和10比较，10和20比较，...
 * 比较结果：10,10,20,70,90,100
 * 第四轮：...
 * 第五轮：...
 * */
public class BubblingSort {
    public static void main(String[] args) {
        int [] arr={10,20,70,10,90,100};
        System.out.println("原数组："+ Arrays.toString( arr ));
        System.out.println( "排序后数组："+Arrays.toString( sort(arr) ) );
    }

    public static int[] sort(int[] arry) {
        for(int i=0;i<arry.length-1;i++){//控制比较轮数
            for(int j=0;j<arry.length-i-1;j++){//两两元素之间进行比较
                if(arry[j]>arry[j+1]){
                    arry[j]^=arry[j+1];
                    arry[j+1]^=arry[j];
                    arry[j]^=arry[j+1];
                }
            }
        }
        return arry;
    }

}

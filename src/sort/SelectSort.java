package sort;

import java.util.Arrays;

/*选择排序
 * 基本原理：第i个元素与之后的元素比较，若前者比后者大，交换(从小到大排序)
 * 第一轮：10和20比较，10和70比较，10和10比较...
 * 比较结果：10,20,70,10,90,100
 * 第二轮:20和70比较，20和10比较20>10交换，10和90比较,...
 * 比较结果：10,10,70,20,90,100
 * 第三轮：70和20比较70>20交换，20与90比较，20与100比较
 * 比较结果：10,10,20,70,90,100
 * 第四轮：...
 * 第五轮：...
 * */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr={10,20,70,10,90,100};
        System.out.println("原数组："+Arrays.toString( arr ));
        System.out.println( "排序后数组："+Arrays.toString( sort(arr) ) );
    }

    public static int[] sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//控制排序轮数
            for (int j=i+1;j<arr.length;j++){//将i下标元素与之后的元素比较
                if(arr[i]>arr[j]){
                    arr[i]^=arr[j];
                    arr[j]^=arr[i];
                    arr[i]^=arr[j];
                }
            }
        }
        return  arr;
    }
}

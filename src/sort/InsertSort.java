package sort;

import java.util.Arrays;

/*
*插入排序
* 基本原理：在已有有序数组元素中插入元素，比较
* 初始：【10】,20,70,10,90,100
* 第一轮：20和【10】比较
* 比较结果：【10,20】,70,10,90,100
* 第二轮：70和【10,20】里的元素比较
* 比较结果：【10,20,70】,10,90,100
* 第三轮：10和【10,20,70】里的元素比较
* 比较结果：【10,10,20,70】,90,100
* 第四轮：90和【10,10,20,70】里的元素比较
* 比较结果：【10,10,20,70,90】,100
* 第五轮：100和【10,10,20,70,90】里的元素比较
* 比较结果：【10,10,20,70,90,100】
 *  */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr={10,20,70,10,90,100};
        System.out.println("原数组："+ Arrays.toString( arr ));
        System.out.println( "排序后数组："+Arrays.toString( sort(arr) ) );
    }
    public static int[] sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//控制比较轮数
            for (int j=i+1;j>0;j--){//将下一个元素插入比较
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return  arr;
    }
}

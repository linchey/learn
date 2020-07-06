package sort;

import java.util.Arrays;

/*快速排序
* 基本思想：按某个基准数进行分区治理
* */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr={10,9,8,7,6,5,15,3,1};

        System.out.println("原数组："+ Arrays.toString( arr ));
        System.out.println( "排序后数组："+Arrays.toString( sort(arr) ));
    }
    //返回基准的下标
    public static int partion(int[] arr,int low,int high) {
        int base=arr[low];
        while(low<high){
            //从右边开始找到比基准数小的元素
            while(low<high&&arr[high]>base){
                high--;
            }
            arr[low]=arr[high];
            //从左边查找比基准数大的元素
            while (low<high&&arr[low]<base){
                low++;
            }
             arr[high]=arr[low];
        }
        arr[low]=base;
        return low;
    }
    public static int[] sort(int[]array,int low,int high){
        int par=partion(array,low,high);
        if(par>low+1){//左边元素个数大于1还需要快排
            return sort(array,low,par-1);
        }
        if(par<high-1){//右边元素个数大于1还需要快排
            return sort(array,par+1,high);
        }
        return array;
    }
    public static  int[] sort(int[]array){
        return sort(array,0,array.length-1);
    }
}

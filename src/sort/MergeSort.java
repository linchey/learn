package sort;

import java.util.Arrays;

/*归并排序
* 基本思想：分治
* 原理：将数组拆分为若干份，然后按序合并
* */
public class MergeSort {
    public static void main(String[] args) {
        //原始待排序数组
         int [] arr={9,8,7,6,5,4,3,2,1};
        //两边有序数组
        //int[] arr={4,5,7,8,1,2,3,6};
        //拆分
        split(arr,0,arr.length-1);
        //合并
        //merge(arr,0,3,arr.length-1);
        System.out.println("原数组："+ Arrays.toString( arr ));

        //System.out.println( "排序后数组："+Arrays.toString( sort(arr) ));
    }
    //拆分数组
    private static void split(int[] arr, int low, int high) {
        int mid=low+((high-low)>>1);
        if(low<high){
            split( arr,low,mid );
            split( arr,mid+1,high );
            merge( arr,low,mid,high );
        }
    }
    //合并数组
    private static void merge(int[] arr, int low, int mid, int high) {
        //定义临时数组
        int[] temp=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int index=0;
        //合并排序数组
        while (left<=mid&&right<=high){
            if(arr[left]>=arr[right]){
                temp[index++]=arr[right++];
            }else{
                temp[index++]=arr[left++];
            }
        }
        //处理剩余元素
        while(left<=mid)temp[index++]=arr[left++];;
        while(right<=high)temp[index++]=arr[right++];
        for(int i=0;i<temp.length;i++){
            arr[i+low]=temp[i];
        }

    }
    private static int[] sort(int[] arr) {

        return arr;
    }
}

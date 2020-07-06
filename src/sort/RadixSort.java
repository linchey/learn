package sort;

import java.util.Arrays;

/*基数排序
*  思想：分配再收集
*  */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={2,1,5,21,34,444,22,33,47,10,123,900,777};
        //确定排序轮次
        //int max=getMax(arr);
        //System.out.println(max);
        //排序
        sort(arr);
        //输出排序后的数组
        System.out.println( Arrays.toString( arr ) );
    }

    private static void sort(int[] arr) {
        //用二维数组作为桶
        int[][] tempArr=new int[10][arr.length];
        //定义counts用于统计桶里元素的个数
        int[] counts=new int[10];
        int max=getMax(arr);
        int len=String.valueOf( max ).length();
        for(int i=0,n=1;i<len;i++,n*=10){//确定循环轮次
            for (int j = 0; j < arr.length; j++) {
                int t=arr[j]/n%10;
                //把元素放进对应的桶里
                tempArr[t][counts[t]++]=arr[j];
            }
            //取出桶里的元素
            int index=0;
            for (int k = 0; k < counts.length; k++) {
                if(counts[k]!=0){
                    //将桶中的元素放回原数组中
                    for (int h = 0; h < counts[k]; h++) {
                        arr[index++]=tempArr[k][h];
                    }
                    counts[k]=0;//清除上一次统计的数据
                }
            }
        }
    }

    private static int getMax(int[] arr) {
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}

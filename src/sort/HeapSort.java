package sort;

import java.util.Arrays;

/*堆排序
* 1.大根堆（一般用于升序）节点值都大于或等于左右子节点 公式：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
* 2.小根堆（一般用于降序）节点值都小于或等于左右子节点 公式：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
* 步骤；
* 1.构建大顶堆，从最后一个非叶子节点开始调整，使其节点值都大于或等于左右子节点
* 2.将堆顶（root）元素和最后一个叶子节点交换，然后重构大顶堆继续上述步骤
* */
public class HeapSort {
    public static void main(String[] args) {
        int [] arr={10,9,8,7,6,5,15,3,1};
        sort(arr);
        System.out.println( Arrays.toString( arr ) );
    }
    /* 堆排序*/
    public static void sort(int[] arr){
        //从最后一个非叶子节点开始调整
        int startIndex=(arr.length-1)>>1;
        //循环调整
        for(int i=startIndex;i>=0;i--){
            toMaxHeap( arr,arr.length,i );
        }
        //把root元素和最后一个元素进行交换
        for (int i=arr.length-1;i>0;i--){
            arr[0]^=arr[i];
            arr[i]^=arr[0];
            arr[0]^=arr[i];
            //重新构建大顶堆
            toMaxHeap( arr,i,0 );
        }
    }
    /**
     *构建大顶堆
     * @param arr 排序数组
     * @param length 调整长度
     * @param index 调整元素起点
     */
    private static void toMaxHeap(int[] arr, int length, int index) {
        //获取左右节点的索引
        int leftNodeIndex=index*2+1;
        int rightNodeIndex=index*2+2;
        //查找最大节点对应的索引
        int maxNodeIndex=index;
        if(leftNodeIndex<length&&arr[leftNodeIndex]>arr[maxNodeIndex]){
            maxNodeIndex=leftNodeIndex;
        }
        if(rightNodeIndex<length&&arr[rightNodeIndex]>arr[maxNodeIndex]){
            maxNodeIndex=rightNodeIndex;
        }
        //调整位置
        if(index!=maxNodeIndex){
            arr[maxNodeIndex]^=arr[index];
            arr[index]^=arr[maxNodeIndex];
            arr[maxNodeIndex]^=arr[index];
            toMaxHeap( arr,length,maxNodeIndex );
        }
    }
}

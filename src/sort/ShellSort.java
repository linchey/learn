package sort;

import java.util.Arrays;

/*希尔排序（改进的插入排序）
*增量为4
* 第一轮：【10】9,8,7,[6],5(将6插入并和【10】比较)
* 结果：【6】,9,8,7,【10】,5
* 第二轮：【6】,【9】,8,7,【10】,[5](将5插入并和【9】比较)
* 结果：【6】,【9】,8,7,【10】,【5】
* 增量为1（过程和插入排序一样）
* 6，5，8，7，10，9
* 5，6，8，7，10，9
* 5，6，7，8，10，9
* 5，6，7，8，9，10
* */
public class ShellSort {
    public static void main(String[] args) {
        int [] arr={10,9,8,7,6,5};
        System.out.println("原数组："+ Arrays.toString( arr ));
        System.out.println( "排序后数组："+Arrays.toString( sort(arr) ) );
    }
    public static int[] sort(int[] arr) {
        int h=1;
        while(h<=arr.length/3) h=h*3+1;//根据克努特序列选取合适的增量
        while(h>=1){//控制增量
            for(int i=h;i<arr.length;i++){//控制某种增量下的轮数
                for(int j=i;j>=h;j-=h){//将一定间距的元素插入并比较交换
                    if(arr[j-h]>arr[j]){
                        int temp=arr[j-h];
                        arr[j-h]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            h=h/3;
        }
        return  arr;
    }
}

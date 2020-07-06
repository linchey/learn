package search;

public class BinarySearch {
    /*根据元素查找第一次出现的索引
     * 二分查找*/
    public static void main(String[] args) {
        int [] arr={10,20,30,40,90,100};
        int res=search(arr,90);
        System.out.println("非递归二分查找结果："+res);
        int res1=searchByRecursion(arr,0,arr.length,90);
        System.out.println("递归二分查找结果："+res1);


    }
    /*非递归*/
    public static int search(int[] arry,int arg) {
        int low=0;
        int high=arry.length;

        while (low<=high){
            int mid=low+((high-low)>>1);
            if(arg==arry[mid]){
                return  mid;
            }
            else if(arg>arry[mid]){
                low=mid+1;
            }
            else if(arg<arry[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
    /*递归*/
    public static int searchByRecursion(int[] arry,int low,int high,int arg) {
        if(low>high){
            return -1;
        }
        int mid=low+((high-low)>>1);
        if(arg==arry[mid]) return mid;
        if(arg>arry[mid]) return searchByRecursion(arry,mid+1,high,arg);
        return searchByRecursion(arry,low,mid-1,arg);
    }
}

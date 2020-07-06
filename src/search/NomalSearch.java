package search;

public class NomalSearch {
    public static void main(String[] args) {
        /*根据元素查找第一次出现的索引
        * 普通查找*/
        int [] arr={10,20,70,10,90,100};
        int res=search(arr,20);
        System.out.println(res);
    }

    public static int search(int[] arry,int arg) {
        for(int i=0;i<arry.length;i++){
            if(arg==arry[i]){
                return i;
            }
        }
        return -1;
    }
}

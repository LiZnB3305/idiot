package 排序;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 桶排序 {
    private  static final int maxValue=50;
    private  static final int maxLen=100;
   public static void sortedArrDistanceLess(int[] arr, int k){
       PriorityQueue<Integer>heap=new PriorityQueue<>(new AComp());//默认自动把输入的数排成小根堆的形式
       int index=0;
       for(; index<=Math.min(arr.length,k) ; index++) {
           heap.add(arr[index]);
       }
       int i=0;
       for(;index<arr.length;i++,index++){
           heap.add(arr[index]);
           arr[i]=heap.poll();
       }
       while(!heap.isEmpty()){
           arr[i++]=heap.poll();
       }
   }

    public static void PrintArray(int[] arr)
    {
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] RandomArray(int maxLen,int maxValue)//随机生成数组
    {
        int len=(int)(Math.random()*maxLen);
        int[] ans=new int[len];
        for(int i=0;i<len;i++)
        {
            ans[i]=(int)(Math.random()*maxValue);
        }
        return ans;
    }
    public static  void main(String[] args){
        int textTime=1000;
        int[] arr=RandomArray(maxLen,maxValue);
        sortedArrDistanceLess(arr,5);
        PrintArray(arr);

    }
}

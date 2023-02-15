package 排序;
public class 堆排序 {
    private  static final int maxValue=50;
    private  static final int maxLen=100;
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<=2) {
            return;
        }
        for(int i=0;i<arr.length;i++) {
            heapInsert(arr,i);
        }
        int heapSize= arr.length;
        swap(arr,0,--heapSize);
        while(heapSize>0)
        {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]) {
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    public static void heapify(int[]arr,int index,int heapSize){
        int left=index<<1+1;
        while (left<heapSize)//还有左孩子的时候
        {
            //两孩子比，谁大返回下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父跟孩子比，谁大谁返回下标给largest
            largest=arr[largest]>arr[index] ? largest : index;
            if(largest==index){break;}
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }
    public static void swap(int[] arr,int i,int j)
    {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
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
    public static void main(String[] args){
        int[] arr=RandomArray(maxLen,maxValue);
        heapSort(arr);
        PrintArray(arr);
    }
}

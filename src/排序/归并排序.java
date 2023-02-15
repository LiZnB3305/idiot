package 排序;

public class 归并排序 {
    private  static final int maxValue=50;
    private  static final int maxLen=100;
    public static void mergeSort(int[] arr)
    {
        if(arr.length<2||arr==null)
        {
            return ;
        }
        progress(arr,0,arr.length-1);
    }
    public static void progress(int[] arr,int L,int R)
    {
        if(L==R)
        {
            return ;
        }
        int mid=L+((R-L)>>1);
        progress(arr,L,mid);
        progress(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L,int M,int R)//合并两个排好序的区域
    {
        int[] help=new int[R-L+1];
        int p1=L;
        int p2=M+1;
        int i=0;
        while( p1 <= M && p2 <= R )
        {
            help[i++]= arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=M)
        {
            help[i++]=arr[p1++];
        }
        while(p2<=R)
        {
            help[i++]=arr[p2++];
        }
        for(i=0;i< help.length;i++)
        {
            arr[L+i]=help[i];
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
    public static void main(String[] args){
        int textTime=1000;
        int[] arr=RandomArray(maxLen,maxValue);

        PrintArray(arr);
    }
}


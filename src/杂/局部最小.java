package 杂;

public class 局部最小 {
    public static int oneMinIndex(int[] arr)
    {
        if(arr==null||arr.length==0)
        {
            return -1;
        }
        int n=arr.length;
        if(n==1)
        {
            return 0;
        }
        if(arr[0]<arr[1])
        {
            return 0;
        }
        if(arr[n-1]<arr[n-2])
        {
            return n-1;
        }
        int L=0;
        int R=n-1;
        while(L < R - 1){
            int mid=L+((R-L)>>1);//int mid=(L+R)/2;
            if(arr[mid]<arr[mid-1]&&arr[mid]<arr[mid+1])
            {
                return mid;
            }else{
                if(arr[mid]>arr[mid-1])
                {
                    R=mid-1;
                }else{
                    L=mid+1;
                }
            }
        }
        return arr[L]<arr[R]?L:R;
    }
    //对数器
    public static int[] RandomArray(int maxLen,int maxValue)//生成随机数组，且邻位不相等
    {
        int len=(int)(Math.random()*maxLen);
        int[] arr=new int[len];
        if(len>0)
        {
            arr[0]=(int)(Math.random()*maxValue);
            for(int i=1;i<len;i++)
            {
               do{
                   arr[i]=(int)(Math.random()*maxValue);
               }while(arr[i] ==arr[i-1]);
            }
        }
        return arr;
    }
    public static boolean check(int[] arr,int maxIndex) {
        if (arr.length == 0)
        {
            return maxIndex==-1;
        }
        int left=maxIndex-1;
        int right=maxIndex+1;
        boolean leftBigger=left>=0 ? arr[left]>arr[maxIndex]:true;
        boolean rightBigger=right<arr.length ? arr[right]>arr[maxIndex]:true;
        return leftBigger&&rightBigger;
    }
    //
    public static void PrintArray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public  static void main(String[] args)
    {
        int textTime=100;
        int maxValue=20;
        int maxLen=10;
        System.out.println("开始");
        for(int i=0;i<textTime;i++)
        {
            int[] arr=RandomArray(maxLen,maxValue);
            int ans=oneMinIndex(arr);
            if(!check(arr,ans))
            {
                PrintArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("结束");
    }
}

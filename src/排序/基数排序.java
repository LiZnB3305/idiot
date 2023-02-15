package 排序;

public class 基数排序 {
    public static void radixSort(int[] arr){
        if(arr.length<2||arr==null) {
            return;
        }
        radixSort(arr,0, arr.length-1,maxbits(arr));
    }
    public static int maxbits(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int res=0;
        while(max!=0){
            res++;
            max/=10;
        }
        return res;
    }
    public static void radixSort(int[] arr,int L,int R,int digit){//digit表示数组中最大值有几个十进制位
        final int radix=10;
        int i=0,j=0;
        int[] bucket=new int[R-L+1];//有几个数准备多少的辅助空间
        for(int d=1; d<= digit; d++) {//入出桶一共有几次（最大数有几个十进制位就进几次）
            int[] count=new int[radix];
            for(i=L ; i<=R ; i++){
                j=getDigit(arr[i],d);
                count[j]++;
            }
            for(i=1;i<radix;i++){
                count[i]=count[i]+count[i-1];
            }
            for(i=R;i>=L;i--){
                j=getDigit(arr[i],d);
                bucket[count[j]-1]=arr[i];
                count[j]--;
            }
            for(i=L,j=0;i<=R;i++,j++){
                arr[i]=bucket[j];
            }
        }

    }
    public static int getDigit(int x,int d){
        return ((x/((int)Math.pow(10,d-1)))%10);
    }
    private  static final int maxValue=50;
    private  static final int maxLen=100;
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
    public static void PrintArray(int[] arr)
    {
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static  void main(String[] args){
        int textTime=1000;
        int[] arr=RandomArray(maxLen,maxValue);
        radixSort(arr);
        PrintArray(arr);

    }
}


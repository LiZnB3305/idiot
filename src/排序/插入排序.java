package 排序;

public class 插入排序 {
    private  static final int maxValue=50;
    private  static final int maxLen=100;
    public static void indexSort(int[] arr)
    {
        if(arr.length<2||arr==null){//插入排序
            return ;
        }
        int n=arr.length;
        for(int end=1; end<n;end++)
        {
            for(int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--) {
                Swap(arr,pre,pre+1);
            }
        }
    }
    public static void Swap(int[] arr,int i,int j)
    {
        int tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
    public static void PrintArry(int[] arr)
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
        indexSort(arr);
        PrintArry(arr);
    }
}






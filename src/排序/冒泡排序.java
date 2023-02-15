package 排序;
public class 冒泡排序
{
    private  static final int maxValue=50;
    private  static final int maxLen=100;
   public static void BubbleSort(int[] arr)
   {
       if(arr.length<2||arr==null)//冒泡排序
       {                      //0~1位置的数比较，谁大谁交换，直到整个数组
                            //得到一个最大的数放在最后一位，
           return ;
       }
       int n=arr.length;
       for(int end=n-1;end>=0;end--) {
           for(int second=1;second<=end;second++) {
               if(arr[second-1]>arr[second]) {
                   Swap(arr,second-1,second);
               }
           }
       }
   }
    public static void minValue(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length-1;i++) {
            min = arr[0] < arr[i] ? arr[0] : arr[i];

        }
    }
   public static void maxValue(int[] arr){
       int max=arr[0];
       for(int i=0;i<arr.length-1;i++){
           max=arr[0]>arr[i]?arr[0]:arr[i];

       }
   }
   public static void Swap(int[] arr,int i,int j)
   {
       int tmp=arr[j];    //arr[i]=arr[i]^arr[j];
       arr[j]=arr[i];     //arr[j]=arr[i]^arr[j];
       arr[i]=tmp;        //arr[i]=arr[i]^arr[j];
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
       BubbleSort(arr);
       PrintArry(arr);
   }
}











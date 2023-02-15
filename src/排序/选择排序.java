package 排序;

public class 选择排序
{
    private  static final int maxValue=50;
    private  static final int maxLen=100;
  public static void selectSort(int[] arr)//选择排序：遍历数组找到最小的数字后把它放到第一位
  {

      if(arr.length<2||arr==null)
      {
          return ;
      }
      int i=0,min=0;
      int n=arr.length;
      for(i=0;i<n;i++){
        min=i;
        for(int j=i+1;j<n;j++)
        {
            min=arr[j]<arr[min] ? j : min;
        }
        swap(arr,i,min);
      }

  }
  public static void swap(int[] arr,int i,int j){
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
        selectSort(arr);
        PrintArry(arr);
    }

}




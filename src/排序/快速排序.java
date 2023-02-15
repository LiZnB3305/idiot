package 排序;

public class 快速排序
{
    private  static final int maxValue=50;
    private  static final int maxLen=100;
    public static void quickSort(int[] arr)
    {
        if(arr.length<2||arr==null)
        {
            return ;
        }
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int L,int R)
    {
        if(L<R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
          int[] p = partition(arr,L,R);
            quickSort(arr, L,p[0]-1);   // <区
            quickSort(arr, p[1]+1, R);  // >区
        }
    }
    public static int[] partition(int[] arr,int L,int R) {
        int less=L-1;
        int more=R;
        while(L<more){
            if(arr[L]<arr[R])
            {
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else{L++;}
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
        public static void PrintArray ( int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        public static int[] RandomArray ( int maxLen, int maxValue)//随机生成数组
        {
            int len = (int) (Math.random() * maxLen);
            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = (int) (Math.random() * maxValue);
            }
            return ans;
        }
        public static void main(String[] args){
            int[] arr=RandomArray(maxLen,maxValue);
            quickSort(arr);
            PrintArray(arr);
        }
}

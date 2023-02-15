package 杂;
public class 位运算 {
    public static void oddTimesNum1(int[] arr){
        int eor=0;
        for(int curNum:arr){
            eor^=curNum;
        }
        int rightOne=eor&(~eor+1);//在二进制中提取最右端的1
        int onlyOne=0;
        for(int cur:arr)
        {
            if((cur&rightOne)==0)
            {
                onlyOne^=cur;
            }
        }
    }
}

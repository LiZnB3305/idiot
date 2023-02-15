package 各种题;
import java.util.HashMap;
/**
 * 一共有n个橘子，每次只能选下面三个方案中的一个吃，求吃完的最小天数
 * 1.每天吃一个
 * 2.如果n能被2整除，可以吃掉n/2个橘子
 * 3.如果n能被3整除，可以吃掉2*（n/3）也就是2/3个橘子
 */
public class Code吃橘子的最小天数 {
    public static HashMap<Integer,Integer> dp = new HashMap<>();
    public static int minDays(int n){
        if(n<=1){return n;}
        if(dp.containsKey(n)){return dp.get(n);}
        int p1=n%2+1+minDays(n/2);
        int p2=n%3+1+minDays(n/3);
        int ans = Math.min(p1,p2);
        dp.put(n,ans);
        return ans;
    }
}

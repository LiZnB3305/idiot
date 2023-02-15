package 各种题;

import java.util.HashMap;

//斐波那契数列
public class Code斐波那契数列 {
    public static int f1(int n){
        if(n==1){return 1;}
        if(n==2){return 1;}
        return f1(n-1)+f1(n-2);
    }
    //记忆化搜索
    public static HashMap<Integer,Integer> fdp=new HashMap<>();
    public static int f2(int n){
        int ans=0;
        if(fdp.containsKey(n)){return fdp.get(n);}
        if(n==1){ans=1;}
        else if (n==2) {ans=1;}
        else{ans=f2(n-1)+f2(n-2);}
        fdp.put(n,ans);
        return ans;
    }
}


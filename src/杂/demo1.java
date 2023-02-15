package 杂;

import java.text.NumberFormat;
import java.util.Scanner;

public class demo1{
    public static void fuck(int n,int max){
        for(int i=0;i<n;i++){
            int b=(int)(Math.random()*max)+1;
            int a=(int)(Math.random()*max)+1;
            System.out.print(a+"乘"+b+"=");
            Scanner a1=new Scanner(System.in);
            int w= a1.nextInt();
          if(w==(a*b)){
              System.out.println("对");
          }
          else{
              System.out.println("错");
              int u=w==(a*b)?0:1;
              while(true) {
                  System.out.print(a + "乘" + b + "=");
                  int a2= a1.nextInt();
                  if (a2 == (a * b)) {
                      break;
                  }
              }
          }

        }
    }
    public static void main(String[] args){
    fuck(5,10);
    }

}

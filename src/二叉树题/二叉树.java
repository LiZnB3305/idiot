package 二叉树题;
import java.util.*;
/*本节主要写二叉树的先序,中序,后序,的遍历(递归与非递归)
如何直观打印一个二叉树
如何求一个二叉树的宽度
 */
public class 二叉树 {
    public static class Node{
        int value;
        public Node left;
        public Node right;
    }
    //递归方法遍历二叉树
    public static void  inOrderRecur(Node head) {//先序遍历（头·左·右）
        if (head == null) {
            return;
        }
        System.out.print(head.value+"  ");
        inOrderRecur(head.left);
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){//中序遍历（左·头·右）
        if(head==null){return ;}
        posOrderRecur(head.left);
        System.out.print(head.value);
        posOrderRecur(head.right);
    }
    public static void preOrderRecur(Node head){//后序遍历（左·右·头）
        if(head==null){return ;}
        preOrderRecur(head.left);

        preOrderRecur(head.right);
        System.out.print(head.value);
    }
    //非递归方法遍历二叉树
    //先序遍历（深度优先遍历）:准备一个栈，把头节点加进去，然后弹出打印，该节点的右孩子先进栈（有的情况下），左孩子再进栈（有的情况下），重复弹出打印。
    public static void inOrderUnRecur(Node head){
        if(head!=null){
            Stack<Node> stack=new Stack<Node>();//准备一个栈
            stack.add(head);
            while(!stack.isEmpty()){
               head=stack.pop();
               System.out.print(head+"  ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null) {
                    stack.push(head.left);
                }
            }

        }
    }
    //中序遍历:对于每个子树把整棵树的左边界进栈（整棵树从头节点开始一直到最低的所有左孩子），然后弹出打印，如果有右树，重复前面的过程
    public static void posOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            while(!s1.isEmpty()||head!=null){
                if(head!=null){
                    s1.push(head);
                    head=head.left;
                }else{
                    head=s1.pop();
                    System.out.print(head.value+" ");
                    head=head.right;
                }

            }
        }
    }
    //后序遍历:两个栈，先把头入s1栈，然后弹出进入s2栈，先压左再压右，重复，最后把s2的所有弹出（后续为左右头，所以先变成头右左然后再逆序）
    public static void preOrderUnRecur(Node head){
        if(head!=null){
            Stack<Node> s1= new Stack<Node>();
            Stack<Node> s2= new Stack<Node>();
            s1.add(head);
            while(!s1.isEmpty()){
                head=s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
            }
            if(head.right!=null){
                s1.push(head.right);
        }
            while(!s2.isEmpty()){
                System.out.print(s2.pop()+"  ");
            }
        }
    }
    public static int  kuanduyouxianbianli(Node head){//宽度优先遍历是指这棵树有多少个节点
        if(head==null){return 0 ;}
        HashMap<Node,Integer> levelMap=new HashMap<>();
        levelMap.put(head,1);
        int curLevel=1;//当前在哪一层
        int curLevelNode=0;//当前层发现了几个节点
        int max=Integer.MIN_VALUE;//这树上节点最多的那一层
        Queue<Node> q1=new LinkedList<>();//linkedlist在java里是生成队列的函数
        q1.add(head);
        while(q1.isEmpty()){
            Node cur=q1.poll();
            int curNodeL=levelMap.get(cur);
            System.out.print(cur.value);
            if(curNodeL==curLevel){
                curLevelNode++;
            }else{
                max=Math.max(max,curLevelNode);
                curLevel++;
                curLevelNode=1;
            }
            if(cur.left!=null){
                levelMap.put(cur.left,curNodeL+1);
                q1.add(cur.left);
            }
            if(cur.right!=null){
                levelMap.put(cur.right,curNodeL+1);
                q1.add(cur.right);
            }
        }
        return max;//小bug：该代码没有统计结束层的最大值和宽度

    }
    public static void main(String[] args) {

    }
}

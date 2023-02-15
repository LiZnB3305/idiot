package 二叉树题;
import java.util.*;

public class 经典题目 {
/**
    （一）如何判断是否是搜索二叉树（BST）

    tip: 使用中序遍历来看节点的值是否是升序的，否则就不是BST
*/

    public static class Node {
        int value;
        public Node left;
        public Node right;
        public Node(int v) {value=v;
    }
}
    public static int preValue=Integer.MIN_VALUE;
    //递归方法
    public static boolean checkBST1(Node head) {
        if (head == null) {return true;}
        boolean isleftBST = checkBST1(head.left);
        if (!isleftBST) {return false;}
        if (head.value <= preValue) {return false;}
        else {preValue = head.value;}
        return checkBST1(head.right);
    }
    //递归方法2
    public static class ReturnData {
        boolean isBST;int min;int max;
        public ReturnData(boolean isB, int mi, int ma) {
            isBST = isB;min = mi;max = ma;
        }
    }
    public static ReturnData progress1(Node x){
            if(x==null){return null;}
            ReturnData leftData = progress1(x.left);
            ReturnData rightData= progress1(x.right);
            int min=x.value;int max=x.value;
            if(leftData!=null){
                min=Math.min(min,leftData.min);
                max=Math.max(max,leftData.max);
            }
            if(rightData!=null){
                min=Math.min(min,rightData.min);
                max=Math.max(max,rightData.max);
            }
            boolean isBst=true;
            if(leftData!=null&&(!leftData.isBST||leftData.max>=x.value)){isBst = false;}
            if(rightData!=null&&(!rightData.isBST||rightData.min<=x.value)){isBst = false;}
            return new ReturnData(isBst,min,max);
        }
    //简单方法
    public static boolean checkBST2(Node head){
        List<Node> inOrderList=new ArrayList<>();
        progress2(head,inOrderList);
        //最后遍历list的值是否都是升序的
        return false;
    }
    public static void progress2(Node head,List<Node> inOrderList){
        if(head==null){
            return ;
        }
        progress2(head.left,inOrderList);
        inOrderList.add(head);
        progress2(head.right,inOrderList);
    }

    //非递归方法
    //中序遍历:对于每个子树把整棵树的左边界进栈（整棵树从头节点开始一直到最低的所有左孩子），然后弹出打印，如果有右树，重复前面的过程
    public static boolean posOrderUnRecur(Node head) {
        if (head != null) {
            int preValue=Integer.MIN_VALUE;
            Stack<Node> s1 = new Stack<Node>();
            while(!s1.isEmpty()||head!=null){
                if(head!=null){
                    s1.push(head);
                    head=head.left;
                }else{
                    head=s1.pop();
                    if(head.value<=preValue){
                        return false;
                    }else{
                        preValue=head.value;
                    }
                    head=head.right;
                }

            }
        }
        return true;

    }

//===============================================================================================================

/**
    （二） 如何判断是否是完全二叉树（CBT）

  tip: 用宽度优先遍历的方式
    1.如果一个节点有右孩子没有左孩子直接return false。
    2.在（1）的条件下，遇到了第一个两个孩子不全的节点，则后续节点都必须是叶节点。
*/

    public static boolean checkCBT(Node head){
        LinkedList<Node> queue=new LinkedList<>();
        boolean leaf=false;
        Node l=null;
        Node r=null;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if(
                    (leaf && (l!=null||r!=null))//遇到孩子不全的节点,而且当前节点有孩子
                    ||
                    (l==null&&r!=null)//有右孩子没有左孩子
            ){
                return false;
            }
            if(l!=null){
                queue.add(l);
            }
            if(r!=null){
                queue.add(r);
            }
            if(l==null||r==null){
                leaf=true;
            }
        }
        return true;
    }
//==================================================================================================================

/**
   (三) 如何判断平衡二叉树

   tip:左树和右树都得平衡 和 左树高度与右树高度差不大于 1 （递归）
*/

    public static boolean isBalaned(Node head){
        return progress3(head).isBalance;
    }
    public static class retrunType{
       public boolean isBalance;
       public int height;
       public retrunType(boolean isB,int hei){
            isBalance=isB;
            height=hei;
       }
    }
    public static retrunType progress3(Node x){
        if(x==null){return new retrunType(true,0);}
        retrunType leftBata = progress3(x.left);
        retrunType rightBata = progress3(x.right);
        int height = Math.max(leftBata.height,rightBata.height)+1;
        boolean isBalence = leftBata.isBalance &&
                rightBata.isBalance && Math.abs(leftBata.height-rightBata.height)<2;
        return new retrunType(isBalence,height);
    }
    //============================================================================================================

  /**
        (四)如何判断满二叉树

        tip：树型DP（动态规划）套路
  */

  public static boolean isFBT(Node head){//主递归顺序
      if(head==null){return true;}
      Info data=progress4(head);
      return data.nodes==((1<<data.height)-1);
  }
  public static class Info{//需要什么数据
      public int height;public int nodes;
      public Info(int hei,int no){
          height=hei;nodes=no;
      }
  }
  public static Info progress4(Node x){//递归过程即处理,其目的是把递归过程串起来，每一个过程都上报一样类型的数据
      if(x==null){return new Info(0,0);}
      Info leftData=progress4(x.left);
      Info rightData=progress4(x.right);
      int height=Math.max(leftData.height,rightData.height)+1;
      int nodes=leftData.nodes+rightData.nodes+1;
      return new Info(height,nodes);
  }

    //============================================================================================================

/**
 *   (五) 给定二叉树两个节点node1和node2，找到他们最低公共祖先节点（第一个汇聚的节点）
 *   tip：
*/
    //o1,02一定属于head树
    public static Node LA(Node head,Node o1,Node o2){
        if(head==null||head==o1||head==o2){return head;}
        Node left=LA(head.left,o1,o2);
        Node right=LA(head.right,o1,o2);
        if(left!=null&&right!=null){return head;}
        return left!=null ? left:right;
    }

    //============================================================================================================

    /**
     *   (六) 在一个二叉树中找到一个节点的后继节点
     *
     *   tip：在二叉树上加一条指针（parent）。
     *
     *   找x的后继：1.x有右树时：其右树最左的那个。
     *            2.x无右树时：往上看是不是其父亲的左孩子，如果不是继续往上看，是则返回。（如果都不是那就是null）
     */

    public static class Node1{
        int value;
        public Node1 left;
        public Node1 right;
        public Node1 parent;
        public Node1(int v){
            value=v;
        }
    }
    public static Node1 getHouJiNode(Node1 head){
        if(head==null){return head;}
        if(head.right!=null){return getLeftMost(head.right);}
        else{
            Node1 p=head.parent;
            while(head.parent!=null&&p.left!=null){
                head=p;
                p=head.parent;
            }
            return p;
        }
    }
    public static Node1 getLeftMost(Node1 head){
        if(head==null){return head;}
        while(head.left!=null){
            head=head.left;
        }
        return head;
    }

//============================================================================================================

/**
    (七) 如何将一个二叉树转成一个字符串，使得字符串可以还原出一个唯一对应的二叉树（值与结构）

     tip：二叉树的序列化与反序列化
*/

public static String serialBypre(Node head){
    if(head==null){return "#_";}
    String res=head.value+"_";
    res+=serialBypre(head.left);
    res+=serialBypre(head.right);
    return res;
}
public static Node reconSerialBypre(String preStr){
    String[] v=preStr.split("_");
    Queue<String> queue= new LinkedList<>();
    for(int i=0;i!= queue.size();i++){queue.add(v[i]);}
    return reconPreOrder(queue);
}
public static Node reconPreOrder(Queue<String> queue){
    String va= queue.poll();
    if(va.equals("#")){return null;}
    Node head=new Node(Integer.valueOf(va));
    head.left=reconPreOrder(queue);
    head.right=reconPreOrder(queue);
    return head;
}

//============================================================================================================

    /**
     * （八） 一张纸条，对着n次，求从上到下折痕的凹凸
     *
     *      tip：其本质是头为凹，所有左子树是凹，右子树是凸的二叉树的中序遍历
     *
     */

    public static void PaperFold(int n){
        printprogress(1,n,true);
    }
public static void printprogress(int i,int n,boolean down){
        if(i>n){return ;}
        printprogress(i+1,n,true);
        System.out.println(down ? "凹":"凸");
        printprogress(i+1,n,false);
}







    public static void main(String[] args) {

    }
}

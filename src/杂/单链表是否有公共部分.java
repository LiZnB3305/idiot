package 杂;

public class 单链表是否有公共部分 {
    public static class Node{//单链表
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        //一个链表有环一个链表没环的两个链表是不可能相交的
        if(loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
    //判断链表有没有环，有则找到链表第一个入环节点
    public static Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node n1=head.next;//慢指针
        Node n2=head.next.next;//快指针
        while(n1!=n2) {
            if (n2.next == null ||n2.next.next==null) {
                return null;
            }
            n2=n2.next.next;
            n1=n1.next;
        }
        n2=head;//快慢指针相遇之后，快指针回到链表开头，然后俩指针一起走，最后相遇的点即是入环节点
        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
    public static Node noLoop(Node head1,Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1=head1;
        Node cur2=head2;
        int n=0;//n是两个链表长度的差值
        while(cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while(cur1!=cur2){
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }
        cur1=n>0?head1:head2;        //谁长谁头变成cur1
        cur2=cur1==head1?head2:head1;//谁短谁变成cur2
        n=Math.abs(n);//取绝对值的函数
        while(n!=0){//长链表先走差值部分，之后两链表一起走，最后相遇的即是入环节点
            n--;
            cur1=cur1.next;
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    //两个有环链表，返回第一个相交节点
    //（1）两个链表互相独立
    // (2)两个链表在环外部分相交，当做单链表相交处理
    //  (3)两个链表交在环上，loop1开始往回转，如果没遇到loop2，说明是第二种情况，如果遇到返回其中一个
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1=null;
        Node cur2=null;
        if(loop1==loop2){
            cur1=head1;
            cur2=head2;
            int n=0;
            while(cur1!=loop1){
                n++;
                cur1=cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            n=Math.abs(n);
            while(n!=0){
                n--;
                cur1=cur1.next;
            }
            while(cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            cur1=loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2){
                    return loop1;//返回loop1和loop2都可以，都叫第一个入环节点
                }
                cur1=cur1.next;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        Node head1=new Node(1);
    }
}

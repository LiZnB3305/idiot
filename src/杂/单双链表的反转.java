package 杂;

public class 单双链表的反转 {
    public class Node{//单链表的创建
        int Value;
        public Node next;
        public Node(int data)
        {
            Value=data;
        }
    }
    public class doubleNode{//双链表的创建
        int Value;
        public doubleNode last;
        public doubleNode next;
        public doubleNode(int data)
        {
            Value=data;
        }
    }
    public static Node reverseLinkedList(Node head){//单链表的反转
        Node pre=null;
        Node next=null;
        while(head!=null)
        {
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static doubleNode reverseDoubleList(doubleNode head){//双链表的反转
        doubleNode pre=null;
        doubleNode next=null;
        while(head!=null)
        {
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static void main(String[]args){

    }
}

package 杂;

public class 单链表结构实现队列和栈{
    public class Node<V>{
        V value;
        Node<V> next;
        public Node(V data){
            value=data;
            next=null;
        }
    }
    public class myQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;
        public myQueue() {
            head = null;
            tail = null;
            size = 0;
        }
        public boolean isEmpty(){
            return size ==0;
        }
        public int size(){
            return size;
        }
        public void offer(V value){
            Node<V>cur=new Node<V>(value);
            if(tail==null)
            {
                tail=cur;
                head=cur;
            }else
            {
                tail.next=cur;
                tail=cur;
            }
            size++;
        }
        public V poll(){//取出这个节点（java里面有JVM能自动清除垃圾数据，在用c/c++时需要手动释放内存）
             V ans=null;
             if(head!=null)
             {
                 ans=head.value;
                 head=head.next;
                 size--;
             }
             if(head==null)
             {
                 tail=null;
             }
             return ans;
        }
        public V peek(){//只把值取出
            V ans=null;
            if(head!=null)
            {
                ans=head.value;
            }
            return ans;
        }

    }
    public class MyStack<V>{
        private Node<V> head;
        int size;
        public MyStack(){
            head=null;
            size=0;
        }
        public boolean isEmpty(){
            return size ==0;
        }
        public int size(){
            return size;
        }
        public void push(V value){
            Node<V>cur=new Node<>(value);
            if(head==null)
            {
                head=cur;
            }else {
                cur.next=head;
                head=cur;
            }
            size++;
        }
        public V pop(){
            V ans=null;
            if(head!=null)
            {
                ans= head.value;
                head=head.next;
                size--;
            }
            return ans;
        }
        public V peek(){
            return head!=null? head.value : null;
        }
    }
}

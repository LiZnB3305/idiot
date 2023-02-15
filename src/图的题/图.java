package 图的题;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class 图 {
    public static class Graph{
        public HashMap<Integer,Node> nodes;
        public HashSet<Edge> edges;
        public Graph(){
            nodes=new HashMap<>();
            edges=new HashSet<>();
        }
    }
    public static class Node{//点集
        public int value;public int in;public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;//有几条该节点发散出去的边
        public Node(int value){
            this.value=value;in=0;out=0;
            nexts=new ArrayList<>();edges=new ArrayList<>();
        }
    }
    public static class Edge{//边集
        public int weight;public Node from;public Node to;
        public Edge(int weight,Node from,Node to){
            this.weight=weight;this.from=from;this.to=to;
        }

    }
}

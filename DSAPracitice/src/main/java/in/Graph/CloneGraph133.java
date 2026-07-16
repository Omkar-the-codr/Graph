package in.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph133 {
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node node, HashMap<Node, Node> map){
        if(node==null) return node;
        if(map.containsKey(node)) return map.get(node);
        ArrayList<Node> arr = new ArrayList<>();
        Node newNode = new Node(node.val, arr);
        map.put(node, newNode);
        for(int i=0;i<node.neighbors.size();i++){
            Node returnedNode = dfs(node.neighbors.get(i),map);
            newNode.neighbors.add(returnedNode);
        }
        return newNode;
    }
}

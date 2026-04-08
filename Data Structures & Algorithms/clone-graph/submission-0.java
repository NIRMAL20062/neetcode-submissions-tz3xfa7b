/*
Definition for a Node.
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
*/

class Solution {
    // original node → its clone
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // already cloned this node, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create clone for current node (neighbours added later)
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // recurse into each neighbour, add clone of neighbour to clone's list
        for (Node neighbour : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbour));
        }

        return clone;
    }
}
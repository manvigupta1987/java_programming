package Tree;

import java.util.LinkedList;
import java.util.List;

public class ConvertBstToBalancedBST {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    Node root = null;

    public static void storeNodesIntoList(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        storeNodesIntoList(root.left, nodes);
        nodes.add(root);
        storeNodesIntoList(root.right, nodes);
    }

    public static Node buildTreeUtil(List<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node node = nodes.get(mid);
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid+1, end);

        return node;
    }

    public static Node buildTree(Node root) {
        List<Node> nodes = new LinkedList<>();
        storeNodesIntoList(root, nodes);

        int size = nodes.size();

        return buildTreeUtil(nodes, 0, size-1);

    }

    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Driver program to test the above functions
    public static void main(String[] args)
    {
         /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        ConvertBstToBalancedBST tree = new ConvertBstToBalancedBST();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }

}

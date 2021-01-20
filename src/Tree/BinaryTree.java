package Tree;

// Binary tree should have atmost 2 children.
// At each level, it can have 2 to the power l. .
// The Maximum number of nodes in a binary tree of height ‘h’ is 2 to the power of h – 1.
//In Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes with two children.

// Different type of Binary Tree:
// 1. Full Binary Tree: A Binary Tree is full when each node has 0 or 2 children. Number of leaf node in full binary tree is number of
//... internal nodes plus 1.
// 2. Complete Binary Tree: A Binary Tree is a Complete Binary Tree if all the levels are completely filled except possibly the last level
// ...and the last level has all keys as left as possible
// 3. Perfect Binary Tree: A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level.


// Insertion in Binary Tree --> https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
// Output : Inorder traversal before insertion: 7 11 10 15 9 8
//...       Inorder traversal after insertion: 7 11 12 10 15 9 8

// A tree can be traversed in two ways:
//.. 1. BFS
//.. 2. DFS: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
//.... 1. Inorder Traversal (Left-Root-Right)
//.... 2. PreOrder Traversal (Root-Left-Right)
//.... 3. PostOrder Traversal (Left-Right-Root)
// All the above traversal takes O(n)


import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/
public class BinaryTree {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    static Node root = null;

    static void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                return;
            } else {
                queue.add(temp.right);
            }
        }
    }

    static void deleteLeafNode(Node delNode) {
        Queue<Node> q = new LinkedList<>();
        Node temp = null;
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp == delNode) {
                temp = null;
                return;
            }
            // this needs to be done here as we need to break the link of the node from the tree.
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }
    }

    static void delete(int key) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node temp = root, nodeToDelete = null;
        queue.add(temp);
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if (temp.key == key) {
                nodeToDelete = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        // idea is to replace the value of nodeTodelete with the leaf node. leaf node will be deleted from the tree.
        if (nodeToDelete != null) {
            int x = temp.key; // temp will point to the leaf node.
            deleteLeafNode(temp);
            nodeToDelete.key = x;
        }
    }

    static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();
            System.out.print(temp.key + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    //1. Traverse the left subtree, i.e., call Inorder(left-subtree)
    //   2. Visit the root.
    //   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }

    static int minimumDepthOfTree() {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        int depth = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i<size; i++) {
                temp = queue.peek();
                queue.remove();

                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            depth++;
        }
        return -1;
    }

    static int maximumDepthOfTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lDepth = maximumDepthOfTree(node.left);
            int rDepth = maximumDepthOfTree(node.right);

            if (lDepth > rDepth) {
                return lDepth +1;
            } else {
                return rDepth +1;
            }
        }
    }


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion:");
        inorder(root);

        insert(12);
        System.out.print("\nInorder traversal after insertion:");
        inorder(root);

        delete(11);
        System.out.print("\nInorder traversal after deletion:");
        inorder(root);

        // Tree Traversal
        System.out.print("\nBFS or level order traversal:");

        BFS();

        System.out.print("\nDFS traversal:");
        System.out.print("\ninorder traversal:");
        inorder(root);
        System.out.print("\npreorder traversal:");
        preorder(root);
        System.out.print("\npostorder traversal:");
        postorder(root);

        // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
        System.out.println("\nMinimum Depth of Tree :" + minimumDepthOfTree());
        insert(2);
        insert(1);
        // https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
        System.out.println("\nMaximum Depth of Tree :" + maximumDepthOfTree(root));
        BFS();
    }

}

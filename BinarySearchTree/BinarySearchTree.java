public class BinarySearchTree {
    Node root;

    // Node structure containing the subtrees
    static class Node {
        public int item;
        public Node left;
        public Node right;


        // Your code here
        public Node(int item) {
            this.item = item;
        }

    }

    ;

    // Constructor
    public BinarySearchTree() {
        // Your code here
        this.root = null;


    }

    // Insert new item into the binary tree
    public void insert(int data) {
        // Your code here
        root = insert(this.root, data);

    }

    public Node insert(Node root, int item) {

        if (root == null) {
            root = new Node(item);
            return root;
        }

        if (item < root.item) {
            root.left = insert(root.left, item);
        } else if (item > root.item) {
            root.right = insert(root.right, item);
        }
        return root;
    }

    // Check if the tree is balanced or not
    public boolean isBalanced() {
        // Your code here
        return isBalanced(this.root);

    }

    public boolean isBalanced(Node root) {
        if (root == null) return true;
        if (Math.abs(findHeight(root.left) - findHeight(root.right)) < 2) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    private int findHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));

    }

    // Remove an item from the tree
    public void remove(int item) {
        // Your code here
        root = remove(this.root, item);

    }

    public Node remove(Node root, int item) {

        if (root == null) {
            return root;
        }

        if (item < root.item) {
            root.left = remove(root.left, item);
        } else if (item > root.item) {
            root.right = remove(root.right, item);
        } else {
            if (root.left == null && root.right == null) root = null;

            else if (root.left == null || root.right == null) {
                root = root.right == null ? root.left : root.right;
            }
            // The node has 2 children
            else {
                Node successor = findMin(root.right);
                swapData(successor, root);
                root.right = remove(root.right, successor.item);

            }
        }


        return root;

    }

    private void swapData(Node successor, Node root) {
        int temp = successor.item;
        successor.item = root.item;
        root.item = temp;
    }

    public Node findMin(Node root) {
        if (root.left != null) {
            return findMin(root.left);
        }
        return root;
    }

    // Compare two trees. Return true if both trees are same
    public boolean compareTo(BinarySearchTree tree) {
        // Your code here
        return compareTo(tree.root, this.root);


    }

    public boolean compareTo(Node newRoot, Node root) {

        if (newRoot == null && root == null) {
            return true;
        }
        if (newRoot == null || root == null) {
            return false;
        } else {
            if (newRoot.item == root.item) {
                return compareTo(newRoot.left, root.left) && compareTo(newRoot.right, root.right);
            } else {
                return false;
            }
        }
    }


    // Given function to print the tree

    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.item + " ");
            printInOrder(root.right);
        }
    }
}


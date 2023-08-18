import java.awt.*;
import java.util.LinkedList;

public class BinarySearchTree {
    private BinaryTreeNode root;

    private void inOrderTraversalImp(BinaryTreeNode root) {
        if (root != null) {
            inOrderTraversalImp(root.left);
            System.out.print(root.data);
            System.out.print(" ");
            inOrderTraversalImp(root.right);
        }
    }

    public void inOrderTraversal() {
        System.out.print("[");
        inOrderTraversalImp(root);
        System.out.println("]\n");
    }

    public static void preOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }


    public void breadthFirstTraversal() {
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp = root;
        queue.add(temp);

        while(temp != null) {

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            System.out.println(queue.remove().data);
            temp = queue.peek();
        }
    }

    private void insertImp(BinaryTreeNode root, BinaryTreeNode newNode) {
        if (root.data > newNode.data) {
            if (root.left != null) {
                insertImp(root.left, newNode);
            } else {
                root.left = newNode;
            }
        } else {
            if (root.right != null) {
                insertImp(root.right, newNode);
            } else {
                root.right = newNode;
            }
        }
    }

    public void insert(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) {
            root = newNode;
        } else {
            insertImp(root, newNode);
        }

    }

    private void minimumImp(BinaryTreeNode root) {
        if (root != null) {
            minimumImp(root.left);
            if (root.left == null) {
                System.out.print(root.data);
            }
        }
    }

    public void minimum() {
        System.out.print("[");
        minimumImp(root);
        System.out.println("]\n");
    }

    private void maximumImp(BinaryTreeNode root) {
        if (root != null) {
            if (root.right == null) {
                System.out.print(root.data);
            }
            maximumImp(root.right);
        }
    }

    public void maximum() {
        System.out.print("[");
        maximumImp(root);
        System.out.println("]\n");
    }

    private BinaryTreeNode deleteImp(BinaryTreeNode root, int data) {
        if (root != null) {
            deleteImp(root.left, data);
            deleteImp(root.right, data);
            System.out.println(root.data);
            if (root.data == data) {
                if (root.right == null && root.left == null) {
                    root = null;
                    System.out.println("no child");
                } else if (root.right == null || root.left == null) {
                    if (root.left != null) {
                        root = root.left;
                        System.out.println("one child");
                    } else if (root.right != null) {
                        root = root.right;
                        System.out.println("one child");
                    }
                }
            }
        }
        return root;
    }

    public void delete(int data) {
        root = deleteImp(root, data);
    }










}

class BinarySearchTreeRunner {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(32);
        binarySearchTree.insert(54);
        binarySearchTree.insert(12);
        binarySearchTree.insert(16);
        binarySearchTree.insert(17);
        binarySearchTree.insert(92);
        binarySearchTree.insert(100);
        binarySearchTree.insert(55);
        binarySearchTree.breadthFirstTraversal();
        binarySearchTree.inOrderTraversal();
        binarySearchTree.minimum();
        binarySearchTree.maximum();
        binarySearchTree.delete(16);
        binarySearchTree.inOrderTraversal();
    }

}


















import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    BinaryTreeNode root;

    public static void inOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
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


    public static void breadthFirstTraversal(BinaryTreeNode root) {
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

   @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

}


class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTreeNode(1);
        binaryTree.root.right = new BinaryTreeNode(3);
        binaryTree.root.left = new BinaryTreeNode(2);
        binaryTree.root.left.left = new BinaryTreeNode(4);
        binaryTree.root.left.right = new BinaryTreeNode(5);
        binaryTree.root.right.left = new BinaryTreeNode(6);
        binaryTree.root.right.right = new BinaryTreeNode(7);

        System.out.println("In - Order traversal");
        BinaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Pre - Order traversal");
        BinaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Post - Order traversal");
        BinaryTree.postOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Breadth first traversal");
        BinaryTree.breadthFirstTraversal(binaryTree.root);

    }
}








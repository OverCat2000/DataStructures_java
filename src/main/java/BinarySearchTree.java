import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

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

        while (temp != null) {

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
            maximumImp(root.right);
            if (root.right == null) {
                System.out.print(root.data);
            }
        }
    }

    public void maximum() {
        System.out.print("[");
        maximumImp(root);
        System.out.println("]\n");
    }

    private BinaryTreeNode deleteImp(BinaryTreeNode root, int data) {
        if (root != null) {
            if (root.data < data) {
                root.right = deleteImp(root.right, data);
                System.out.println("right");
            } else if (root.data > data) {
                root.left = deleteImp(root.left, data);
                System.out.println("left");
            } else if (root.data == data) {
                if (root.right == null && root.left == null) {
                    root = null;
                    System.out.println("no child");
                } else if (root.right == null || root.left == null) {
                    if (root.left != null) {
                        root = root.left;
                        System.out.println("one left child");
                    } else if (root.right != null) {
                        root = root.right;
                        System.out.println("one right child");
                    }
                }else if (root.right != null && root.left != null) {
                    System.out.println("both child");
                    BinaryTreeNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    deleteImp(root, temp.data);
                    root.data = temp.data;
                }
            }
        }
        System.out.println("hello");
        return root;
    }


    public void delete(int data) {
        root = deleteImp(root, data);
    }

    public BinaryTreeNode deleteByMergeImp(BinaryTreeNode root, int data) {
        if (root != null) {
            if (root.data > data) {
                root.left = deleteByMergeImp(root.left, data);
            } else if (root.data <  data) {
                root.right = deleteByMergeImp(root.right, data);
            } else if (root.data == data) {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left == null || root.right == null) {
                    if (root.left != null) {
                        root = root.left;
                    } else if (root.right != null) {
                        root = root.right;
                    }
                } else if (root.right != null && root.left != null) {
                    BinaryTreeNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    temp.left = root.left;
                    root.left = null;
                    root = deleteByMergeImp(root, root.data);
                }
            }
        }
        return root;
    }

    public void deleteByMerge(int data) {
        root = deleteByMergeImp(root, data);
    }




    public void treePrintImp(BinaryTreeNode root, int n) {
        if (root != null) {
            String str = "\t";
            treePrintImp(root.right, n + 1);
            for (int i = 0; i < n; i++) {
                System.out.print(str);
            }
            System.out.println(root.data);
            treePrintImp(root.left, n + 1);
        }
    }

    public void treePrint() {
        treePrintImp(root, 0);
        System.out.println();
    }

    public void lowestLevelImp(BinaryTreeNode root, int n, List<Integer> arr) {
        if (root != null) {
            lowestLevelImp(root.left, n + 1, arr);
            arr.add(n);
            lowestLevelImp(root.right, n + 1, arr);
        }
    }

    public int lowestLevel() {
        List<Integer> arr = new ArrayList<Integer>();
        lowestLevelImp(root, 1, arr);
        return Collections.max(arr);
    }

    @Override
    public String toString() {
        String output = "";

        java.util.Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp = root;
        queue.add(temp);

        int parent = 0;
        int child = 0;
        int tab = lowestLevel();
        for (int i = 0; i < tab; i++) {
            output = output + " ";
        }
        tab = tab - 1;

        while (temp != null) {
            output = output + queue.remove().data + "  ";
            if (temp.left != null) {
                queue.add(temp.left);
                child = child + 1;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                child = child + 1;
            }
            if (parent == 0) {
                output = output + "\n";
                for (int i = 0; i < tab; i++) {
                    output = output + " ";
                }
                tab = tab - 1;
                parent = child;
                child = 0;
            }
            parent = parent - 1;

            temp = queue.peek();
        }
        return output;
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
        binarySearchTree.insert(99);
        binarySearchTree.insert(90);
        binarySearchTree.insert(50);
        binarySearchTree.insert(98);
        binarySearchTree.insert(85);
        binarySearchTree.insert(91);
        binarySearchTree.insert(110);
        binarySearchTree.treePrint();
//        System.out.println(binarySearchTree.toString());
//        binarySearchTree.breadthFirstTraversal();
//        binarySearchTree.inOrderTraversal();
//        binarySearchTree.minimum();
//        binarySearchTree.maximum();
//        binarySearchTree.deleteByMerge(92);
        binarySearchTree.delete(92);
        binarySearchTree.treePrint();
        binarySearchTree.inOrderTraversal();
    }

}


















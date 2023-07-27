class TreeNode{
    String data;
    TreeNode child;
    TreeNode sibling;

    TreeNode(String data) {
        this.data = data;
        this.child = null;
        this.sibling = null;
    }
}

public class Tree {

}

class LumberJack {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("Dean FOS");
        root.child = new TreeNode("DH Bio");
        root.child.sibling = new TreeNode("DH Maths");
    }
}
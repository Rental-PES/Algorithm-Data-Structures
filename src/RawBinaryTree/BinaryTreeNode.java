package RawBinaryTree;

public class BinaryTreeNode {
    BinaryTreeNode right;
    BinaryTreeNode left;
    BinaryTreeNode parent;
    Object data;


    BinaryTreeNode(Object data){
        this.data = data;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}

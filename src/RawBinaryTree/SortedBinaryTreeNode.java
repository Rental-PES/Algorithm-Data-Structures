package RawBinaryTree;

public class SortedBinaryTreeNode {
    SortedBinaryTreeNode right;
    SortedBinaryTreeNode left;
    SortedBinaryTreeNode parent;
    int data;


    SortedBinaryTreeNode(int data){
        this.data = data;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public void setLeft(SortedBinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(SortedBinaryTreeNode right) {
        this.right = right;
    }

    public void setParent(SortedBinaryTreeNode parent) {
        this.parent = parent;
    }
}

package MODUL4;

public class BinaryTreeNode {
    BinaryTreeNode right;
    BinaryTreeNode left;
    BinaryTreeNode parent;
    String data;
    int level = 1;


    BinaryTreeNode(String data){
        this.data = data;
    }

    BinaryTreeNode(String data, int level){
        this.data = data;
        this.level = level;
    }

    public String getRightData() {
        if (left == null) return  "-";
        return right.data;
    }

    public String getLeftData() {
        if (left == null) return  "";
        return left.data + " & ";
    }


}

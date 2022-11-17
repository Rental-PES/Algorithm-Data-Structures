package MODUL5;

public class BinaryTreeNode {
    BinaryTreeNode right;
    BinaryTreeNode left;
    BinaryTreeNode parent;
    String data;


    BinaryTreeNode(String data){
        this.data = data;
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

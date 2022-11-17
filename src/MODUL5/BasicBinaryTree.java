package MODUL5;


public class BasicBinaryTree {
    BinaryTreeNode root = null;
    BinaryTreeNode current;

    public void backToParent(){
        current =  current.parent;
    }

    public void nextToRight(){
        current = current.right;
    }

    public void nextToLeft(){
        current = current.left;
    }

    public void makeTree(String data){
        if (isEmpty()){
            root = current = new BinaryTreeNode(data);
            System.out.println(root.data + " Dibuat sebagai root");
        } else {
            System.out.println("Error: Tree Sudah Dibuat");
        }
    }

    public void setLeft(String data){
        if (isEmpty()){
            makeTree(data);
        } else {
            current.left = new BinaryTreeNode(data);
            current.left.parent = current;
            current = current.left;
            System.out.println(current.data + " Ditambahkan Sebagai Left Dari " + current.parent.data );
        }
    }

    public void setRight(String data){
        if (isEmpty()){
            makeTree(data);
        } else {
            current.right = new BinaryTreeNode(data);
            current.right.parent = current;
            current = current.right;
            System.out.println(current.data + " Ditambahkan Sebagai Right Dari " + current.parent.data );
        }
    }


    public boolean isEmpty(){
        return root == null;
    }


    String getChildren(BinaryTreeNode node){
        String res = "";
        res += node.getLeftData()  + node.getRightData();
        return  res;
    }

    public void  doInorder(){
        BinaryTreeNode binaryTreeNode = root;
        printInorder(binaryTreeNode);
    }

    private void printInorder(BinaryTreeNode node){
        if (node != null) {
            printInorder(node.left);
            System.out.println(node.data + " : " + getChildren(node));
            printInorder(node.right);
        }
    }


    void doPreorder() {
        printPreorder(root);
    }

    void printPreorder(BinaryTreeNode node){
        if (node != null) {
            System.out.println(node.data + " : " + getChildren(node));
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }


    void doPostorder() {
        printPostorder(root);
    }

    void printPostorder(BinaryTreeNode node){
        if (node != null) {
            printPreorder(node.left);
            printPreorder(node.right);
            System.out.println(node.data + " : " + getChildren(node));
        }
    }


}

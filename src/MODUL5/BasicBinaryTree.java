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

    public void  doInorderTraversal(){
        BinaryTreeNode binaryTreeNode = current;
        inorderTraversal(binaryTreeNode);
    }



    private void inorderTraversal(BinaryTreeNode node){
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

}

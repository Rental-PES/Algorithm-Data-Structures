package RawBinaryTree;


import RawTree.Node;

public class BasicBinaryTree {
    BinaryTreeNode root = null;
    BinaryTreeNode current ;

    public void backToParent(){
        current =  current.parent;
    }

    public void nextToRight(){
        current = current.right;
    }

    public void nextToLeft(){
        current = current.left;
    }

    public void makeTree( Object data){
        if (isEmpty()){
            root = current = new BinaryTreeNode(data);
            System.out.println("Success: Tree Berhasil Dibuat");
        } else {
            System.out.println("Error: Tree Sudah Dibuat");
        }
    }

    public void setLeft(Object object){
        if (isEmpty()){
            makeTree(object);
        } else {
            current.left = new BinaryTreeNode(object);
            current.left.parent = current;
            current = current.left;
        }
    }

    public void setRight(Object object){
        if (isEmpty()){
            makeTree(object);
        } else {
            current.right = new BinaryTreeNode(object);
            current.right.parent = current;
            current = current.right;

        }
    }

    public void  showCurrent(){
        System.out.println("-------------------------------");
        System.out.println("Current : " + current.data + " | left : " + current.left.data + " | right : " + current.right.data);
        System.out.println("-------------------------------");
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

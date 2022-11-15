package RawBinaryTree;

public class SortedBinaryTree {
    SortedBinaryTreeNode root = null;
    SortedBinaryTreeNode current ;



    public void push(int data){
        if (isEmpty()){
            makeTree(data);
        } else {
            SortedBinaryTreeNode newNode = new SortedBinaryTreeNode(data);
            SortedBinaryTreeNode pivot = root;
            while (pivot!=null){
                if (data> pivot.data){
                    if (pivot.right == null){
                        pivot.setRight(newNode);
                        break;
                    }
                    pivot = pivot.right;
                } else {
                    if (pivot.left == null){
                        pivot.setLeft(newNode);
                        break;
                    }
                    pivot = pivot.left;
                }

            }
        }
    }

    public void makeTree( int data){
        if (isEmpty()){
            root = current = new SortedBinaryTreeNode(data);
            System.out.println("Success: Tree Berhasil Dibuat");
        } else {
            System.out.println("Error: Tree Sudah Dibuat");
        }
    }


    public boolean isEmpty(){
        return root == null;
    }

    public void  doInorderTraversal(){
        SortedBinaryTreeNode binaryTreeNode = current;
        inorderTraversal(binaryTreeNode);
    }



    private void inorderTraversal(SortedBinaryTreeNode node){
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

}

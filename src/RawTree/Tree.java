package RawTree;

public class Tree {
    Node root = null;
    Node current ;


    public void backToParent(){
        current =  current.parent;
    }

    public void nextToRight(){
        current = getRight();
    }

    public void nextToLeft(){
        current = getLeft();
    }

    public void  showCurrent(){
        System.out.println("-------------------------------");
        System.out.println("Current : " + current.object + " | left : " + getLeft().object + " | right : " + getRight().object);
        System.out.println("-------------------------------");
    }

    public void setLeft(Object object){
        if (isEmpty()){
            current = new Node();
            current.left = new Node(object);
        } else {
            current.left = new Node(object);
            current.left.parent = current;
            current = current.left;
        }
    }

    public void setRight(Object object){
        if (isEmpty()){
            current = new Node();
            current.right = new Node(object);
        } else {
            current.right = new Node(object);
            current.right.parent = current;
            current = current.right;

        }
    }

    public void makeTree( Object obj){
        if (isEmpty()){
            root = current = new Node(obj);
            System.out.println("Success: Tree Berhasil Dibuat");
        } else {
            System.out.println("Error: Tree Sudah Dibuat");
        }
    }








    public Node getRight(){
        return  current.right;
    }
    public Node getLeft(){
        return  current.left;
    }

    public boolean isEmpty(){
        return root == null;
    }




}

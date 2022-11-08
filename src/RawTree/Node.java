package RawTree;

public class Node {
    Node right;
    Node left;
    Node parent;
    Object object;


    Node(Node right, Node left, Node parent, Object object){
        this.parent = parent;
        this.right = right;
        this.left = left;
        this.object = object;
    }

    Node(Node right, Node left, Object object){
        this.right = right;
        this.left = left;
        this.object = object;
    }
    Node(Object object){
        this.right = null;
        this.left = null;
        this.parent = null;
        this.object = object;
    }

    Node(){
        this.right = null;
        this.left = null;
        this.parent = null;
        this.object = null;
    }

}

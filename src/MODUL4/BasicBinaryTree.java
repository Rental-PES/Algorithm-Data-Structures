package MODUL4;


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
            current.left = new BinaryTreeNode(data, (current.level+1));
            current.left.parent = current;
            current = current.left;
            System.out.println(current.data + " Ditambahkan Sebagai Left Dari " + current.parent.data );
        }
    }

    public void setRight(String data){
        if (isEmpty()){
            makeTree(data);
        } else {
            current.right = new BinaryTreeNode(data, (current.level+1));
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


    public void  printAll(){
        BinaryTreeNode binaryTreeNode = root;
        print(binaryTreeNode);
    }



    private void print(BinaryTreeNode node){
        if (node != null){
            print(node.left);
            System.out.println(node.data + " level : " + node.level);
            print(node.right);
        }
    }

    public  BinaryTreeNode doFindNode(String key){
        BinaryTreeNode pivot = root;
        BinaryTreeNode res = findNode(pivot, key);
        return  res;
    }

    private BinaryTreeNode findNode(BinaryTreeNode node, String key) {
        if (node == null) return null;
        if (node.data == key) return node;
        BinaryTreeNode res1 = findNode(node.left, key);
        if (res1 != null && res1.data.equals(key)) return res1;
        return findNode(node.right, key);
    }

    boolean isAnak(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (node1.parent.data == node2.data) {
            System.out.println(target1 + " Merupakan Anak Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Anak Dari " + target2);
            return false;
        }
    }

    boolean isCucu(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (node1.parent.parent.data == node2.data) {
            System.out.println(target1 + " Merupakan Cucu Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Cucu Dari " + target2);
            return false;
        }
    }

    boolean isCucuJauh(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (((node1.level - node2.level) == 2) &&(node1.parent.parent.data != node2.data)) {
            System.out.println(target1 + " Merupakan Cucu Jauh Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Merupakan Cucu Jauh Dari " + target2);
            return false;
        }
    }

    boolean isCicit(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (node1.parent.parent.parent.data == node2.data) {
            System.out.println(target1 + " Merupakan Cicit Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Cicit Dari " + target2);
            return false;
        }
    }

    boolean isKeponakan(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (node1.parent.parent.data == node2.parent.data) {
            System.out.println(target1 + " Merupakan Keponakan Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Merupakan Keponakan Dari " + target2);
            return false;
        }
    }

    boolean isKeponakanJauh(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if (((node1.level - node2.level) == 1) && (node1.parent.data != node2.data)) {
            System.out.println(target1 + " Merupakan Keponakan Jauh Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Keponakan Jauh Dari " + target2);
            return false;
        }
    }

    boolean isSaudara(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if ((node2.level == node1.level) && (node1.parent.data == node2.parent.data)) {
            System.out.println(target1 + " Merupakan Saudara Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Saudara Jauh Dari " + target2);
            return false;
        }
    }

    boolean isSaudaraJauh(String target1, String target2){
        BinaryTreeNode node1 = doFindNode(target1);
        BinaryTreeNode node2 = doFindNode(target2);
        if ((node2.level == node1.level) && (node1.parent.data != node2.parent.data)) {
            System.out.println(target1 + " Merupakan Saudara Jauh Dari " + target2);
            return true;
        }
        else {
            System.out.println(target1 + " Bukan Merupakan Saudara Jauh Dari " + target2);
            return false;
        }
    }





}

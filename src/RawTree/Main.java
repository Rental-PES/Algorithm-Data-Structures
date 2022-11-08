package RawTree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.makeTree(10); // 10
        tree.setLeft(20); // 20<-10
        tree.backToParent(); // 10
        tree.setRight(30); // 20<-10->30
        tree.backToParent(); // 10
        tree.showCurrent();

    }
}

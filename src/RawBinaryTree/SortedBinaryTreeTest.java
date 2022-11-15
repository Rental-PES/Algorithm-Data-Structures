package RawBinaryTree;

public class SortedBinaryTreeTest {
    public static void main(String[] args) {
        SortedBinaryTree bt = new SortedBinaryTree();
        bt.push(33);
        bt.push(86);
        bt.push(92);
        bt.push(12);
        bt.push(25);
        bt.push(48);
        bt.push(37);
        bt.doInorderTraversal();
    }
}

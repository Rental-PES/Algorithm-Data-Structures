package MODUL5;

public class Main {
    public static void main(String[] args) {
        BasicBinaryTree family = new BasicBinaryTree();
        family.makeTree("Daus");

        family.setLeft("Putri");
        family.backToParent();
        family.setRight("Daden");
        family.backToParent();

        family.nextToLeft();
        family.setLeft("Ari");
        family.backToParent();
        family.setRight("Lilul");
        family.backToParent();

        family.backToParent();

        family.nextToRight();
        family.setLeft("Arsan");
        family.backToParent();
        family.setRight("Jidan");
        family.backToParent();

        family.backToParent();
        family.nextToLeft();

        family.nextToLeft();
        family.setLeft("Uno");
        family.backToParent();
        family.setRight("Shafa");

        family.backToParent();
        family.backToParent();

        family.nextToRight();
        family.setLeft("Diaz");
        family.backToParent();
        family.setRight("Melki");

        family.backToParent();
        family.backToParent();
        family.backToParent();

        family.nextToRight();

        family.nextToLeft();
        family.setLeft("Mahen");
        family.backToParent();
        family.setRight("Alita");

        family.backToParent();
        family.backToParent();

        family.nextToRight();
        family.setLeft("Rozaki");
        family.backToParent();
        family.setRight("Agung");






    }
}

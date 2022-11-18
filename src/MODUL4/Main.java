package MODUL4;

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



        System.out.println("\nHubungan");
        family.isAnak("Putri", "Daus");
        family.isCicit("Shafa", "Daus");
        family.isSaudara("Mahen", "Alita");
        family.isSaudaraJauh("Mahen", "Uno");
        family.isCucu("Lilul", "Daus");
        family.isCucuJauh("Melki", "Daden");
        family.isKeponakan("Rozaki", "Arsan");
        family.isKeponakanJauh("Rozaki", "Ari");
        family.isSaudaraJauh("Diaz", "Agung");


        System.out.println("\nIn-Order\nParent : Child");
        family.doInorder();

        System.out.println("\nPre-Order\nParent : Child");
        family.doPreorder();

        System.out.println("\nPost-Order\nParent : Child");
        family.doPostorder();






    }
}

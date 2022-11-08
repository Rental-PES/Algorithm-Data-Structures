package MODUL2.NO1;

// membuat class Node dengan nama Node
public class Node {
    // membuat atribut value dengan tipe data string
    public String value;
    // membuat atribut next dengan tipe data Node
    public Node next;
    // membuat constructor dengan parameted value yang akan menjadi nilai pengisi untuk atribut value
    Node(String value){
        // this.value menandakan bahwa variabel tersebut milik class node
        this.value = value;
    }
}

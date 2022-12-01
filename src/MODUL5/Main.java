package MODUL5;

public class Main {
    public static void main(String[] args) {
        Graph graph1970 = new Graph();
        graph1970.insert("newyork");
        graph1970.insert("markas shield");
        graph1970.insert("wakanda");
        graph1970.insert("asgard");
        graph1970.insert("vormir");

        graph1970.insertEdge("newyork", "asgard");
        graph1970.insertEdge("newyork", "markas shield");
        graph1970.insertEdge("asgard", "vormir");
        graph1970.insertEdge("wakanda", "newyork");
        graph1970.insertEdge("markas shield", "wakanda");


        graph1970.printAll();



        Graph graph2012 = new Graph();
        graph2012.insert("newyork");
        graph2012.insert("sanctum sanctorum");
        graph2012.insert("morag");
        graph2012.insert("kekalik");
        graph2012.insert("midgard");

        graph2012.insertEdge("newyork", "sanctum sanctorum");
        graph2012.insertEdge("sanctum sanctorum", "morag");
        graph2012.insertEdge("sanctum sanctorum", "midgard");
        graph2012.insertEdge("midgard", "kekalik");
        graph2012.insertEdge("morag", "kekalik");
        graph2012.printAll();




        Graph graph2015 = new Graph();
        graph2015.insert("hollywood");
        graph2015.insert("knowhere");
        graph2015.insert("new york");
        graph2015.insert("vormir");
        graph2015.insert("asgard");
        graph2015.insert("qatar");
        graph2015.insert("valencia");

        graph2015.insertEdge("hollywood", "knowhere");
        graph2015.insertEdge("vormir", "hollywood");
        graph2015.insertEdge("knowhere", "new york");
        graph2015.insertEdge("new york", "vormir");
        graph2015.insertEdge("new york", "asgard");
        graph2015.insertEdge("new york", "valencia");
        graph2015.insertEdge("asgard", "qatar");
        graph2015.insertEdge("valencia", "qatar");
        graph2015.printAll();
    }
}
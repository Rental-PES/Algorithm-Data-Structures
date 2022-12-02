package MODUL5;

public class Main {
    public static void main(String[] args) {
        Graph graph1970 = new Graph("1970");
        graph1970.insert("newyork",
                new String[]{"Super Serum", "Mie Ayam Ceker"});
        graph1970.insert("markas shield",
                new String[]{"Partikel Pym", "Seblak Korea"});
        graph1970.insert("wakanda",
                new String[]{"Vibranium", "Adamantium"});
        graph1970.insert("asgard",
                new String[]{"Mjolnir", "Sprite"});
        graph1970.insert("vormir",
                new String[]{"Soul Stone", "Ceker Mercon"});

        graph1970.insertEdge("newyork", "markas shield");
        graph1970.insertEdge("newyork", "asgard");
        graph1970.insertEdge("markas shield", "wakanda");
        graph1970.insertEdge("asgard", "vormir");
        graph1970.insertEdge("wakanda", "newyork");
        System.out.println("BFS\nTahun 1970");
        graph1970.bfs(graph1970.searchGraphContainer("newyork"));


        Graph graph2012 = new Graph("2012");
        graph2012.insert("newyork",
                new String[]{"Space Stone", "Nasi Padang"});
        graph2012.insert("sanctum sanctorum",
                new String[]{"Thai Tea", "Time Stone"});
        graph2012.insert("morag",
                new String[]{"Power Stone", "Es Semangka India"});
        graph2012.insert("kekalik",
                new String[]{"Suit IronMan", "Printer"});
        graph2012.insert("midgard",
                new String[]{"Boba", "Sempol"});

        graph2012.insertEdge("newyork", "sanctum sanctorum");
        graph2012.insertEdge("sanctum sanctorum", "morag");
        graph2012.insertEdge("sanctum sanctorum", "midgard");
        graph2012.insertEdge("midgard", "kekalik");
        graph2012.insertEdge("morag", "kekalik");
        System.out.println("\nTahun 2012");
        graph2012.bfs(graph2012.searchGraphContainer("newyork"));


        Graph graph2015 = new Graph("2015");
        graph2015.insert("hollywood",
                new String[]{"DVD Avenger", "Microphone"});
        graph2015.insert("knowhere",
                new String[]{"Mind Stone", "Batu Akik"});
        graph2015.insert("new york",
                new String[]{"KFC", "Iphone 13"});
        graph2015.insert("vormir",
                new String[]{"Mouse Wireless", "Keyboard"});
        graph2015.insert("asgard",
                new String[]{"Mjolnir", "Storm Breaker"});
        graph2015.insert("qatar",
                new String[]{"Yamaha YZR-M1", "Ducati GP15"});
        graph2015.insert("valencia",
                new String[]{"Kartu Uno", "Kartu Remi"});

        graph2015.insertEdge("hollywood", "knowhere");
        graph2015.insertEdge("vormir", "hollywood");
        graph2015.insertEdge("knowhere", "new york");
        graph2015.insertEdge("new york", "vormir");
        graph2015.insertEdge("new york", "asgard");
        graph2015.insertEdge("new york", "valencia");
        graph2015.insertEdge("asgard", "qatar");
        graph2015.insertEdge("valencia", "qatar");
        System.out.println("\nTahun 2015");
        graph2015.bfs(graph2015.searchGraphContainer("hollywood"));

        DLLGraph dllGraph = new DLLGraph();
        dllGraph.insert(graph1970);
        dllGraph.insert(graph2012);
        dllGraph.insert(graph2015);

        System.out.println("\n\n");
        dllGraph.searchWithBfs("Mjolnir");
    }
}
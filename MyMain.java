package interview;
class MyMain{
    public static void main(String[] args) {
        Graph graph=new Graph(5,true);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        
        graph.print();
        
    }
}
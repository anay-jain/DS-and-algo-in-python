import java.util.ArrayList;

public class graphrevise{
    public static class edge{
        int v2;
        int weight;
        edge(int v2 , int weight){
            this.v2 = v2;
            this.weight = weight;
        }
    }
    public static addedge(ArrayList<ArrayList<edge>> graph,int v1 , int v2 , int weight){
        graph.get(v1).add(new edge(v2,weight));
        graph.get(v2).add(new edge(v1, weight));
    }
    public static void display(ArrayList<ArrayList<edge>> graph){
        for(int i=0;i<7;i++){
            for(int j =0;j<graph.get(0).size();j++){
                System.out.print(i+" @ "+gr);
            }
        }
    }
    public static void main(String[] args){
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        for(int i=0;i<7;i++){
            graph.add(new ArrayList<>());
        }
        addedge(graph, 0, 1, 10);
        addedge(graph, 0, 3, 40);
        addedge(graph, 1, 2, 10);
        addedge(graph, 2, 3, 10);
        addedge(graph, 3, 4, 2);
        addedge(graph, 4, 5, 3);
        addedge(graph, 4, 6, 8);
        addedge(graph, 5, 6, 3);


    }
}
import java.util.*;

public class KruskalMST {

    private ArrayList<Edge> MST = new ArrayList<>();

    public KruskalMST(Graph G){

        ArrayList<Edge> edges = new ArrayList<Edge>(G.edges);
       edges.sort(new sortWeight());
       UnionFind UF = new UnionFind(G.vertices);
       int count = 0;
       while(!edges.isEmpty() && MST.size() < G.numEdges() -1){

           Edge e = edges.remove(count);
           String v = e.src;
           String w = e.dst;
           if(!UF.connected(v,w)){
               UF.union(v,w);
               MST.add(e);
           }
       }

    }

    public static class sortWeight implements Comparator<Edge> {
        public int compare (Edge v, Edge w){
            return v.cost - w.cost;
        }
    }
    public ArrayList<Edge> MST (){
        return MST;
    }

}

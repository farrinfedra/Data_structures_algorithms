import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    Map<String, String> parent;
    Map<String, Integer> rank;

    public UnionFind (ArrayList<String> vertices){
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (String s : vertices){
            parent.put(s,s);
            rank.put(s,0);
        }
    }
    public String find(String v){
        if (parent.get(v).equals(v)){
            return v;
        } else{
            return find(parent.get(v));
        }
    }
    public boolean connected(String v, String w){
        return find(v).equals(find(w));
    }
    public void union(String v, String w){

        parent.put(w, v);
    }

}

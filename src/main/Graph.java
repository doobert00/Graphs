package main;
import java.util.*;
public class Graph<V> {
    private HashMap<V, HashMap<V, Integer>> graph;

    public Graph() {
        this.graph = new HashMap<V, HashMap<V,Integer>>();
    }

    public void addVertex(V vertex){
        if(!this.graph.containsKey(vertex)){
            this.graph.put(vertex, new HashMap<V,Integer>());
        }
    }
    public void addEdge(V start, V end, Integer weight){
        if(!this.graph.containsKey(start)) {
            this.addVertex(start);
        }
        if(!this.graph.containsKey(end)){
            this.addVertex(end);
        }
        this.graph.get(start).put(end, weight);

    }
    public Iterable<V> getNeighbors(V vertex){
        if(!this.graph.containsKey(vertex)){
            throw new Error("Vertex does not exist");
        }
        return this.graph.get(vertex).keySet();
    }
    public Iterable<V> getVerticies(){
        return this.graph.keySet();
    }
    public Integer getDistance(V start, V end){
        if(!this.graph.containsKey(start) || !this.graph.containsKey(end)) {
            throw new Error("Invalid nodes not present");
        }
        if(!this.graph.get(start).containsKey(end)){
            throw new Error("No edge connected the nodes");
        }
        return this.graph.get(start).get(end);
    }
    public int numVerticies(){
        return this.graph.size();
    }
    public int numEdges(){
        int count = 0;
        for(V v: this.graph.keySet()){
            count += this.graph.get(v).keySet().size();
        }
        return count;
    }
}

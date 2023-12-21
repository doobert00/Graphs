package main.commands;

import main.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class FloydWarshall<V> implements Command<V>{
    //https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
    /**
     * Reconstructs the path between start and end using a hashmap computed in
     * the course of the Bellman-Ford algorithm
     * @param start
     * @param end
     * @return
     */
    public Iterable<V> execute(Graph<V> G, V start, V end){
        HashMap<V,HashMap<V,V>> prev = FloydWarshall(G, start, end);
        ArrayList<V> path = new ArrayList<V>();
        path.addFirst(end);
        while(!start.equals(end)){
            start = prev.get(start).get(end);
            path.addFirst(start);
        }
        System.out.println(path.toString());
        return path;
    }
    private HashMap<V,HashMap<V,V>> FloydWarshall(Graph<V> G, V start, V end){
        HashMap<V, HashMap<V,Integer>> dist = new HashMap<>();
        HashMap<V, HashMap<V,V>> prev = new HashMap<>();
        for(V v: G.getVerticies()){
            dist.put(v, new HashMap<V,Integer>());
            prev.put(v, new HashMap<V,V>());
            dist.get(v).put(v,0);
            prev.get(v).put(v,v);
            for(V u: G.getNeighbors(v)){
                dist.get(v).put(u,G.getWeight(v,u));
                prev.get(v).put(u,v);
            }
        }
        for(V v: G.getVerticies()){
            for(V u: G.getVerticies()){
                for(V w: G.getVerticies()){
                    int tmp = dist.get(u).get(v) + dist.get(v).get(w);
                    if(dist.get(u).get(w) > tmp){
                        dist.get(u).put(w,tmp);
                        prev.get(u).put(w,prev.get(v).get(w));
                    }
                }
            }
        }

        return prev;
    }
}

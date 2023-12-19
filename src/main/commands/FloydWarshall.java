package main.commands;

import main.Graph;

import java.util.HashMap;

public class FloydWarshall<V> implements Command<V>{
    //TODO: Write Floyd-Warshall Algorithm
    public Iterable<V> execute(Graph<V> G, V start, V end){
        HashMap<V, HashMap<V,Integer>> dist = new HashMap<>();
        //Initialize all entries to inf
        for(V v : G.getVerticies()){
            dist.put(v,new HashMap<V,Integer>());
            for(V u : G.getVerticies()){
                dist.get(v).put(u,Integer.MAX_VALUE);
            }
        }
        for(V v : G.getVerticies()){
            for(V u : G.getNeighbors(v)){
                dist.get(v).put(u,G.getWeight(v,u));
            }
        }
        for(V v : G.getVerticies()){
            dist.get(v).put(v,0);
        }
        for(int i = 0; i < G.numVerticies(); i++){
            for(int j = 0; j < G.numVerticies(); j++){
                for(int k = 1; k < G.numVerticies(); k++){
//                    if dist[j][k] > dist[j][i] + dist[i][k]
//                    dist[j][k] ← dist[j][i] + dist[i][k]
                    break;
                }
            }
        }
        return null;
    }
}

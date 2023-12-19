package main.commands;

import main.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BellmanFord<V> implements Command<V>{
    /**
     * An implementation of the Bellman-Ford shortest path algorithm.
     * @param G: A weighted directed graph.
     * @param start: The start vertex
     * @param end: The end vertex
     * @return: An iterable shortest path from start to end.
     */
    @Override
    public Iterable<V> execute(Graph<V> G, V start, V end) {
        HashMap<V, Integer> distance = new HashMap<>();
        HashMap<V, V> predecessor = new HashMap<>();
        HashMap<V, Boolean> visited = new HashMap<>();
        for (V v : G.getVerticies()) {
            distance.put(v, Integer.MAX_VALUE);
            predecessor.put(v, null);
            visited.put(v, false);
        }
        //Relax edges repeatedly.
        distance.put(start, 0);
        for (int i = 1; i < G.numVerticies(); i++) {
            for (V v : G.getVerticies()) {
                for (V u : G.getNeighbors(v)) {
                    if (distance.get(v) + G.getWeight(v, u) < distance.get(u)) {
                        distance.put(u, distance.get(v) + G.getWeight(v, u));
                        predecessor.put(u, v);
                    }
                }
            }
        }
        //Check for negative weight cycles.
        ArrayList<V> ncycle = new ArrayList<V>();
        for (V v : G.getVerticies()) {
            for (V u : G.getNeighbors(v)) {
                if (distance.get(v) + G.getWeight(v, u) < distance.get(u)) {
                    predecessor.put(u, v);
                    visited.put(u, true);
                    while (!visited.get(v)) {
                        visited.put(v, true);
                        v = predecessor.get(v);
                    }
                    ncycle.add(v);
                    u = predecessor.get(v);
                    while (!u.equals(v)) {
                        ncycle.add(u);
                        u = predecessor.get(u);
                    }
                    throw new Error("Graph contains a negative-weight cycle");
                }
            }
        }
        //Backtrack to return an iterable path from start to finish.
        ArrayList<V> path = new ArrayList<>();
        V w = end;
        path.add(w);
        while (!w.equals(start)) {
            path.add(predecessor.get(w));
            w = predecessor.get(w);
        }
        Collections.reverse(path);
        return path;
    }
}

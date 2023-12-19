package main.commands;
import main.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Dijkstra<V> implements Command<V>{

    /**
     * An implementation of Dijkstra's shortest path algorithm.
     * @param G: A weighted & directed graph
     * @param start: The start vertex
     * @param end: The end vertex
     * @return: An iterable of vertices of the shortest path between start and end.
     */
    @Override
    public Iterable<V> execute(Graph<V> G, V start, V end) {
        HashMap<V,Integer> distance = new HashMap<>();
        HashMap<V,V> prev = new HashMap<>();
        ArrayList<V> vertices = new ArrayList<>();

        for(V v: G.getVerticies()){
            distance.put(v,Integer.MAX_VALUE);
            vertices.add(v);
        }
        distance.put(start,0);

        while(!vertices.isEmpty()) {
            //Just take one so tha the errors go away.
            V u = vertices.getFirst();
            int min = distance.get(u);
            for (V v : vertices) {
                if (distance.get(v) < min) {
                    u = v;
                    min = distance.get(v);
                }
            }
            vertices.remove(u);
            if(u.equals(end)){
                V w = u;
                ArrayList<V> path = new ArrayList<>();
                path.add(u);
                while(!w.equals(start)){
                    path.add(prev.get(w));
                    w = prev.get(w);
                }
                Collections.reverse(path);
                return path;
            }
            for (V v : G.getNeighbors(u)) {
                int alt = distance.get(u) + G.getWeight(u, v);
                if (alt < distance.get(v)) {
                    distance.put(v, alt);
                    prev.put(v, u);
                }
            }
        }
        return new ArrayList<V>();
    }
}

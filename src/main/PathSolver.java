package main;
import java.util.*;
public class PathSolver<V> {

    public static PathSolver instance;
    public PathSolver(){}
    public static PathSolver getInstance(){
        if(instance == null){
            instance = new PathSolver();
        }
        return instance;
    }

    /**
     * An implementation of Dijkstra's shortest path algorithm.
     * @param G: A weighted & directed graph
     * @param start: The start vertex
     * @param end: The end vertex
     * @return: An iterable of vertices of the shortest path between start and end.
     */
    public Iterable<V> Dijkstra(Graph<V> G, V start, V end){
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

    /**
     * An implementation of the Bellman-Ford shortest path algorithm.
     * @param G: A weighted directed graph.
     * @param start: The start vertex
     * @param end: The end vertex
     * @return: An iterable shortest path from start to end.
     */
    public Iterable<V> BellmanFord(Graph<V> G, V start, V end){
        HashMap<V,Integer> distance = new HashMap<>();
        HashMap<V,V> predecessor = new HashMap<>();
        HashMap<V,Boolean> visited = new HashMap<>();
        for(V v: G.getVerticies()){
            distance.put(v,Integer.MAX_VALUE);
            predecessor.put(v,null);
            visited.put(v,false);
        }
        //Relax edges repeatedly.
        distance.put(start,0);
        for(int i = 1; i < G.numVerticies(); i++){
            for(V v: G.getVerticies()){
                for(V u: G.getNeighbors(v)){
                    if(distance.get(v) + G.getWeight(v,u) < distance.get(u)){
                        distance.put(u,distance.get(v)+G.getWeight(v,u));
                        predecessor.put(u,v);
                    }
                }
            }
        }
        //Check for negative weight cycles.
        ArrayList<V> ncycle = new ArrayList<V>();
        for(V v: G.getVerticies()) {
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
        while(!w.equals(start)){
            path.add(predecessor.get(w));
            w = predecessor.get(w);
        }
        Collections.reverse(path);
        return path;
    }
    //TODO: Write A* Search Algorithm
    public void AStar(){

    }
    //TODO: Write Floyd-Warshall Algorithm
    public void FloydWarshall(Graph<V> G){
        HashMap<V,HashMap<V,Integer>> dist = new HashMap<>();
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
    }
    //TODO: Write Johnson's Algorithm
    public void Johnson(){

    }
    //TODO: Write Viterbi(s?) Algorithm
    public void Viterbi(){

    }
}

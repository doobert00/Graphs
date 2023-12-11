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
                int alt = distance.get(u) + G.getDistance(u, v);
                if (alt < distance.get(v)) {
                    distance.put(v, alt);
                    prev.put(v, u);
                }
            }
        }
        return new ArrayList<V>();
    }
    //TODO: Write Bellman-Ford Algorithm.
    public void BellmanFord(Graph<V> G, V start, V end){
        HashMap<V,Integer> distance = new HashMap<>();
        HashMap<V,V> predecessor = new HashMap<>();
        for(V v: G.getVerticies()){
            distance.put(v,Integer.MAX_VALUE);
            predecessor.put(v,null);
        }
        distance.put(start,0);
    }
    //TODO: Write A* Search Algorithm
    public void AStar(){

    }
    //TODO: Write Floyd-Warshall Algorithm
    public void FloydWarshall(){

    }
    //TODO: Write Johnson's Algorithm
    public void Johnson(){

    }
    //TODO: Write Viterbi(s?) Algorithm
    public void Viterbi(){

    }
}

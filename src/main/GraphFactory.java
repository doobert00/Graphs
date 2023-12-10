package main;

import java.util.ArrayList;

public class GraphFactory {
    public static GraphFactory instance;
    private GraphFactory(){
    }
    public static GraphFactory getInstance(){
        if(instance == null){
            instance = new GraphFactory();
        }
        return instance;
    }
    public Graph<Integer> CreateIntGraph(){
        Graph<Integer> g = new Graph<>();
        for(int i = 1; i < 10; i++){
            g.addVertex(i);
        }
        g.addEdge(1,2,1);
        g.addEdge(2,3,2);
        g.addEdge(1,3,4);
        g.addEdge(1,4,2);
        return g;
    }
}

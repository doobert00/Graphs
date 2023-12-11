package main;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        Graph G = GraphFactory.getInstance().CreateIntGraph();
        Iterable i = PathSolver.getInstance().BellmanFord(G,1,4);
        for(Iterator itr = i.iterator(); itr.hasNext();){
            System.out.println(itr.next());
        }
    }
}

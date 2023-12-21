package main;

import main.commands.Command;
import main.commands.FloydWarshall;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        Graph<Integer> G = GraphFactory.getInstance().CreateIntGraph();
        Command<Integer> cmd = new FloydWarshall<Integer>();
        cmd.execute(G,1,4);
//        Iterable i = PathSolver.getInstance().BellmanFord(G,1,4);
//        for(Iterator itr = i.iterator(); itr.hasNext();){
//            System.out.println(itr.next());
//        }
    }
}

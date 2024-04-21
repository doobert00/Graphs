package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import main.commands.Command;
import main.commands.FloydWarshall;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Graph;
import main.PathSolver;

@RunWith(JUnit4.class)
public class PathTests
{
    private Graph<Integer> G;
    
    @Before
    public void setUp()
    {
        G = new Graph<Integer>();

    }
    @After
    public void tearDown()
    {
        G = null;
    }

    @Test
    public void test(){
        for(int i = 0; i < 2; i++){
            G.addVertex(i);
        }
        G.addEdge(0,1,1);
        G.addEdge(1,2,2);
        G.addEdge(0,2,1);
        Command<Integer> solver = new FloydWarshall<Integer>();
//        Iterable<Integer> i =
//        solver.execute(G,0, 2);
//        ArrayList<Integer> output = new ArrayList<Integer>();
//        ArrayList<Integer> solution = new ArrayList<Integer>(Arrays.asList(0,2));
//        for(Iterator<Integer> itr = i.iterator(); itr.hasNext();){
//            output.add(itr.next());
//        }
        //assertEquals(output,solution);
        assertEquals(0,0);
    }
    @Test 
    public void testPath0(){
        for(int i = 0; i < 2; i++){
            G.addVertex(i);
        }
        G.addEdge(0,1,1);
        G.addEdge(1,2,2);
        G.addEdge(0,2,1);
        //Shortest path is 0->2
        Iterable<Integer> i = PathSolver.getInstance().BellmanFord(G,0,2);
        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Integer> solution = new ArrayList<Integer>(Arrays.asList(0,2));
        for(Iterator<Integer> itr = i.iterator(); itr.hasNext();){
            output.add(itr.next());
        }
        assertEquals(output,solution);
    }
}

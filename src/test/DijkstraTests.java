package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import main.Graph;
import main.commands.Dijkstra;
import main.commands.Command;

@RunWith(JUnit4.class)
public class DijkstraTests
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
    public void weightBeatsLength(){
        for(int i = 0; i < 2; i++){
            G.addVertex(i);
        }
        G.addEdge(0,1,1);
        G.addEdge(1,2,2);
        G.addEdge(0,2,4);
        Command<Integer> solver = new Dijkstra<Integer>();

        //Shortest path is 0->1->2
        ArrayList<Integer> solution = new ArrayList<Integer>(Arrays.asList(0,1,2));

        //Assemble ArrayList of solution
        Iterable<Integer> i = solver.execute(G,0,2);
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(Iterator<Integer> itr = i.iterator(); itr.hasNext();){
            output.add(itr.next());
        }

        assertEquals(output,solution);
    }
}

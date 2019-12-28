package homework2;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * BipartiteGraphTest contains JUnit block-box unit tests for BipartiteGraph.
 */
public class BipartiteGraphTest {

    @Test
    public void testExample() {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph1");

        //add a pair of nodes
        driver.addBlackNode("graph1", "n1");
        driver.addWhiteNode("graph1", "n2");

        //add an edge
        driver.addEdge("graph1", "n1", "n2", "edge");

        //check neighbors
        assertEquals("wrong black nodes", "n1", driver.listBlackNodes("graph1"));
        assertEquals("wrong white nodes", "n2", driver.listWhiteNodes("graph1"));
        assertEquals("wrong children", "n2", driver.listChildren("graph1", "n1"));
        assertEquals("wrong children", "", driver.listChildren("graph1", "n2"));
        assertEquals("wrong parents", "", driver.listParents("graph1", "n1"));
        assertEquals("wrong parents", "n1", driver.listParents("graph1", "n2"));
    }

    @Test
    public void blackBoxTests() {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();

        //create a graph
        driver.createGraph("graph1");
        driver.createGraph("graph1");
        driver.createGraph("graph2");

        //add a pair of nodes
        driver.addWhiteNode("graph1", "n");
        driver.addBlackNode("graph1", "n1");
        driver.addWhiteNode("graph1", "n2");
        driver.addBlackNode("graph1", "n3");
        driver.addWhiteNode("graph1", "n4");
        driver.addBlackNode("graph1", "n5");
        driver.addWhiteNode("graph1", "n6");
        driver.addBlackNode("graph1", "n7");
        driver.addWhiteNode("graph1", "n8");
        driver.addBlackNode("graph1", "n9");


        //add an edge
        driver.addEdge("graph1", "n1", "n2", "edge");
        driver.addEdge("graph1", "n1", "n", "edge1");
        driver.addEdge("graph1", "n1", "n4", "edge2");
        driver.addEdge("graph1", "n1", "n6", "edge3");
        driver.addEdge("graph1", "n1", "n8", "edge4");
        driver.addEdge("graph1", "n", "n1", "edge5");
        driver.addEdge("graph1", "n", "n3", "edge6");
        driver.addEdge("graph1", "n", "n5", "edge7");

        assertEquals("wrong black nodes", "n1 n3 n5 n7 n9", driver.listBlackNodes("graph1"));
        assertEquals("wrong black nodes", "", driver.listBlackNodes("graph21"));
        assertEquals("wrong white nodes", "n n2 n4 n6 n8", driver.listWhiteNodes("graph1"));
        assertEquals("wrong white nodes", "", driver.listWhiteNodes("graph11"));
        assertEquals("wrong children", "n n2 n4 n6 n8", driver.listChildren("graph1", "n1"));
        assertEquals("wrong children", "", driver.listChildren("graph1", "n8"));
        assertEquals("wrong children", "n1 n3 n5", driver.listChildren("graph1", "n"));
        assertEquals("wrong parents", "n", driver.listParents("graph1", "n1"));
        assertEquals("wrong parents", "n1", driver.listParents("graph1", "n"));
        assertEquals("wrong parents", "", driver.listParents("graph1", "n9"));
        assertEquals("wrong parent by edge", "n1", driver.getParentByEdgeLabel("graph1", "n", "edge1"));
        assertEquals("wrong child by edge", "n1", driver.getChildByEdgeLabel("graph1", "n", "edge5"));
        assertEquals("wrong child by edge", "", driver.getChildByEdgeLabel("graph1", "q", "edge5"));
        assertEquals("wrong child by edge", "", driver.getChildByEdgeLabel("graph1", "n", "edge5sdf"));
    }


}

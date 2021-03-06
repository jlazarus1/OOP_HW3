package homework2;

import java.util.*;

/**
 * This class implements a testing driver for BipartiteGraph. The driver
 * manages BipartiteGraphs whose nodes and edges are Strings.
 */
public class BipartiteGraphTestDriver {

    private Map<String, BipartiteGraph<String>> graphs;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public BipartiteGraphTestDriver () {


        graphs = new HashMap<String, BipartiteGraph<String>>();


    }

    
    /**
     * @requires graphName != null
     * @modifies this
     * @effects Creates a new graph named graphName. The graph is initially
     * 			empty.
     */
    public void createGraph(String graphName) {
        if(graphs.containsKey(graphName)) return;
        BipartiteGraph graph = new BipartiteGraph();
        graphs.put(graphName,graph);
    	
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a black node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addBlackNode(String graphName, String nodeName) {

        if(graphs.containsKey(graphName)) {
            graphs.get(graphName).addBlackNode(nodeName);
        }
    	
    	
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a white node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addWhiteNode(String graphName, String nodeName) {
        if(graphs.containsKey(graphName)) {
            graphs.get(graphName).addWhiteNode(nodeName);
        }

    }

    
    /**
     * @requires createGraph(graphName)
     *           && ((addBlackNode(parentName) && addWhiteNode(childName))
     *              || (addWhiteNode(parentName) && addBlackNode(childName)))
     *           && edgeLabel != null
     *           && node named parentName has no other outgoing edge labeled
     * 				edgeLabel
     *           && node named childName has no other incoming edge labeled
     * 				edgeLabel
     * @modifies graph named graphName
     * @effects Adds an edge from the node parentName to the node childName
     * 			in the graph graphName. The new edge's label is the String
     * 			edgeLabel.
     */
    public void addEdge(String graphName,
    					String parentName, String childName, 
                        String edgeLabel) {
        if(graphs.containsKey(graphName)) {
            graphs.get(graphName).addEdge(parentName,childName,edgeLabel);
        }

    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the black nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listBlackNodes(String graphName) {
    	//TODO: Implement this method

        String list = new String();
        if(!graphs.containsKey(graphName)) return list;
        BipartiteGraph<String> bg = graphs.get(graphName);

        ArrayList<String> labels = bg.listBlackNodes();
        Collections.sort(labels);
        boolean firstIter = true;
        for (String i : labels) {
            if (!firstIter) list += " ";
            firstIter = false;
            list += i;
        }

    	return list;
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the white nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listWhiteNodes(String graphName) {
        String list = new String();
        if(!graphs.containsKey(graphName)) return list;
        BipartiteGraph<String> bg = graphs.get(graphName);

        ArrayList<String> labels = bg.listWhiteNodes();
        Collections.sort(labels);
        boolean firstIter = true;
        for (String i : labels) {
            if (!firstIter) list += " ";
            firstIter = false;
            list += i;
        }
        return list;
    }

    
    /**
     * @requires createGraph(graphName) && createNode(parentName)
     * @return a space-separated list of the names of the children of
     * 		   parentName in the graph graphName, in alphabetical order.
     */
    public String listChildren(String graphName, String parentName) {
    	//TODO: Implement this method
        String list = new String();
        if(!graphs.containsKey(graphName)) return list;
        BipartiteGraph<String> bg = graphs.get(graphName);
        ArrayList<String> labels = bg.listChildren(parentName);
        Collections.sort(labels);
        boolean firstIter = true;
            for (String i : labels) {
                if (!firstIter) list += " ";
                firstIter = false;
                list += i;
        }
    	return list;
    }

    
    /**
     * @requires createGraph(graphName) && createNode(childName)
     * @return a space-separated list of the names of the parents of
     * 		   childName in the graph graphName, in alphabetical order.
     */
    public String listParents(String graphName, String childName) {
    	//TODO: Implement this method
        String list = new String();
        if(!graphs.containsKey(graphName)) return list;
        BipartiteGraph<String> bg = graphs.get(graphName);
        ArrayList<String> labels = bg.listParent(childName);
        Collections.sort(labels);
        boolean firstIter = true;
        for (String i : labels) {
            if (!firstIter) list += " ";
            firstIter = false;
            list += i;
        }

        return list;
    }

    
    /**
     * @requires addEdge(graphName, parentName, str, edgeLabel) for some
     * 			 string str
     * @return the name of the child of parentName that is connected by the
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getChildByEdgeLabel(String graphName, String parentName,
    								   String edgeLabel) {
    	//TODO: Implement this method
        if(!graphs.containsKey(graphName)) return new String();
        BipartiteGraph<String> bg = graphs.get(graphName);
    	String res = bg.getChildByEdgeLabel(parentName , edgeLabel);
        if(res == null) return new String();
        return res;
    }

    
    /**
     * @requires addEdge(graphName, str, childName, edgeLabel) for some
     * 			 string str
     * @return the name of the parent of childName that is connected by the 
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getParentByEdgeLabel(String graphName, String childName,
    									String edgeLabel) {
    	//TODO: Implement this method
        if(!graphs.containsKey(graphName)) return new String();
    	BipartiteGraph<String> bg = graphs.get(graphName);
    	String res = bg.getParentdByEdgeLabel(childName , edgeLabel);
    	if(res == null) return new String();
    	return res;
    }
}

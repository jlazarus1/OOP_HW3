package homework2;

import java.util.*;

/**
 * This class implements a testing driver for Simulator. The driver manages
 * Simulators for recycling channels
 */
public class SimulatorTestDriver {

    private Map<String, Simulator<String, Transaction>> simulators;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public SimulatorTestDriver() {
        simulators = new HashMap<String, Simulator<String, Transaction>>();
    }

    /**
     * @requires simName != null
     * @modifies this
     * @effects Creates a new simulator named simName. The simulator's graph is
     * initially empty.
     */
    public void createSimulator(String simName) {
        // TODO: Implement this method
        simulators.put(simName, new Simulator<String, Transaction>());
    }

    /**
     * @requires createSimulator(simName)
     * && channelName != null && channelName has
     * not been used in a previous addChannel()  or
     * addParticipant() call on this object
     * limit > 0
     * @modifies simulator named simName
     * @effects Creates a new Channel named by the String channelName, with a limit, and add it to
     * the simulator named simName.
     */
    public void addChannel(String simName, String channelName, int limit) {
        if (!simulators.containsKey(simName)) return;
        Simulator<String, Transaction> sim = simulators.get(simName);
        Channel newChannel = new Channel(channelName, limit);
        sim.addPipe(channelName, newChannel);
    }

    /**
     * @requires createSimulator(simName) && participantName != null
     * && participantName has not been used in a previous addParticipant(), addChannel()
     * call on this object
     * amount > 0
     * product must be a single word, without special characters/number and also in lowercase
     * @modifies simulator named simName
     * @effects Creates a new Participant named by the String participantName and add
     * it to the simulator named simName.
     */
    public void addParticipant(String simName, String participantName, String product, int amount) {
        if (!simulators.containsKey(simName)) return;
        Simulator<String, Transaction> sim = simulators.get(simName);
        Participant newParticipant = new Participant(participantName, product, amount);
        sim.addFilter(participantName, newParticipant);

    }

    /**
     * @requires createSimulator(simName) && ((addPipe(parentName) &&
     * addFilter(childName)) || (addFilter(parentName) &&
     * addPipe(childName))) && edgeLabel != null && node named
     * parentName has no other outgoing edge labeled edgeLabel
     * && node named childName has no other incoming edge labeled edgeLabel
     * @modifies simulator named simName
     * @effects Adds an edge from the node named parentName to the node named
     * childName in the simulator named simName. The new edge's label
     * is the String edgeLabel.
     */
    public void addEdge(String simName, String parentName, String childName, String edgeLabel) {
        Simulator<String, Transaction> sim = simulators.get(simName);
        sim.addEdge(parentName, childName, edgeLabel);
    }

    /**
     * @requires createSimulator(simName) && addChannel(channelName)
     * A transaction Transaction != null
     * @modifies channel named channelName
     * @effects pushes the Transaction into the channel named channelName in the
     * simulator named simName.
     */
    //TODO
    public void sendTransaction(String simName, String channelName, Transaction tx) {
        Simulator<String, Transaction> sim = simulators.get(simName);
        Channel ch = (Channel) sim.getObjByLabel(channelName, true);
        ch.receiveTransaction(tx);
    }


    /**
     * @return a space-separated list of the Transaction values currently in the
     * channel named channelName in the simulator named simName.
     * @requires addChannel(channelName)
     */
    public String listContents(String simName, String channelName) {

        if (!simulators.containsKey(simName)) return "";
        Simulator<String, Transaction> sim = simulators.get(simName);
        Channel ch = (Channel) sim.getObjByLabel(channelName, true);
        if (ch == null) return "";
        String contents = ch.getContents();
        return contents;

    }


    /**
     * @return The sum of all Transaction amount of stored products that one has in his storage buffer.
     * @requires addParticipant(participantName)
     */
    public double getParticipantStorageAmount(String simName, String participantName) {
        if (!simulators.containsKey(simName)) return 0;
        Simulator<String, Transaction> sim = simulators.get(simName);
        Participant filter = (Participant) sim.getObjByLabel(participantName, false);
        if (filter == null) return 0;
        return filter.getStorageAmount();
    }


    /**
     * @return The sum of all Transaction amount of waiting to be recycled products that one has.
     * @requires addParticipant(participantName)
     */

    //TODO not sure about this cast, make sure it is correct
    public double getParticipantToRecycleAmount(String simName, String participantName) {
        if (!simulators.containsKey(simName)) return 0;
        Simulator<String, Transaction> sim = simulators.get(simName);
        Participant filter = (Participant) sim.getObjByLabel(participantName, false);
        if (filter == null) return 0;
        return filter.getRecycleAmount();
    }


    /**
     * @requires createSimulator(simName)
     * @modifies simulator named simName
     * @effects runs simulator named simName for a single time slice.
     */
    public void simulate(String simName) {
        Simulator<String, Transaction> sim = simulators.get(simName);
        sim.simulate();
    }

    /**
     * Prints the all edges.
     *
     * @requires simName the sim name
     * @effects Prints the all edges.
     */
    public void printAllEdges(String simName) {

        Simulator<String, Transaction> sim = simulators.get(simName);
        sim.printEdges();
    }

}

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
	 *          initially empty.
	 */
	public void createSimulator(String simName) {
		simulators.put(simName , new Simulator<String, Transaction>());
	}

	/**
	 * @requires createSimulator(simName)
     *           && channelName != null && channelName has
	 *           not been used in a previous addChannel()  or
	 *           addParticipant() call on this object
	 *           limit > 0
	 * @modifies simulator named simName
	 * @effects Creates a new Channel named by the String channelName, with a limit, and add it to
	 *          the simulator named simName.
	 */
	public void addChannel(String simName, String channelName, int limit) {
		if(!simulators.containsKey(simName)) return;
	    Simulator<String,Transaction> sim = simulators.get(simName);
	    Channel newChannel = new Channel(channelName , limit);
	    sim.addPipe(channelName , newChannel);
	}

	/**
	 * @requires createSimulator(simName) && participantName != null
	 *           && participantName has not been used in a previous addParticipant(), addChannel()
	 *           call on this object
	 *			 amount > 0
	 *			 product must be a single word, without special characters/number and also in lowercase
	 * @modifies simulator named simName
	 * @effects Creates a new Participant named by the String participantName and add
	 *          it to the simulator named simName.
	 */
	public void addParticipant(String simName, String participantName, String product, int amount) {
        if(!simulators.containsKey(simName)) return;
		Simulator<String,Transaction> sim = simulators.get(simName);
		Participant newParticipant = new Participant(participantName , product , amount);
		sim.addFilter(participantName , newParticipant);

	}

	/**
	 * @requires createSimulator(simName) && ((addPipe(parentName) &&
	 *           addFilter(childName)) || (addFilter(parentName) &&
	 *           addPipe(childName))) && edgeLabel != null && node named
	 *           parentName has no other outgoing edge labeled edgeLabel
	 *           && node named childName has no other incoming edge labeled edgeLabel
	 * @modifies simulator named simName
	 * @effects Adds an edge from the node named parentName to the node named
	 *          childName in the simulator named simName. The new edge's label
	 *          is the String edgeLabel.
	 */
	public void addEdge(String simName, String parentName, String childName, String edgeLabel) {
        Simulator<String,Transaction> sim = simulators.get(simName);
        sim.addEdge(parentName,childName,edgeLabel);
	}

	/**
	 * @requires createSimulator(simName) && addChannel(channelName)
	 *           A transaction Transaction != null
	 * @modifies channel named channelName
	 * @effects pushes the Transaction into the channel named channelName in the
	 *          simulator named simName.
	 */
	//TODO
	public void sendTransaction(String simName, String channelName, Transaction tx) {
        Simulator<String,Transaction> sim = simulators.get(simName);
		sim.sendTransaction(channelName , tx);
    }


	/**
	 * @requires addChannel(channelName)
	 * @return a space-separated list of the Transaction values currently in the
	 *         channel named channelName in the simulator named simName.
	 */
	public String listContents(String simName, String channelName) {

		String list = new String();
		Simulator<String,Transaction> sim = simulators.get(simName);
		ArrayList<Transaction> transactions__ = sim.findNode(channelName).getItems();
		boolean firstIter = true;
		for (Transaction i : transactions__) {
			if (!firstIter) list += " ";
			firstIter = false;
			list += i;
		}

		return list;

	}


	/**
	 * @requires addParticipant(participantName)
	 * @return The sum of all Transaction amount of stored products that one has in his storage buffer.
	 */
	public double getParticipantStorageAmount(String simName, String participantName) {
		double amount = 0;
        Simulator<String,Transaction> sim = simulators.get(simName);
        ArrayList<Transaction> list = sim.findNode(participantName).getItems();
        for (Transaction i : list)
		{
			amount += i.getAmount();
		}

        return amount;
	}


	/**
	 * @requires addParticipant(participantName)
	 * @return The sum of all Transaction amount of waiting to be recycled products that one has.
	 */

	//TODO not sure about this cast, make sure it is correct
	public double getParticipantToRecycleAmount(String simName, String participantName) {
		double sum=0;
		Simulator<String,Transaction> sim = simulators.get(simName);
		Participant<String,Transaction> participant = (Participant<String, Transaction>) sim.findNode(participantName);
		for (Transaction i: participant.getRecycleList__())
		{
			sum+=i.getAmount();

		}
		return sum;
	}



	/**
	 * @requires createSimulator(simName)
	 * @modifies simulator named simName
	 * @effects runs simulator named simName for a single time slice.
	 */
	public void simulate(String simName) {
        Simulator<String,Transaction> sim = simulators.get(simName);
        sim.simulate();
	}

	/**
	 * Prints the all edges.
	 *
	 * @requires simName the sim name
	 * @effects Prints the all edges.
	 */
	public void printAllEdges(String simName) {

		Simulator<String,Transaction> sim = simulators.get(simName);
		sim.printEdges();
	}

}

package homework2;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {

    @Test
    public void Test(){
        SimulatorTestDriver driver = new SimulatorTestDriver();
        Transaction tx = new Transaction("milk",9);
        driver.createSimulator("sim1");
        driver.addChannel("sim1","ch1",3);
        driver.addParticipant("sim1","par1","eggs",2);
        driver.addEdge("sim1","par1","ch1","edge1");
        driver.sendTransaction("sim1","ch1",tx);




    }
}
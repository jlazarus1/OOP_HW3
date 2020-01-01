package homework2;
import static org.junit.Assert.*;

import org.junit.Test;


public class SimulatorTest {

    @Test
    public void Test(){
        SimulatorTestDriver driver = new SimulatorTestDriver();
        Transaction tx = new Transaction("milk",9);
        driver.createSimulator("sim1");
        driver.addChannel("sim1","ch1",3);
        driver.addParticipant("sim1","par1","eggs",2);
        driver.addParticipant("sim1","par2","wool",3);
        driver.addEdge("sim1","par1","ch1","edge1");
        driver.addEdge("sim1","ch1","par2","edge1");
        driver.sendTransaction("sim1","ch1",tx);
        driver.simulate("sim1");
        driver.simulate("sim1");

        assertEquals("wrong recycle amount", 0.0, driver.getParticipantToRecycleAmount("sim1" , "par1") ,0);
        assertEquals("wrong recycle amount", 0.0, driver.getParticipantToRecycleAmount("sim1" , "par2") , 0);
assertEquals("wrong black nodes", 0, driver.getParticipantStorageAmount("sim1" , "par1") , 0);
        assertEquals("wrong black nodes", 0, driver.getParticipantStorageAmount("sim1" , "par2") , 0);





    }
}
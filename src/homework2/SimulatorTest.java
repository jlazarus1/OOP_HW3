package homework2;

import static org.junit.Assert.*;

import org.junit.Test;


public class SimulatorTest {

    @Test
    public void Test() {
        SimulatorTestDriver driver = new SimulatorTestDriver();

        Transaction tx1 = new Transaction("milk", 9);
        Transaction tx2 = new Transaction("sheep",5);
        Transaction tx3 = new Transaction("muffins", 1);
        Transaction tx4 = new Transaction("heifer", 2);

        driver.createSimulator("sim1");

        //add channels
        driver.addChannel("sim1", "ch1", 3);
        driver.addChannel("sim1","ch2",5);
        driver.addChannel("sim1","ch3",99);
        driver.addChannel("sim1","ch4",40);
        driver.addChannel("sim1","ch5",2);

        //add participants
        driver.addParticipant("sim1", "par1", "eggs", 2);
        driver.addParticipant("sim1", "par2", "wool", 3);
        driver.addParticipant("sim1","par3","milk",6);
        driver.addParticipant("sim1","par4","heifer",6);
        driver.addParticipant("sim1","par5","milk",6);

        //connect them
        driver.addEdge("sim1", "par1", "ch1", "edge1");
        driver.addEdge("sim1", "ch1", "par2", "edge2");
        driver.addEdge("sim1", "par1", "ch2", "edge3");
        driver.addEdge("sim1", "ch2", "par3", "edge4");
        driver.addEdge("sim1", "par3", "ch3", "edge5");
        driver.addEdge("sim1", "ch3", "par2", "edge6");
        driver.addEdge("sim1", "ch2", "par4", "edge7");
        driver.addEdge("sim1", "ch5", "par5", "edge8");

        //sending transactions
        driver.sendTransaction("sim1", "ch1", tx1);
        driver.sendTransaction("sim1", "ch2", tx2);
        driver.sendTransaction("sim1", "ch2", tx3);
        driver.sendTransaction("sim1", "ch3", tx4);

        //assert equals for some participants
        assertEquals("wrong recycle amount", 0.0, driver.getParticipantToRecycleAmount("sim1", "par1"), 0);
        assertEquals("wrong recycle amount", 0.0, driver.getParticipantToRecycleAmount("sim1", "par2"), 0);

        //print out lists before simulation
        System.out.println("**************\n before first simulation \n**************");
        System.out.println(driver.listContents("sim1","ch1"));
        System.out.println(driver.listContents("sim1","ch2"));
        System.out.println(driver.listContents("sim1","ch3"));
        System.out.println(driver.listContents("sim1","ch4"));

        //run the simulation again

        driver.simulate("sim1");

        //print out lists after simulation
        System.out.println("**************\n after first simulation \n**************");
        System.out.println(driver.listContents("sim1","ch1"));
        System.out.println(driver.listContents("sim1","ch2"));
        System.out.println(driver.listContents("sim1","ch3"));
        System.out.println(driver.listContents("sim1","ch4"));

        Transaction tx5 = new Transaction("door", 3);
        Transaction tx6 = new Transaction("table",2);
        Transaction tx7 = new Transaction("bottle", 2);
        Transaction tx8 = new Transaction("pen", 1);

        System.out.println("**************\n before second simulation \n**************");
        System.out.println(driver.listContents("sim1","ch1"));
        System.out.println(driver.listContents("sim1","ch2"));
        System.out.println(driver.listContents("sim1","ch3"));
        System.out.println(driver.listContents("sim1","ch4"));


        driver.sendTransaction("sim1", "ch3", tx5);
        driver.sendTransaction("sim1", "ch3", tx6);
        driver.sendTransaction("sim1", "ch2", tx7);
        driver.sendTransaction("sim1", "ch4", tx8);


        driver.simulate("sim1");

        System.out.println("**************\n after second simulation \n**************");
        System.out.println(driver.listContents("sim1","ch1"));
        System.out.println(driver.listContents("sim1","ch2"));
        System.out.println(driver.listContents("sim1","ch3"));
        System.out.println(driver.listContents("sim1","ch4"));


        assertEquals("wrong recycle amount", 0.0, driver.getParticipantToRecycleAmount("sim1", "par1"), 0);
        assertEquals("wrong recycle amount", 10.0, driver.getParticipantToRecycleAmount("sim1", "par2"), 0);
        assertEquals("wrong black nodes", 0, driver.getParticipantStorageAmount("sim1", "par1"), 0);
        assertEquals("wrong black nodes", 0, driver.getParticipantStorageAmount("sim1", "par2"), 0);


    }
}
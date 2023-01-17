import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BusTest {
    private Bus bus;
    private BusStop busStop;

    @Before
    public void setUp() {
        bus = new Bus("Mars", 3);
        busStop = new BusStop("Prices St West");
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, bus.numberOfPassengers());
    }

    @Test
    public void hasDestination() {
        assertEquals("Mars", bus.getDestination());
    }

    @Test
    public void canAddOnePassenger() {
        assertTrue(bus.addPassenger(new Person()));
        assertEquals(1, bus.numberOfPassengers());
    }

    @Test
    public void canOnlyAddThreePassengers() {
        /* capacity was set to 3 */
        for (int i = 0; i < 3; i++)
            assertTrue(bus.addPassenger(new Person()));
        /* 4th passenger will fail */
        assertFalse(bus.addPassenger(new Person()));
        assertEquals(3, bus.numberOfPassengers());
    }

    /* removing passengers is now implemented */
//    @Test(expected = AssertionError.class)
    @Test
    public void canRemovePassenger() {
        bus.addPassenger(new Person());
        Object passenger = bus.removePassenger();
        assertNotNull(passenger);
        assertEquals(0, bus.numberOfPassengers());
    }

    /*
        pick up from bus stop. We need to test:
        * bus has space, stop has passengers
        * bus doesn't have space, stop has passengers
        * bus has space, stop doesn't have passengers
     */

    @Test(expected = AssertionError.class)
    public void canPickUpPassenger() {
        busStop.add(new Person());
        bus.pickUp(busStop);
        assertEquals(0, busStop.queueLength());
        assertEquals(1, bus.numberOfPassengers());
    }

    @Test(expected = AssertionError.class)
    public void cannotPickUpPassengerWhenBusFull() {
        busStop.add(new Person());
        /* capacity was set to 3 */
        for (int i = 0; i < 3; i++)
            bus.addPassenger(new Person());
        bus.pickUp(busStop);
        assertEquals(1, busStop.queueLength());
        assertEquals(3, bus.numberOfPassengers());
    }

    @Test
    public void cannotPickUpPassengerWhenStopEmpty() {
        bus.addPassenger(new Person());
        bus.pickUp(busStop);
        assertEquals(0, busStop.queueLength());
        assertEquals(1, bus.numberOfPassengers());
    }
}

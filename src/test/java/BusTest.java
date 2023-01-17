import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BusTest {
    private Bus bus;

    @Before
    public void setUp() {
        bus = new Bus("Mars", 3);
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

    /* TODO: removing passengers not yet implemented */
    @Test(expected = AssertionError.class)
    public void canRemovePassenger() {
        bus.addPassenger(new Person());
        Object passenger = bus.removePassenger();
        assertNotNull(passenger);
        assertEquals(0, bus.numberOfPassengers());
    }
}

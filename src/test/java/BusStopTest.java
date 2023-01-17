import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BusStopTest {
    private BusStop busStop;

    @Before
    public void setUp() {
        busStop = new BusStop("Lothian Road");
    }

    @Test
    public void hasName() {
        assertEquals("Lothian Road", busStop.getName());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, busStop.queueLength());
    }

//    @Test(expected = AssertionError.class)
    @Test
    public void canAddPassenger() {
        busStop.add(new Person());
        assertEquals(1, busStop.queueLength());
    }

//    @Test(expected = AssertionError.class)
    @Test
    public void canRemovePassenger() {
        busStop.add(new Person());
        Person p = busStop.remove();
        assertNotNull(p);
        assertEquals(0, busStop.queueLength());
    }

    @Test
    public void removeReturnsNullWhenStopEmpty() {
        var p = busStop.remove();
        assertNull(p);
    }

//    @Test(expected = AssertionError.class)
    @Test
    public void queueIsFifo() {
        Person[] people = new Person[3];
        for (int idx = 0; idx < people.length; idx++)
            people[idx] = new Person();
        for (var person : people)
            busStop.add(person);
        /* the people should be removed in the same order they were added */
        for (var person : people)
            assertEquals(person, busStop.remove());
    }
}

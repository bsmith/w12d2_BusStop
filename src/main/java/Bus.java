import java.util.ArrayList;
import java.util.List;

public class Bus {
    private final String destination;
    private final int capacity;
    private final List<Person> passengers;

    public Bus(String destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public int numberOfPassengers() {
        return passengers.size();
    }

    public boolean addPassenger(Person p) {
        if (this.numberOfPassengers() < this.capacity)
            return passengers.add(p);
        return false;
    }

    public String getDestination() {
        return destination;
    }

    public Person removePassenger() {
        /* FIFO ordering */
        return this.passengers.remove(0);
    }

    public void pickUp(BusStop busStop) {
        if (this.numberOfPassengers() < this.capacity) {
            var p = busStop.remove();
            if (p != null && !this.addPassenger(p))
                throw new RuntimeException("Adding passenger failed unexpectedly");
        }
    }
}

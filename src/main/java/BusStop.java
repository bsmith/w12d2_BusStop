import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private final String name;
    private final List<Person> queue;

    public BusStop(String name) {
        this.name = name;
        this.queue = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int queueLength() {
        /* TODO: unimplemented */
        return 0;
    }

    public void add(Person person) {
        /* TODO: unimplemented */
    }

    public Person remove() {
        /* TODO: unimplemented */
        return null;
    }
}

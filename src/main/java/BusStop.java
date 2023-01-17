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
        return queue.size();
    }

    public void add(Person person) {
        queue.add(person);
    }

    public Person remove() {
        if (queue.size() > 0)
            return queue.remove(0);
        else
            return null;
    }
}

package md.utm;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();
    private final HashMap<Long, Person> person = new HashMap<>();

    @RequestMapping(path = "/persons/{personId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("personId") long personId) {
        return person.get(personId);
    }

    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public HashMap<Long, Person> getPersons() {
        return person;
    }

    @RequestMapping(path = "/persons", method = RequestMethod.POST)
    public void createPerson(@RequestBody Person person) {
        person.setId(counter.incrementAndGet());
        this.person.put(person.getId(), person);
    }
}

package avp.com.spring_mvc_dao.dao;

import avp.com.spring_mvc_dao.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Vavan"));
        people.add(new Person(++PEOPLE_COUNT, "Artur"));
        people.add(new Person(++PEOPLE_COUNT, "Vasia"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

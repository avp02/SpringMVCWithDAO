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
        people.add(new Person(++PEOPLE_COUNT, "Tom", 33, "desant@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Vavan", 37, "vpetranovs@gmail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Artur", 27, "artur@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vasia", 19, "vasia123@maul.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

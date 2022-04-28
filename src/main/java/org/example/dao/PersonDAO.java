package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static int PEOPLE_COUNT=0;
    private List<Person> people;

    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Kuzma", 20, "kuzma@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Regina", 20, "regina@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Aynur",20,"aynur@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person p = show(id);
        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}

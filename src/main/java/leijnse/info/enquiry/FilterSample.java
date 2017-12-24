package leijnse.info.enquiry;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilterSample {
    // http://guidogarcia.net/blog/2011/10/29/java-different-ways-filter-collection/

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    private List<Person> people= new ArrayList<Person>();



    private interface Predicate<T> { boolean apply(T type); }

    private static <T> Collection<T> filter(Collection<T> col, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<T>();
        for (T element: col) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public void addPerson(int age, Person.Gender gender){
        Person p1 = new Person(age, gender);
        people.add(p1);
    }

    public Collection<Person>  filterPersonMaleGT21(){


        // How would you create a new Collection containing only men over 21?
        Predicate<Person> validPersonPredicate = new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getAge() > 21 && person.getSex() == Person.Gender.MALE;
            }
        };

        Collection<Person> result = filter(people, validPersonPredicate);
        return result;
    }


}

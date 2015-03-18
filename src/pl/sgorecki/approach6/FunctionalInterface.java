package pl.sgorecki.approach6;

import pl.sgorecki.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class FunctionalInterface {
    public static void printPersons(List<Person> persons, Predicate<Person> tester) {
        for (Person p : persons) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}

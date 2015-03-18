package pl.sgorecki.approach3;

import pl.sgorecki.Person;

import java.util.List;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class SearchCriteriaInLocalClass {

    public static void printPersons(List<Person> persons, CheckPerson tester) {
        for (Person p : persons) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}

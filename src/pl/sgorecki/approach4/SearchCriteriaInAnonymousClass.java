package pl.sgorecki.approach4;

import pl.sgorecki.Person;
import java.util.List;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class SearchCriteriaInAnonymousClass {
    public static void printPersons(List<Person> persons, CheckPerson tester) {
        for (Person p : persons) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}

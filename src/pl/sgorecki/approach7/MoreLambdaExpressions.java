package pl.sgorecki.approach7;

import pl.sgorecki.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class MoreLambdaExpressions {
    public static void processPersons(List<Person> persons, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : persons) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFuntion(List<Person> persons, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : persons) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}

package pl.sgorecki;

import pl.sgorecki.approach3.CheckPersonEligibleForSelectiveService;
import pl.sgorecki.approach3.SearchCriteriaInLocalClass;
import pl.sgorecki.approach4.CheckPerson;
import pl.sgorecki.approach4.SearchCriteriaInAnonymousClass;
import pl.sgorecki.approach7.MoreLambdaExpressions;
import pl.sgorecki.approach8.LambdaWithGenerics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {


    // examples from: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Sebastian", LocalDate.of(1984, 2, 18), Person.Sex.MALE, "sebastian123gmail.com"),
                new Person("Ania", LocalDate.of(1985, 2, 5), Person.Sex.FEMALE, "annamaria123@gmail.com"),
                new Person("Bartek", LocalDate.of(1996, 1, 1), Person.Sex.MALE, "bartek@o2.pl"),
                new Person("Wojtek", LocalDate.of(1990, 5, 5), Person.Sex.MALE, "wojtek@o2.pl")
        );

        System.out.println("Approach3: Specify Search Criteria Code in a Local Class");
        SearchCriteriaInLocalClass.printPersons(persons, new CheckPersonEligibleForSelectiveService());
        System.out.println("Weak spots: need of additional code (interfaces, local class for each search criteria)\n");

        System.out.println("Approach4: Specify Search Criteria Code in an Anonymous Class");
        SearchCriteriaInAnonymousClass.printPersons(persons, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25;
            }
        });
        System.out.println("Weak spots: the syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method\n");

        System.out.println("Approach5: Specify Search Criteria Code with a Lambda Expression");
        SearchCriteriaInAnonymousClass.printPersons(persons,
                (Person p) -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25
        );
        System.out.println("");

        System.out.println("Appproach6: Use Standard Functional Interfaces with Lambda Expressions");
        pl.sgorecki.approach6.FunctionalInterface.printPersons(persons,
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25
        );
        System.out.println("");

        System.out.println("Approach7: Use Lambda Expressions Throughout Your Application");
        MoreLambdaExpressions.processPersons(persons,
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25,
                p -> p.printPerson()
        );
        System.out.println("...and more");
        MoreLambdaExpressions.processPersonsWithFuntion(persons,
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println("");

        System.out.println("Approach8: Use Generics More Extensively");
        LambdaWithGenerics.processElements(persons,
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println("");

        System.out.println("Approach9: Use Aggregate Operations That Accept Lambda Expressions as Parameters");
        persons.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }
}

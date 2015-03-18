package pl.sgorecki.approach3;

import pl.sgorecki.Person;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}

package pl.sgorecki.approach8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Sebastian Górecki <gorecki.sebastian@gmail.com>
 */
public class LambdaWithGenerics {
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {

        for (X e : source) {
            if (tester.test(e)) {
                Y data = mapper.apply(e);
                block.accept(data);
            }
        }
    }
}

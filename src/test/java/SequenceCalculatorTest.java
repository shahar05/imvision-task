import company.com.SequenceCalculator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static org.junit.Assert.*;

public class SequenceCalculatorTest {
    Function<Integer, Integer> integerFunctionExponent = currentValue -> currentValue * currentValue;
    List<Integer> actualResult = new ArrayList<>();
    List<Integer> resultList;
    int n = 100;

    @org.junit.Before
    public void setUp(){
        for (int i = 0; i < n ; i++) {
            actualResult.add(integerFunctionExponent.apply(i));
        }
    }

    @org.junit.After
    public void tearDown(){
        actualResult = null;
        resultList = null;
    }

    @Test
    void call() {
        resultList = SequenceCalculator.calculate(integerFunctionExponent , n);
        for (int i = 0; i < actualResult.size(); i++) {
            assertEquals(resultList.get(i) , actualResult.get(i));
        }
    }
}
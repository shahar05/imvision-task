package company.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;


public class CalcSegmentCallable <T extends Number> implements Callable<List<T>> {
    int startIndex , size ;
    Function<Integer , T> mathFunction;

    public CalcSegmentCallable(int startIndex, int size, Function<Integer, T> mathFunction) {
        this.startIndex = startIndex;
        this.size = size;
        this.mathFunction = mathFunction;
    }

    public List<T> call()  {
        List<T> R = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            R.add(mathFunction.apply(startIndex++));
        }
        return R;
    }
}
package company.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class SequenceCalculator {    final static int numOfThreads = 5;

    public static <T extends Number> List<T> calculate(Function<Integer, T> K, int n) {
        ExecutorService myExecutor = Executors.newFixedThreadPool(numOfThreads);
        int segmentSize = n / numOfThreads;
        List<T> R = new ArrayList<>();
        List<Future<List<T>>> futureList = new ArrayList<>();

        for (int i = 0, startIndex = 1; i < numOfThreads; i++, startIndex += segmentSize) {
            if (i == numOfThreads - 1 && n % numOfThreads != 0) {
                segmentSize += n % numOfThreads;
            }
            futureList.add(myExecutor.submit(new CalcSegmentCallable<>(startIndex, segmentSize, K)));
        }
        try {
            for (int i = 0; i < numOfThreads; i++) {
                R.addAll(futureList.get(i).get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        myExecutor.shutdown();
        return R;
    }
}

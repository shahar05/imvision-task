package company.com;

import java.util.Scanner;
import java.util.function.Function;


public class  UIMenu {
    static Scanner scanner = new Scanner(System.in);
    static int functionType;
    static int n;
    static Function<Integer, Integer> integerFunctionExponent = currentValue -> currentValue * currentValue;
    static Function<Integer, Float> floatFunctionExponent = currentValue -> (float) currentValue * currentValue;
    static Function<Integer, Double> doubleFunctionExponent = currentValue -> (double) currentValue * currentValue;
    static Function<Integer, Integer> divideBy2IntegerFunction = currentValue -> currentValue / 2;
    static Function<Integer, Float> divideBy2FloatFunction = currentValue -> (float) currentValue / 2;
    static Function<Integer, Double> divideBy2DoubleFunction = currentValue -> (double) currentValue / 2;

    private static void print_welcome() {
        System.out.println("Hi, Please choose function:");
        System.out.println(" 1. Exponent Int \n 2. Exponent Float \n 3.Exponent Double \n " +
                "4.divide by 2 Int \n 5.divide by 2 Float \n 6.divide by 2 Double \n");
        functionType = scanner.nextInt();
        System.out.println("Choose n:");
        n = scanner.nextInt();
    }

    public static <T extends Number> void start() {
        print_welcome();
        switch (functionType) {
            case 1:
                SequenceCalculator.calculate(integerFunctionExponent, n).forEach(System.out::println);
                scanner.close();
                break;
            case 2:
                SequenceCalculator.calculate(floatFunctionExponent, n).forEach(System.out::println);
                scanner.close();
                break;
            case 3:
                SequenceCalculator.calculate(doubleFunctionExponent, n).forEach(System.out::println);
                scanner.close();
                break;
            case 4:
                SequenceCalculator.calculate(divideBy2IntegerFunction, n).forEach(System.out::println);
                scanner.close();
                break;
            case 5:
                SequenceCalculator.calculate(divideBy2FloatFunction, n).forEach(System.out::println);
                scanner.close();
                break;
            case 6:
                SequenceCalculator.calculate(divideBy2DoubleFunction, n).forEach(System.out::println);
                scanner.close();
                break;
            default:
                System.out.println("Error: Please choose number between 1 to 6");
                start();
                break;
        }
    }
}

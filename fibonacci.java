/****
Fibonacci sequence
The Fibonacci Sequence is the series of numbers:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
The next number is found by adding up the two numbers before it.

Implements memoization (caching pre-calculated results) after watching a
YouTube video about the concept: https://www.youtube.com/watch?v=P8Xa2BitN3I
*/

import java.util.*;

public class fibonacci{

    private static Map<Integer, Integer> memoization = new HashMap<>();

    private static int fibonacci(int number){
        if(memoization.containsKey(number)){
            System.out.println("    " + number + " is already calculated, returning " + memoization.get(number));
            return memoization.get(number);
        }

        if(number < 1){
            System.out.println("    " + number + " calculated first time and cached with output of 0");
            memoization.put(number, 0);
            return memoization.get(number);
        }

        if(number == 1){
            System.out.println("    " + number + " calculated first time and cached with output of 1");
            memoization.put(number, 1);
            return memoization.get(number);
        }

        int value = fibonacci(number -1) + fibonacci(number - 2);
        System.out.println("    " + number + " calculated first time and cached with output of " + value);
        memoization.put(number, value);
        return memoization.get(number);
    }

    private static void unitTest(int input, int expectedOutput){
        int actualInput = fibonacci(input);
        if(expectedOutput == actualInput){
            System.out.println("SUCCESS!!!  expected " + expectedOutput + " for input " + input);
        }else{
            System.out.println("FAILURE!!!  expected " + expectedOutput + " for input " + input + " but got " +  actualInput + " instead!");
        }
    }

    public static void main(String[] args){
        unitTest(10, 55);
        unitTest(0, 0);
        unitTest(1, 1);
        unitTest(2, 1);
        unitTest(3, 2);
        unitTest(4, 3);
        unitTest(5, 5);
        unitTest(6, 8);
        unitTest(7, 13);
        unitTest(8, 21);
        unitTest(9, 34);
    }
}

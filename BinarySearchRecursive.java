
import java.util.*;

public class BinarySearchRecursive{

    private static boolean logging = false;

    public static boolean binarySearch(int[] sortedArray, int valueToSearchFor){
        if(logging){
            System.out.println();
            System.out.println("-=-=- LOGGING -=-=-");
            System.out.println("Beginning binarySearch...");
            System.out.print("Searching for " + valueToSearchFor + " in array: {");
            for(int i = 0; i < sortedArray.length; i++){
                if(i != 0){
                    System.out.print(",");
                }
                System.out.print(sortedArray[i]);
            }
            System.out.print("}");
            System.out.println();
        }
        return binarySearch(sortedArray, valueToSearchFor, 0, sortedArray.length - 1);
    }

    private static boolean binarySearch(int[] sortedArray, int valueToSearchFor, int leftIndex, int rightIndex){
        if(logging){
            System.out.print("Searching for " + valueToSearchFor + " within values {");
            for(int i = leftIndex; i < rightIndex + 1; i++){
                if(i != leftIndex){
                    System.out.print(",");
                }
                System.out.print(sortedArray[i]);
            }
            System.out.print("}");
            System.out.println();
        }

        //If the rightIndex is less than the leftIndex, the element isn't in the sorted array
        if(rightIndex < leftIndex){
            if(logging){
                System.out.println("rightIndex(" + rightIndex + ") is smaller than leftIndex(" + leftIndex + ").  Returning false.");
                System.out.println("-=-=- END OF LOGS -=-=-");
                System.out.println();
            }
            return false;
        }

        //Check the middle value of the area we're searching...
        int midpoint = (leftIndex + rightIndex) / 2;
        
        if(logging){
            System.out.println("midpoint is index " + midpoint);
            System.out.println("midpoint contains value " + sortedArray[midpoint]);
        }

        //If we find it, return true
        if(sortedArray[midpoint] == valueToSearchFor){
            if(logging){
                System.out.println("Found valueToSearchFor(" + valueToSearchFor + "), returning true");
                System.out.println("-=-=- END OF LOGS -=-=-");
                System.out.println();
            }
            return true;
        }

        //If our value is LARGER than the midpoint value, change the leftIndex
        if(sortedArray[midpoint] < valueToSearchFor){
            if(logging){
                System.out.println("Recursively searching to the right.");
            }
            return binarySearch(sortedArray, valueToSearchFor, midpoint + 1, rightIndex);
        }

        //If our value is SMALLER than the midpoint value, change the rightIndex
        if(sortedArray[midpoint] > valueToSearchFor){
             if(logging){
                 System.out.println("Recursively searching to the left.");
             }
            return binarySearch(sortedArray, valueToSearchFor, leftIndex, midpoint - 1);
        }
        if(logging){
            System.out.println("-=-=-=- Catastrophic failure, should not have reached end of method -=-=-=-");
            System.out.println("-=-=- END OF LOGS -=-=-");
            System.out.println();
        }
        //Shouldn't reach here
        return false;
    }

    private static void unitTest(int[] sortedArray, int valueToSearchFor, boolean expectedOutput){
        boolean actualOutput = binarySearch(sortedArray, valueToSearchFor);
        if(actualOutput == expectedOutput){
            System.out.println("SUCCESS!!!");
        }else{
            System.out.println("FAILURE!!!");
        }
        System.out.println("    valueToSearchFor: " + valueToSearchFor);
        System.out.print("    SortedArray: ");
        for(int i = 0; i < sortedArray.length; i++){
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
        System.out.println("    expected     actual");
        System.out.println("    " + expectedOutput + "         " + actualOutput);
    }

    public static void main(String args[]){
        //To turn on logging, run this program with the commandline argument "logging"
        // java BinarySearchRecursive logging
        if(args.length > 0 && args[0].equalsIgnoreCase("logging")){
            logging = true;
        }
        int[] sortedArray = {0, 1, 2, 4, 5, 7, 8, 9};
        unitTest(sortedArray, 4, true);
        unitTest(sortedArray, 3, false);
        unitTest(sortedArray, -1, false);
        unitTest(sortedArray, 12, false);
        unitTest(sortedArray, 5, true);
    }

}

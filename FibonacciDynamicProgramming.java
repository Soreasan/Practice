

public class FibonacciDynamicProgramming{

    private static int[] expectedResults = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
    
    private static int fibonacci(int n){
        int prev2 = 0;
        int prev1 = 1;
        if(n == 0){
            return prev2;
        }
        if(n == 1){
            return prev1;
        }
        for(int index = 2; index < n; index++){
            int temp = prev2 + prev1;
            prev2 = prev1;
            prev1 = temp;
        }
        return prev2 + prev1;
    }

    public static void main(String[] args){
        for(int i = 0; i < expectedResults.length; i++){
            if(expectedResults[i] == fibonacci(i)){
                System.out.println("SUCCESS!");
                System.out.println("    " + i + " = " + expectedResults[i]);
            }else{
                System.out.println("FAILURE!");
                System.out.println("    " + i + " = " + expectedResults[i]);
                System.out.println("    but output was " + fibonacci(i) + " instead!");
            }
        }
    }
}

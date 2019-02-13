//Iterative implementation of Binary Serch with simpler test cases.  

public class BinarySearchIterative{
    
    private static boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid = right / 2;
        while(left <= right){
            if(left < 0){
                return false;
            }
            if(right >= arr.length){
                return false;
            }
            if(arr[mid] == target){
                return true;
            }
            if(target < arr[mid]){
                right = mid - 1;
            }
            if(target > arr[mid]){
                left = mid + 1;
            }
            mid = (left + right)/2;;
        }
        return false;
    }

    private static void test(int[] arr, int target, boolean expectedResult){
        if(expectedResult == binarySearch(arr, target)){
            System.out.println("SUCCESS!");
        }else{
            System.out.println("FAILURE!");
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 4, 8};
        test(arr, 1, true);
        test(arr, 0, false);
        test(arr, 9, false);
        test(arr, 3, false);
        test(arr, 8, true);
    }
}

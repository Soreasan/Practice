/*
 *  Cracking the Coding Interview Chapter 1 Interview Question 1.1
 *  1.1 Is Unique: Implement an algorithm to determine if a string
 *      has all unique characters.  What if you cannot use additional
 *      data structures?  
 **/

import java.util.*;

public class StringIsUnique{
    
    //First approach, iterate through the string using a FOR loop and charAt.
    //Since we go through each character once the Big O is O(n) where n is the Number of characters in String
    private static boolean stringIsUnique(String string){
        //If the input is null just return false
        if(null == string){
            return false;
        }
        //We will use a set to store each letter of the String.  If there are any duplicates return false.
        Set<Character> uniqueChars = new HashSet<>();
        for(int i = 0; i < string.length(); i++){
            //If there are duplicate letters return false
            if(uniqueChars.contains(string.charAt(i))){
                return false;
            }
            //Add the letter to the set
            uniqueChars.add(string.charAt(i));
        }
        //If we didn't encounter any duplicates return true;
        return true;
    }

    //Second approach, iterate through without using additional data structures
    //This is a brute force approach, the Big(O) is O(n^2) because we do N x N calculations
    private static boolean stringIsUnique2(String string){
        if(null == string){
            return false;
        }
        for(int currentIndex = 0; currentIndex < string.length(); currentIndex++){
            for(int letterToCompare = currentIndex + 1; letterToCompare < string.length(); letterToCompare++){
                if(string.charAt(currentIndex) == string.charAt(letterToCompare)){
                    return false;
                }
            }
        }
        return true;
    }

    //Ghetto version of Junit for my tests.  
    public static void test(String string, boolean expectedOutput){
        boolean actualOutput = stringIsUnique2(string);
        if(actualOutput == expectedOutput){
            System.out.println("SUCCESS!!!  " + string + " should be " + expectedOutput + " and it is!!!");
        }else{
            System.out.println("FAILURE!!!  " + string + " should be " + expectedOutput + " and it isn't!!!");
        }
    }

    //I'm just using this to run my test method.  
    public static void main(String args[]){
        test("apple", false);
        test("true", true);
        test(" two spaces ", false);
        test(null, false);
        test("", true);
    }
}

/*
Given two strings, write a method to decide if one is a permutation
of the other.
*/

import java.util.*;

class StringPermutation{
    /*
        IF two strings are permutations they will contain the same amount
        of the same letters.  
        First, create two Set<Char, Integer> which contains each character
        AND a count of how many times each character appears.  
        IF the size of the Sets is the same AND each set has the same
        count for each letter, then return true.  
        return false otherwise.  
    */
    public static boolean isPermutation(String s1, String s2){
        //If the strings are different lengths they can't be permutations
        if(s1.length() != s2.length()){
            return false;
        }
        //Move the data from s1 and s2 into a Map
        Map<Character, Integer> map1 = getMap(s1);
        Map<Character, Integer> map2 = getMap(s2);
        //IF the maps have a different amount of keys then they're not permutations
        if(map1.size() != map2.size()){
            return false;
        }

        for(Character myChar : map1.keySet()){
            if(!map2.containsKey(myChar) 
                || map1.get(myChar) != map2.get(myChar)){
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getMap(String string){
        if(null == string || string.length() == 0){
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++){
            if(map.containsKey(string.charAt(i))){
                int count = map.get(string.charAt(i));
                map.put(string.charAt(i), count);
            }else{
                map.put(string.charAt(i), 1);
            }
        }
        return map;
    }

    private static void test(String s1, String s2, boolean expectedResult){
        boolean actualResult = isPermutation(s1, s2);
        if(expectedResult == actualResult){
            System.out.println("success!");
        }else{
            System.out.println("failure!");
        }
    }

    public static void main(String[] args){
        test("hello", "elloh", true);
        test("no", "yes", false);
        test("purple", "purplu", false);
    }
}

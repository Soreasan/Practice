/*
Ice cream parlor problem.  We're given a certain amount of money and
we want to spent all our money and get two seperate flavors of ice cream
Return indices, not values.  (Smaller index first)
Only buy one of each flavor

Ice Cream
Strawberry  $2
Blueberry   $2
Nutella     $13
Vanilla     $5
Banana      $4
Bubblegum   $13
Chocolate   $5

Approaches
Brute force: walk through all pairs O(n^2)
Hashmap, Complement approach: Hashmap Look for complement in hashmap O(n)
    Be careful about reusing items, can't buy same item twice!
Sorting:    sort menu and look via binary search.
    But we need to return the original indices, and sorting will lose those.  
    To solve that issue we can create a struct or class
    class MenuItem{
        int cost;
        int index;
    }
    Create a copy of the menu

Code was mostly taken from YouTube "Algorithms: Solve 'Ice Cream Parlor' Using Binary Search"
https://www.youtube.com/watch?v=Ifwf3DBN1sc
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamParlor{

    public static int indexOf(int[] menu, int value, int excludeThis){
        for(int i = 0; i < menu.length; i++){
            if(menu[i] == value && i != excludeThis){
                return i;
            }
        }
        return -1;
    }

    public static int[] getIndicesFromValues(int[] menu, int value1, int value2){
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    /* Finds the indices of two items on the menu that allows us to spend all our money.  */
    public static int[] findChoices(int[] menu, int money){
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for(int i = 0; i < sortedMenu.length; i++){
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if(location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement){
                int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }
        return null;
    }

    private static void unitTest(int[] iceCreamPrices, int money, int expectedFirstIndex, int expectedSecondIndex){
        int[] output = findChoices(iceCreamPrices, money);
        System.out.println();
        int actualFirstIndex = output[0];
        int actualSecondIndex = output[1];
        if(actualFirstIndex == expectedFirstIndex && actualSecondIndex == expectedSecondIndex){
            System.out.println("SUCCESS!!!");
        }else{
            System.out.println("FAILURE!!!");
        }
        System.out.println("    money = " + money);
        System.out.print("    index: ");
        for(int i = 0; i < iceCreamPrices.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("    value: ");
        for(int i = 0; i < iceCreamPrices.length; i++){
            System.out.print(iceCreamPrices[i] + " ");
        }
        System.out.println();
        System.out.println("           expected    actual"); 
        System.out.println("    first  " + expectedFirstIndex + "            " + actualFirstIndex);
        System.out.println("    second " + expectedSecondIndex + "            " + actualSecondIndex);
    }

    public static void main(String[] args){
        int[] iceCreamPrices = {2, 2, 9, 5, 4, 9, 5};
        unitTest(iceCreamPrices, 4, 0, 1);
        unitTest(iceCreamPrices, 10, 3, 6);
        unitTest(iceCreamPrices, 7, 0, 3);
        unitTest(iceCreamPrices, 18, 2, 5);

        int[] iceCreamPrices2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        unitTest(iceCreamPrices2, 9, 0, 9);
    }
}

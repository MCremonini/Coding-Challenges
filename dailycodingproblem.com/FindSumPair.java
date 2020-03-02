import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */
public class FindSumPair {

    public static void main(String[] args) {
        
        int[] arr1 = {10, 15, 3, 7};
        int target = 17;
        
        // solution 1: with sorting
        Arrays.sort(arr1);
        
        int i1 = 0, i2 = arr1.length - 1, curr;
        while (i1 < arr1.length && i2 >= 0) {
            curr = target - (arr1[i1] + arr1[i2]);
            
            if (curr > 0) {
                i1++;
            } else if (curr < 0) {
                i2--;
            } else {
                System.out.println(target + " = " + arr1[i1] + " + " + arr1[i2]);      
                break;
            }
        }
        
        
        // solution 2: one pass using hashmap
        int[] arr = {10, 15, 3, 7};
        Map<Integer, Integer> map = new HashMap<>();
        int fr = arr.length;
        for (int i = 0; i < fr; i++) {
            int diff = target - arr[i];
            
            if (map.get(arr[i]) != null) {
                System.out.println(target + " = " + arr[i] + " + " + map.get(arr[i]));
            } else {
                map.put(diff, arr[i]);                
            }
        }
    }
}

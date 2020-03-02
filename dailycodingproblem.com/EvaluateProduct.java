import java.util.Arrays;

/*
 * This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class EvaluateProduct {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int length = arr1.length;
        
        // solution 1: with div and assuming arr1.length > 1 and no zero values
        int totProduct = 1;
        for (int i = 0; i < length; i++) {
            totProduct *= arr1[i];
        }
        int [] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = totProduct / arr1[i];
        }
        System.out.println(Arrays.toString(res));
        
        
        // solution 2: no div, same assumptions
        int prodAsc = arr1[0];
        int prodDesc = arr1[length-1];
        int [] res2 = new int[length];
        Arrays.fill(res2, 1);
        for (int i = 1; i < length; i++) {
            res2[i] *= prodAsc;
            prodAsc *= arr1[i];
            
            res2[length - 1 - i] *= prodDesc;
            prodDesc *= arr1[length - 1 - i];
        }
        System.out.println(Arrays.toString(res2));
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
given two arrays, find the pair of numbers (one per array) that sum is closest to a given target
*/

public class ClosestSumPair {

    static public class Coppia {
        public Coppia(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        int v1, v2;       
    }
    
    public static void main(String[] args) {
                
        
/*        int[] arr1 = {-1, 3, 8, 2, 9, 5};
        int[] arr2 = {4, 1, 2, 10, 5, 20};
        int target = 24;
        // closestSumPair(arr1, arr2, target) should return {5, 20} or {3, 20}

        int[] arr1 = {7, 4, 1, 10};
        int[] arr2 = {4, 5, 8, 7};
        int target = 13;
        // closestSumPair(b1, b2, bTarget) should return {4, 8}, {7, 7}, {7, 5}, or {10, 4}*/
      
/*        int[] arr1 = {6, 8, -1, -8, -3};
        int[] arr2 = {4, -6, 2, 9, -3};
        int target = 3;*/
        // closestSumPair(c1, c2, cTarget) should return {-1, 4} or {6, -3}
        
        int[] arr1 = {19, 14, 6, 11, -16, 14, -16, -9, 16, 13};
        int[] arr2 = {13, 9, -15, -2, -18, 16, 17, 2, -11, -7};
        int target = -15;
        // closestSumPair(d1, d2, dTarget) should return {-16, 2}, {-9, -7}
        
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        
        List<Coppia> res = new ArrayList<>();
        
        int diff = Integer.MAX_VALUE, curr;
        int tmp, i1 = 0, i2 = arr1.length - 1;
        while (i1 < arr1.length && i2 >= 0) {
            curr =target - (arr1[i1] + arr2[i2]);
            tmp = Math.abs(curr);
                    
            if (tmp < diff) {
                diff = tmp;
                res.clear();
                res.add(new Coppia(arr1[i1], arr2[i2]));           
            } else if (tmp == diff) {
                res.add(new Coppia(arr1[i1], arr2[i2]));
            }
            
            if (curr > 0) {
                i1++;
            } else {
                i2--;
            }
        }
            
        res.stream().forEach(c -> System.out.print("(" + c.v1 + ", " + c.v2 + ")"));
    }
}

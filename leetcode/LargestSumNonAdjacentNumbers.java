import java.util.Arrays;

/*
 * This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
 */
public class LargestSumNonAdjacentNumbers {

    public static int solution(int []nums) {
        System.out.println(Arrays.toString(nums));

        for (int i = 2; i < nums.length; i++) {
            
            int prev = (i-3 >= 0) ? nums[i-3] : 0;
            nums[i] += Math.max(nums[i-2], prev);
        }
        int l = nums.length;
        if (l > 1) {
            return Math.max(nums[l-1], nums[l-2]);
        } else if (l == 1) {
            return nums[0];
        }
        return 0;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = new int[]{5, 11, 7, 15};
        System.out.println(solution(arr) == 26);
        
        arr = new int[]{5, 11, 5, 9, 11};
        System.out.println(solution(arr) == 22);
        
        arr = new int[]{4, 6, 3, 5, 7, 4};
        System.out.println(solution(arr) == 15);
        
        arr = new int[]{21};
        System.out.println(solution(arr) == 21);
        
        arr = new int[]{21, 23};
        System.out.println(solution(arr) == 23);
        
        arr = new int[]{23, 21};
        System.out.println(solution(arr) == 23);
           
        arr = new int[]{5, 1, 1, 5};
        System.out.println(solution(arr) == 10);
        
        arr = new int[]{5, 1, 1, 5, 10};
        System.out.println(solution(arr) == 16);
        
        arr = new int[]{2, 1, 2, 8, 5};
        System.out.println(solution(arr) == 10);
        
        arr = new int[]{2, 1, 1, 8, 4};
        System.out.println(solution(arr) == 10);
        
        arr = new int[]{4, 6, 3, 5, 7};
        System.out.println(solution(arr) == 14);
        
        arr = new int[]{2, 6, 3, 5, 7};
        System.out.println(solution(arr) == 13);
        
        arr = new int[]{2, 6, 3, 5, 7, 4};
        System.out.println(solution(arr) == 15);
        
        arr = new int[]{2, 9, 3, 8, 7};
        System.out.println(solution(arr) == 17);
        
        arr = new int[]{2, 1, 2, 8, 7, 11};
        System.out.println(solution(arr) == 21);
        
        arr = new int[]{5, 6, 7, 5};
        System.out.println(solution(arr) == 12);
        
        arr = new int[]{5, 1, 7, 15};
        System.out.println(solution(arr) == 20);
        
        arr = new int[]{7, 6, 5, 4};
        System.out.println(solution(arr) == 12);
        
        arr = new int[]{7, 6, 5, 1, 2, 4};
        System.out.println(solution(arr) == 16);
        
        arr = new int[]{4, 5, 6, 7};
        System.out.println(solution(arr) == 12);
        
        arr = new int[]{4, 5, 9, 7};
        System.out.println(solution(arr) == 13);
        
        arr = new int[]{5, 1, 1, 5, 5};
        System.out.println(solution(arr) == 11);
        
        arr = new int[]{5, 1, 1, 5, 5, 7};
        System.out.println(solution(arr) == 17);
        
        arr = new int[]{2, 4, 6, 2, 5};
        System.out.println(solution(arr) == 13);
    }

}

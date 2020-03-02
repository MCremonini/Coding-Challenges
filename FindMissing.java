/* given two arrays find the missing value */
public class FindMissing {

    public static void main(String[] args) {
                
      
        int[] arr1 = {4, 12, 9, 5, 6};
        int[] arr2 = {4, 9, 12, 6};

        int xor_sum = 0;

        for (int i = 0; i < arr2.length; i++) {
            xor_sum ^= arr2[i];
            //System.out.println(Integer.toBinaryString(arr2[i]) + " > " + Integer.toBinaryString(xor_sum));
        }
        
        for (int i = 0; i < arr1.length; i++) {
            xor_sum ^= arr1[i];
            //System.out.println(Integer.toBinaryString(arr1[i]) + " > " + Integer.toBinaryString(xor_sum));
        }

        
        System.out.print(xor_sum);
    }
}

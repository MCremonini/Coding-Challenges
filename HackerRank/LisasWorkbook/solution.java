import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int ret = 0;
        int countPage = 1;
        for (int i = 0; i < n; i++) {
            
            int chapterPages = arr[i] / k + ((arr[i] % k) > 0 ? 1 : 0);
            int chapterLastPage = chapterPages + countPage - 1;
            
            if (chapterLastPage <= arr[i]) {
                
                int pagesToSkip = (countPage > k) ? countPage / k : 0; 
                for (int j = pagesToSkip; j < chapterPages; j++) {
                
                    int firstExer = j * k + 1;
                    int lastExer = Math.min(arr[i], firstExer + k - 1);    
                    int currPage = countPage + j;
                    
                    if (currPage >= firstExer && currPage <= lastExer) {
                        ret++;
                    }
                    
                }
            }
            countPage = chapterLastPage + 1;
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

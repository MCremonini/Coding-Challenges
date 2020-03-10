package Test;



/*
 * This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

/*
 * 91. Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    static int countDecodings(String s) {
        int res = 0;
        int prev = 0;
        int val = s.charAt(0) - 0x30;
        if (val == 0)
            return 0;
  
        int i = s.length() - 1;
        int prevVal = 0;
        val = s.charAt(i)  - 0x30;
        if (val > 0) {
            res = 1;
        }
        if (i == 0) {
            return res;
        }
        prev = res;
        prevVal = val;
        i--;
        val = s.charAt(i) - 0x30;
        if (val == 1 || (val == 2 && prevVal <= 6)) {
            res += 1;
        }
        if (i == 0) {
            return res;
        }
        
        i--;
        for (; i >= 0; i--) {
            prevVal = val;
            val = s.charAt(i) - 0x30;
            int tmp = res; 
            if (val == 1 || (val == 2 && prevVal <= 6)) {
                if (prevVal != 0) {
                    res += prev;
                }
            } else if (prevVal == 0 && (val >= 3 || val==0)) {
                return 0;
            }
            prev = tmp;
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        String input = "101";
        System.out.println(countDecodings(input) == 1);
        
        input = "012";
        System.out.println(countDecodings(input) == 0);
        
        input = "01";
        System.out.println(countDecodings(input) == 0);
        
        input = "10";  
        System.out.println(countDecodings(input) == 1);
        
        input = "230";  
        System.out.println(countDecodings(input) == 0);
        
        input = "0";  
        System.out.println(countDecodings(input) == 0);
        
        input = "301";  
        System.out.println(countDecodings(input) == 0);
        
        input = "12";  
        System.out.println(countDecodings(input) == 2);
        
        input = "226";  
        System.out.println(countDecodings(input) == 3);

        input = "11212";  
        System.out.println(countDecodings(input) == 8);
        
        input = "1001";  
        System.out.println(countDecodings(input) == 0);
        
        input = "24726";
        System.out.println(countDecodings(input) == 4);
    }

}

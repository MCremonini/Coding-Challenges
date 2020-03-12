import java.util.Scanner;

/*
 * Source: Turing Developers
 * 
 * given a 2d array as input, an element with "1" represent floor, "0" wall. Find the number of rooms.
 * adjacents "1" horizontal or vertical are the same room
 Sample input: 
4
5
11000
11000
00100
00011

Expected output: 3
 */
public class NumOffices {

    public static int numOffices(String[][] grid) {
        int result = 1;
        
        int rows = grid.length;
        char placeholder = 0x40;
        if (rows > 0) {
            int cols = grid[0].length;
            
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col].charAt(0) == '1') {
                        placeholder += 0x01;
                        grid[row][col] = String.valueOf(placeholder);
                    }
                    if (grid[row][col].charAt(0) != '0') {
                        placeholder = grid[row][col].charAt(0);
                        if ((col + 1) < cols && grid[row][col+1].charAt(0) == '1') {
                            grid[row][col+1] = String.valueOf(placeholder);
                        }
                        if ((row + 1) < rows && grid[row+1][col].charAt(0) == '1') {
                            grid[row+1][col] = String.valueOf(placeholder);
                        }
                    }
                }
            }
        }
        result = placeholder - 0x40;
        return result;
    }
    
    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
               matrix[i][j] = String.valueOf(line.charAt(j));  
            }
        }
        sc.close();
        return matrix;
    }
    
    public static void main(String args[])
    {
        int result = numOffices(getMatrix()); 
        System.out.println(result);
    }
}

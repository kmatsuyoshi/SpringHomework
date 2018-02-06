//Team Cookie - Kayli Matsuyoshi, Kevin Lin, Victor Lin
//APCS2 -- Pd1
//HW03 -- I Am Still Searching
//2018-02-02

/* SUMMARY
   In our method we decided to compare the target value to the value at the indices, starting with the value at the upper right-hand corner, array[0][n-1]. We are starting from this value because it is the first pivotal point of comparison, meaning that it is the largest value in its own row, but the smallest value in its own row. Anything to the left of it will be less than it, and anything greater than it will be below it.
   By using a while loop, we are able to make repetitive comparisons depending on if the value at the index is equal to the target. The while loop returns (-1,-1) if no matches are made, and returns the coordinates once the target is found.
*/

public class MatrixFinder {

  public static String find(int[][] matrix, int target) {
    int column = matrix[0].length-1;
    int row = 0;
    while (row < matrix.length && column >= 0) {
      if (matrix[row][column] == target) {return "(" + row + "," + column + ")";}
      if (matrix[row][column] > target) {column -= 1;}
      else {row += 1;}
    }
    return "(-1,-1)";
    
  }

  public static void main(String[] args) {

    int[][] matrix = { {1,2,3,4},
                       {2,3,4,5},
                       {3,4,5,6},
                       {4,5,6,7} };

    int[][] matrix2 = { { 2, 4, 6, 8},
                        {10,12,14,16},
                        {18,20,22,24},
                        {26,28,30,32} };

    long startTime = System.nanoTime();
    System.out.println(MatrixFinder.find(matrix,5)); //(1,3)
    long endTime = System.nanoTime();
    long difference = endTime - startTime;

    System.out.println( difference );
    
    System.out.println(MatrixFinder.find(matrix2,3)); //(-1,-1)

    int[][] matrix3 = { { 2, 4, 6, 8,10},
                        {12,14,16,18,20},
                        {22,24,26,28,30},
                        {32,34,36,38,40},
			{42,44,46,48,50}};

    startTime = System.nanoTime();
    System.out.println(MatrixFinder.find(matrix3,36)); //(3,2)
    endTime = System.nanoTime();
    difference = endTime - startTime;
    System.out.println( difference );
    
  }

}

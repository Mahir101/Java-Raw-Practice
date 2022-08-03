// wrote a semi efficient solution
// we could use binary search to find out the solution easily
// remember when you are in a column remember that the column is sorted
// when you are in row remember that the row is sorted
// hence we can make it more efficient using binary search 


public int getPosition(int[][] mat, int colSize, int rowSize, int target) {

           int col = colSize-1, row = 0;
           while(col>=0 || row<rowSize) {
if(!isValid(row, col)) break;

                 if(mat[row][col] == target) {
                       return new Int[] { row, col};
else if(mat[row][col] < target) {
      row++;  
}  else {
   col--;      
}
 }

boolean isValid(int row, int col) {
    return row<rowSize && col>=0;
}


}
           



}

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] generatedmatrix=generateMatrix(3);
        for (int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                System.out.println("Spiral matrix"+generatedmatrix[i][j]);
            }
        }

    }
    public  static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int num = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;

            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                if (rowEnd >= rowStart) {
                    matrix[rowEnd][i] = num++;
                }

            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    matrix[i][colStart] = num++;
                }
            }
            colStart++;
        }
            return matrix;
        }
    }

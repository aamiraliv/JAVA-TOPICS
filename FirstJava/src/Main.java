public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 4},
                {4, 5, 3},
                {7, 4, 3}
        };

        System.out.println("the matrix is : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int element = matrix[2][1];
        System.out.println("matrix element in [2] and [1] is : " + element);

        matrix[2][1] = 10;
        System.out.println("\nupdated matrix is :");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

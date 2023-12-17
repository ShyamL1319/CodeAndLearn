import java.util.Scanner;

/**
 * Date: 17/12/2023:12:55
 * User: shyamlal
 */
public class MatrixOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix a = new Matrix(2, 3);  // 10 rows, 5 columns
        a.input(sc);
        Matrix b = new Matrix(2, 3);  // 10 rows, 5 columns
        b.input(sc);
        Matrix c1 = a.add(b);
        Matrix c2 = a.subtract(b);
        Matrix c3 = a.transpose();
        c1.print();
        c2.print();
        c3.print();
    }
}

class Matrix {
    // Define properties here
    int rows;
    int columns;
    int[][] arr;

    // Define constructor here
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new int[rows][columns];
    }

    void input(Scanner sc) {
        // Use the Scanner object passed as argument for taking input and not a new Scanner object
        // Complete the function
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                this.arr[i][j] = sc.nextInt();
            }

        }
    }

    Matrix add(Matrix x) {
        // Complete the
        Matrix result = new Matrix(x.rows, x.columns);
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                result.arr[i][j] = this.arr[i][j] + x.arr[i][j];
            }
        }

        return result;
    }

    Matrix subtract(Matrix x) {
        // Complete the function
        Matrix result = new Matrix(x.rows, x.columns);
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                result.arr[i][j] = this.arr[i][j] - x.arr[i][j];
            }
        }

        return result;
    }

    Matrix transpose() {
        // Complete the function
        Matrix result = new Matrix(this.columns, this.rows);
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                result.arr[j][i] = this.arr[i][j];
            }
        }

        return result;
    }

    void print() {
        // Complete the function
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

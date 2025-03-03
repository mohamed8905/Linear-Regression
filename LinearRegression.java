
import java.util.Scanner;
import Jama.Matrix;

public class LinearRegression {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = input.nextInt();
//        X Y X2 XY
        double [][] p = new double[n][5];
        for (int i = 0; i < n; i++) {
            System.out.println("Point no. " + (i+1) + ": ");
            System.out.print("Enter X axis: ");
            p[i][0] = input.nextDouble();
            System.out.print("Enter Y axis: ");
            p[i][1] = input.nextDouble();
            System.out.println("---------------");
            p[i][2] = p[i][0]*p[i][0];
            p[i][3] = p[i][0]*p[i][1];
        }
        double SX = 0, SY = 0, SX2 = 0, SXY = 0;
        for (int i = 0; i < n; i++) {
            SX += p[i][0];
            SY += p[i][1];
            SX2 += p[i][2];
            SXY += p[i][3];
        }
        double [][] A = new double[2][2];
        A[0][0] = n;
        A[0][1] = SX;
        A[1][0] = SX;
        A[1][1] = SX2;
        Matrix MA = new Matrix(A);
        double [][] B = new double[2][1];
        B[0][0] = SY;
        B[1][0] = SXY;
        Matrix MB = new Matrix(B);

        Matrix ANS = MA.inverse().times(MB);
        double a0 = ANS.get(0, 0);
        double a1 = ANS.get(1, 0);

        System.out.println("The Linear Equation is: ");
        System.out.println("Y = " + a0 + " + " + a1 + " X");

    }
}

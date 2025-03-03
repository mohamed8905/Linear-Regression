package org.example;

import java.util.Scanner;

public class LinearRegression {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = input.nextInt();

        double [][] p = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("Point no. " + (i+1) + ": ");
            System.out.print("Enter X axis: ");
            p[i][0] = input.nextDouble();
            System.out.print("Enter Y axis: ");
            p[i][1] = input.nextDouble();
            System.out.println("---------------");
        }
        LRwMatrix LR = new LRwMatrix(p);
        LR.display();
        System.out.println();
        LRwIter LR2 = new LRwIter(p,0.1);
        LR2.display();


    }
}

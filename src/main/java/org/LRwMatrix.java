package org;

import Jama.Matrix;
import java.text.DecimalFormat;

public class LRwMatrix {
    double a0, a1;
    double [][] p;

    LRwMatrix(double [][] p) {
        this.p = p;
        solve();
    }

    void solve() {
        int n = this.p.length;
        double [][] pn = new double[n][2];

        for (int i = 0; i < n; i++) {
            pn[i][0] = this.p[i][0]*this.p[i][0];
            pn[i][1] = this.p[i][0]*this.p[i][1];
        }

        double SX = 0, SY = 0, SX2 = 0, SXY = 0;
        for (int i = 0; i < n; i++) {
            SX += this.p[i][0];
            SY += this.p[i][1];
            SX2 += pn[i][0];
            SXY += pn[i][1];
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
        this.a0 = ANS.get(0, 0);
        this.a1 = ANS.get(1, 0);
    }

    void display() {
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("The Linear Equation is: ");
        System.out.println("Y = " + df.format(this.a0) + " + " + df.format(this.a1) + " X");
    }
}
